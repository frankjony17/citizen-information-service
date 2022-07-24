package br.com.company.fks.repositorio.custom;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.dto.FiltroPedidoDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.repositorio.base.RepositorioGenerico;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.utils.QueryUtil;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static br.com.company.fks.repositorio.utils.PedidoCustomRepositorioUtils.*;

@Repository
public class PedidoCustomRepositorio extends RepositorioGenerico<Pedido, Long> {

    private static final String IG_PERFIL = "igPerfil";
    private static final String NAO_IG_CLAUSULA = "naoIgnoraClausula";
    private static final String PERFIL = "perfil";
    
    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private ArmazenamentoArquivoCustomRepositorio a;

    @Value("${siape.siglaSistema}")
    private String siapeSiglaSistema;

    @Value("${siape.nomeSistema}")
    private String siapeNomeSistema;

    @Value("${siape.senha}")
    private String siapeSenha;

    @Override
    protected Class<Pedido> getEntityClass() {
        return Pedido.class;
    }

    public List<Pedido> efetuarConsultaPaginadaPedido(FiltroPedidoDTO filtroPedidoDTO, boolean isExport) {
        List<Pedido> listaPedido;
        int perfil = PerfilAcessoEnum.getIdByPerfil(usuarioLogadoUtil.getPerfil());
        switch (perfil) {
            case 1: case 2: case 3:
                listaPedido = efetuaPedidoPaginaConsultaCase123(filtroPedidoDTO, perfil, isExport);
                break;
            case 5:
                listaPedido = efetuaPedidoPaginaConsultaCase5(filtroPedidoDTO, perfil, isExport);
                break;
            default:
                listaPedido = efetuarConsultaPaginaPedidoCasesParte2(filtroPedidoDTO, perfil, isExport);
        }
        return listaPedido;
    }

    public List<Pedido> efetuarConsultaPaginaPedidoCasesParte2(FiltroPedidoDTO filtroPedidoDTO, int perfil, boolean isExport){
        List<Pedido> listaPedido = new ArrayList<>();
        switch (perfil) {
            case 7:
            case 8:
                listaPedido = efetuaPedidoPaginaConsultaCase8(filtroPedidoDTO, perfil, isExport);
                break;
            case 4:
            case 6:
            case 9:
                listaPedido = efetuaPedidoPaginaConsultaCase469(filtroPedidoDTO, perfil, isExport);
                break;
            default:
        }
        return listaPedido;
    }

    private List<Pedido> efetuaPedidoPaginaConsultaCase123(FiltroPedidoDTO filtroPedidoDTO, int perfil, Boolean isExport){
        Query query = efetuaPedidoPaginaConsultaCase123Verificacao(filtroPedidoDTO, perfil);
        adicionarParametrosParte1(query, filtroPedidoDTO);
        adicionarParametrosParte2(query, filtroPedidoDTO);
        adicionarParametrosParte3(query, filtroPedidoDTO);
        if (!isExport) {
            query.setFirstResult(filtroPedidoDTO.getOffset() * filtroPedidoDTO.getLimit());
            query.setMaxResults(filtroPedidoDTO.getLimit());
        }
        return  query.getResultList();
    }

    private Query efetuaPedidoPaginaConsultaCase123Verificacao(FiltroPedidoDTO filtroPedidoDTO, int perfil){
        String hqlEfetuarConsultaPaginadaPedido;
        Query query;
        if (filtroPedidoDTO.getIdDemandasComigo() == 3) {
            query = getEntityManager().createNativeQuery(DEMANDAS_COMIGO_UNIDADE_SIC, Pedido.class);
            adicionarParametrosParte5(query, perfil, filtroPedidoDTO);
        } else if (filtroPedidoDTO.getIdDemandasComigo() == 2) {
            hqlEfetuarConsultaPaginadaPedido = montarQueryPedido();
            hqlEfetuarConsultaPaginadaPedido = concatenarQuery(hqlEfetuarConsultaPaginadaPedido, Arrays.asList(WHERE_TRAMITACAO_COMIGO_SIC, montarCondicionaisParte1(), montarCondicionaisParte2(),"ORDER BY CASE  pedido.isEOuv WHEN 'true' then pedido.isEOuv  END ASC, pedido.vencimentoUnidade" ));
            query = getEntityManager().createQuery(hqlEfetuarConsultaPaginadaPedido);
        } else {
            hqlEfetuarConsultaPaginadaPedido = montarQueryPedido();
            hqlEfetuarConsultaPaginadaPedido = hqlEfetuarConsultaPaginadaPedido.concat("ORDER BY CASE  pedido.isEOuv WHEN 'true' then pedido.isEOuv  END ASC, pedido.vencimentoUnidade");
            query = getEntityManager().createQuery(hqlEfetuarConsultaPaginadaPedido);
        }
        return query;
    }

    private List<Pedido> efetuaPedidoPaginaConsultaCase5(FiltroPedidoDTO filtroPedidoDTO, int perfil, Boolean isExport){
        Query query = getEntityManager().createNativeQuery(PEDIDO_PF, Pedido.class);
        adicionarParametrosParte1(query, filtroPedidoDTO);
        adicionarParametrosParte2(query, filtroPedidoDTO);
        adicionarParametrosParte3(query, filtroPedidoDTO);
        adicionarParametrosParte4(query, perfil, filtroPedidoDTO);
        if (!isExport) {
            query.setFirstResult(filtroPedidoDTO.getOffset() * filtroPedidoDTO.getLimit());
            query.setMaxResults(filtroPedidoDTO.getLimit());
        }
        return  query.getResultList();
    }

    private List<Pedido> efetuaPedidoPaginaConsultaCase8(FiltroPedidoDTO filtroPedidoDTO, int perfil, Boolean isExport){
        Query query = getEntityManager().createNativeQuery(PEDIDO_TECNICO, Pedido.class);
        adicionarParametrosParte1(query, filtroPedidoDTO);
        adicionarParametrosParte2(query, filtroPedidoDTO);
        adicionarParametrosParte3(query, filtroPedidoDTO);
        adicionarParametrosParte4(query, perfil, filtroPedidoDTO);
        if (!isExport) {
            query.setFirstResult(filtroPedidoDTO.getOffset() * filtroPedidoDTO.getLimit());
            query.setMaxResults(filtroPedidoDTO.getLimit());
        }
        return query.getResultList();
    }

    private List<Pedido> efetuaPedidoPaginaConsultaCase469(FiltroPedidoDTO filtroPedidoDTO, int perfil, Boolean isExport){
        Query query = getEntityManager().createNativeQuery(PEDIDO_TECNICO, Pedido.class);
        query.setParameter(IG_PERFIL, NAO_IG_CLAUSULA);
        Long queryPerfil;
        if (usuarioLogadoUtil.getUsuario() == null){
            queryPerfil = -1L;
        }else{
            queryPerfil = usuarioLogadoUtil.getUsuario().getId();
        }
        query.setParameter(PERFIL, queryPerfil);
        adicionarParametrosParte1(query, filtroPedidoDTO);
        adicionarParametrosParte2(query, filtroPedidoDTO);
        adicionarParametrosParte3(query, filtroPedidoDTO);
        adicionarParametrosParte4(query, perfil, filtroPedidoDTO);
        if (!isExport) {
            query.setFirstResult(filtroPedidoDTO.getOffset() * filtroPedidoDTO.getLimit());
            query.setMaxResults(filtroPedidoDTO.getLimit());
        }
        return query.getResultList();
    }

    private String montarQueryPedido() {
        String hqlEfetuarConsultaPaginadaPedido = "";
        List<String> queries = Arrays.asList(SELECT_PEDIDO, JOIN_FETCH, JOIN_FETCH_STATUS_TRAMITACAO, JOIN_FETCH_STATUS_SOLICITACAO, LEFT_JOIN_SUBTEMA, WHERE_PEDIDO, montarCondicionaisParte1(), montarCondicionaisParte2());
        hqlEfetuarConsultaPaginadaPedido = concatenarQuery(hqlEfetuarConsultaPaginadaPedido, queries);
        return hqlEfetuarConsultaPaginadaPedido;
    }

    public Long efetuarConsultaContadorTotalPedido(FiltroPedidoDTO filtroPedidoDTO) {
        int perfil = PerfilAcessoEnum.getIdByPerfil(usuarioLogadoUtil.getPerfil());
        Query query = efetuarConsultaContadorTotalPedidoCases(filtroPedidoDTO, perfil);
        if(query != null) {
            return Long.parseLong(query.getSingleResult().toString());
        }else{
            return 0L;
        }
    }

    private Query efetuarConsultaContadorTotalPedidoCases(FiltroPedidoDTO filtroPedidoDTO, int perfil){
        Query query;
        switch (perfil) {
            case 1: case 2: case 3:
                query = efetuarConsultaContadorTotalPedidoCase123(filtroPedidoDTO, perfil);
                break;
            case 5:
                query = efetuarConsultaContadorTotalPedidoCase5(filtroPedidoDTO, perfil);
                break;
            default:
                query = efetuarConsultaContadorTotalPedidoCasesParte2(filtroPedidoDTO, perfil);
        }
        return query;
    }

    private Query efetuarConsultaContadorTotalPedidoCasesParte2(FiltroPedidoDTO filtroPedidoDTO, int perfil){
        Query query = null;
        switch(perfil) {
            case 7: case 8:
                query = efetuarConsultaContadorTotalPedidoCase78(filtroPedidoDTO);
                break;
            case 4: case 6: case 9:
                query = getEntityManager().createNativeQuery(PEDIDO_TECNICO_COUNT);
                query.setParameter(PERFIL, usuarioLogadoUtil.getUsuario() == null ? Long.valueOf(-1L) : usuarioLogadoUtil.getUsuario().getId());
                break;
            default:
        }
        return query;
    }
    private Query efetuarConsultaContadorTotalPedidoCase123(FiltroPedidoDTO filtroPedidoDTO, int perfil){
        Query query;
        if (filtroPedidoDTO.getIdDemandasComigo() == 3) {
            query = getEntityManager().createNativeQuery(DEMANDAS_COMIGO_UNIDADE_SIC_COUNT);
            adicionarParametrosParte5(query, perfil, filtroPedidoDTO);
        } else if (filtroPedidoDTO.getIdDemandasComigo() == 2) {
            String hql = getHqlCountConsultaPedido();
            hql = hql.concat(WHERE_TRAMITACAO_COMIGO_SIC);
            hql = hql.concat(montarCondicionaisParte1());
            hql = hql.concat(montarCondicionaisParte2());
            query = getEntityManager().createQuery(hql);
        } else {
            String hql = getHqlCountConsultaPedido();
            query = getEntityManager().createQuery(hql);
        }
        adicionarParametrosParte1(query, filtroPedidoDTO);
        adicionarParametrosParte2(query, filtroPedidoDTO);
        adicionarParametrosParte3(query, filtroPedidoDTO);
        return query;
    }
    private Query efetuarConsultaContadorTotalPedidoCase5(FiltroPedidoDTO filtroPedidoDTO, int perfil){
        Query query = getEntityManager().createNativeQuery(PEDIDO_PF_COUNT);
        query.setParameter(ID_USUARIO_ACESSOS, usuarioLogadoUtil.getUsuario() == null ? null : usuarioLogadoUtil.getUsuario().getId());
        query.setParameter(ID_UNIDADE, usuarioLogadoUtil.getUsuario() == null ? Long.valueOf(-1L) : usuarioLogadoUtil.getUsuario().getUnidade().getId());
        adicionarParametrosParte1(query, filtroPedidoDTO);
        adicionarParametrosParte2(query, filtroPedidoDTO);
        adicionarParametrosParte3(query, filtroPedidoDTO);
        adicionarParametrosParte4(query, perfil, filtroPedidoDTO);
        if (filtroPedidoDTO.getIdDemandasComigo() == 2) {
            query.setParameter(IG_RESPONDENTE, NAO_IG_CLAUSULA);
        } else {
            query.setParameter(IG_RESPONDENTE, IGNORA_CLAUSULA);
        }
        return query;
    }
    private Query efetuarConsultaContadorTotalPedidoCase78(FiltroPedidoDTO filtroPedidoDTO) {
        Query query = getEntityManager().createNativeQuery(PEDIDO_RESPONDENTE_COUNT);
        query.setParameter("idUsuarioAcessos", usuarioLogadoUtil.getUsuario() == null ? null : usuarioLogadoUtil.getUsuario().getId());
        if (filtroPedidoDTO.getIdDemandasComigo() == 2) {
            query.setParameter(IG_RESPONDENTE, NAO_IG_CLAUSULA);
            query.setParameter(IG_PERFIL, NAO_IG_CLAUSULA);
            query.setParameter(PERFIL, usuarioLogadoUtil.getUsuario().getId());
        } else {
            query.setParameter(IG_RESPONDENTE, IGNORA_CLAUSULA);
            query.setParameter(IG_PERFIL, IGNORA_CLAUSULA);
            query.setParameter(PERFIL, -1);
        }
        return query;
    }
    private String getHqlCountConsultaPedido() {
        String hql = "SELECT COUNT(pedido) FROM Pedido pedido ";
        hql = hql.concat(WHERE_PEDIDO);
        hql = hql.concat(montarCondicionaisParte1());
        hql = hql.concat(montarCondicionaisParte2());
        return hql;
    }
    private String montarCondicionaisParte1() {
        String hql = "";
        hql = hql.concat("AND ('ignoraClausula' = :igTextoSolicitacao OR UPPER(pedido.descricaoPedido) LIKE UPPER(:textoSolicitacao)) ");
        hql = hql.concat("AND ('ignoraClausula' = :igTextoResposta OR UPPER(pedido.respostaEsic) LIKE UPPER(:textoResposta)) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoVencidoFKS OR pedido.vencimentoUnidade < :prazoVencidoFKS) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoVencidoEsic OR pedido.prazoAtendimento < :prazoVencidoEsic) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialVencimentoEsic OR pedido.prazoAtendimento >= :periodoInicialVencimentoEsic) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoFinalVencimentoEsic OR pedido.prazoAtendimento <= :periodoFinalVencimentoEsic) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoProrrogadoFKS OR pedido.statusVencimentoUnidadeProrrogado = :prazoProrrogadoFKS) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR pedido.statusPrazoAtendimentoEsicProrrogado = :prazoProrrogadoEsic) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR pedido.statusPrazoAtendimentoEsicProrrogado = :prazoProrrogadoEsic) ");
        return hql;
    }

    private String montarCondicionaisParte2() {
        String hql = "";
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusTramitacao OR pedido.statusTramitacao.id = :idStatusTramitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusSituacao OR pedido.statusSituacao.id = :idStatusSituacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdTema OR pedido.tema.id = :idTema) ");
        hql = hql.concat("AND ('ignoraClausula' = :igProtocolo OR pedido.protocolo = :protocolo) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR pedido.dataRegistro >= :periodoInicialDataAbertura) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR pedido.dataRegistro <= :periodoFinalDataAbertura) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR pedido.vencimentoUnidade >= :periodoInicialPrazoAtendimento) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR pedido.vencimentoUnidade <= :periodoFinalPrazoAtendimento) ");
        hql = hql.concat("AND ('ignoraClausula' = :igNomeSolicitante OR UPPER(pedido.solicitante.nome) LIKE UPPER(:nomeSolicitante)) ");
        hql = hql.concat("AND ('ignoraClausula' = :igTipoPessoa OR pedido.solicitante.tipoPessoa = :tipoPessoa) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusSolicitacao OR pedido.statusSolicitacao.id = :idStatusSolicitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdSituacaoPedido OR pedido.situacaoPedido.id = :idSituacaoPedido) ");
        hql = hql.concat("AND ('ignoraClausula' = :igDemandasComigo OR pedido.statusTramitacao.id = :idStatusTramitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdentidadePreservada OR substring(pedido.solicitante.nome,1,1) in ('0','1','2','3','4','5','6','7','8','9')) ");
        return hql;
    }

    private void adicionarParametrosParte1(Query query, FiltroPedidoDTO filtroPedidoDTO) {
        query.setParameter("igIdStatusTramitacao", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getIdStatusTramitacao()));
        query.setParameter(ID_STATUS_TRAMITACAO, filtroPedidoDTO.getIdStatusTramitacao() == null ? Long.valueOf(-1L) : filtroPedidoDTO.getIdStatusTramitacao());
        query.setParameter("igIdTema", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getIdTema()));
        query.setParameter("idTema", filtroPedidoDTO.getIdTema() == null ? Long.valueOf(-1L) : filtroPedidoDTO.getIdTema());
        query.setParameter("igProtocolo", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getProtocolo()));
        query.setParameter("protocolo", filtroPedidoDTO.getProtocolo() == null ? " " : filtroPedidoDTO.getProtocolo());
        query.setParameter("igPeriodoInicialDataAbertura", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPeriodoInicialDataAbertura()));
        query.setParameter("periodoInicialDataAbertura", DataUtil.getDataHoraInicioDia(filtroPedidoDTO.getPeriodoInicialDataAbertura()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : DataUtil.getDataHoraInicioDia(filtroPedidoDTO.getPeriodoInicialDataAbertura()));
        query.setParameter("igPeriodoFinalDataAbertura", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPeriodoFinalDataAbertura()));
        query.setParameter("periodoFinalDataAbertura", DataUtil.getDataHoraFinalDia(filtroPedidoDTO.getPeriodoFinalDataAbertura()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : DataUtil.getDataHoraFinalDia(filtroPedidoDTO.getPeriodoFinalDataAbertura()));
        query.setParameter("igPeriodoInicialPrazoAtendimento", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPeriodoInicialPrazoAtendimento()));
        query.setParameter("periodoInicialPrazoAtendimento", DataUtil.getDataHoraInicioDia(filtroPedidoDTO.getPeriodoInicialPrazoAtendimento()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : DataUtil.getDataHoraInicioDia(filtroPedidoDTO.getPeriodoInicialPrazoAtendimento()));
        query.setParameter("igPeriodoFinalPrazoAtendimento", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPeriodoFinalPrazoAtendimento()));
        query.setParameter("periodoFinalPrazoAtendimento", DataUtil.getDataHoraFinalDia(filtroPedidoDTO.getPeriodoFinalPrazoAtendimento()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : DataUtil.getDataHoraFinalDia(filtroPedidoDTO.getPeriodoFinalPrazoAtendimento()));
    }

    private void adicionarParametrosParte2(Query query, FiltroPedidoDTO filtroPedidoDTO) {
        query.setParameter("igNomeSolicitante", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getNomeSolicitante()));
        query.setParameter("nomeSolicitante", filtroPedidoDTO.getNomeSolicitante() == null ? " " : "%" + filtroPedidoDTO.getNomeSolicitante() + "%");
        query.setParameter("igTipoPessoa", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getTipoPessoa()));
        query.setParameter("tipoPessoa", filtroPedidoDTO.getTipoPessoa() == null ? " " : filtroPedidoDTO.getTipoPessoa());
        query.setParameter("igIdStatusSolicitacao", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getIdStatusSolicitacao()));
        query.setParameter("idStatusSolicitacao", filtroPedidoDTO.getIdStatusSolicitacao() == null ? Long.valueOf(-1L) : filtroPedidoDTO.getIdStatusSolicitacao());
        adicionarParametrosParte2Verificacao(filtroPedidoDTO, query);
        query.setParameter("igIdStatusSituacao", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getIdStatusSituacao()));
        query.setParameter("idStatusSituacao", filtroPedidoDTO.getIdStatusSituacao() == null ? Long.valueOf(-1L) : filtroPedidoDTO.getIdStatusSituacao());
        query.setParameter("igIdSituacaoPedido", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getIdSituacaoPedido()));
        query.setParameter("idSituacaoPedido", filtroPedidoDTO.getIdSituacaoPedido() == null ? Long.valueOf(-1) : filtroPedidoDTO.getIdSituacaoPedido());
        query.setParameter("igTextoSolicitacao", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getTextoSolicitacao()));
        query.setParameter("textoSolicitacao", filtroPedidoDTO.getTextoSolicitacao() == null ? " " : "%" + filtroPedidoDTO.getTextoSolicitacao() + "%");
        query.setParameter("igTextoResposta", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getTextoResposta()));
        query.setParameter("textoResposta", filtroPedidoDTO.getTextoResposta() == null ? " " : "%" + filtroPedidoDTO.getTextoResposta() + "%");
    }

    private void adicionarParametrosParte2Verificacao(FiltroPedidoDTO filtroPedidoDTO, Query query){
        if (filtroPedidoDTO.getTipoPessoa() != null) {
            if (filtroPedidoDTO.getTipoPessoa().equals("I")) {
                query.setParameter(IG_IDENTIDADE_PRESERVADA, NAO_IG_CLAUSULA);
                query.setParameter("igTipoPessoa", IGNORA_CLAUSULA);
            } else {
                query.setParameter(IG_IDENTIDADE_PRESERVADA, IGNORA_CLAUSULA);
            }
        } else {
            query.setParameter(IG_IDENTIDADE_PRESERVADA, IGNORA_CLAUSULA);
        }
    }

    private void adicionarParametrosParte3(Query query, FiltroPedidoDTO filtroPedidoDTO) {
        query.setParameter("igPrazoVencidoFKS", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPrazoVencidoFKS()));
        query.setParameter("prazoVencidoFKS", filtroPedidoDTO.getPrazoVencidoFKS() == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : filtroPedidoDTO.getPrazoVencidoFKS());
        query.setParameter("igPrazoVencidoEsic", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPrazoVencidoEsic()));
        query.setParameter("prazoVencidoEsic", filtroPedidoDTO.getPrazoVencidoEsic() == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : filtroPedidoDTO.getPrazoVencidoEsic());
        query.setParameter("igPeriodoInicialVencimentoEsic", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPeriodoInicialVencimentoEsic()));
        query.setParameter("periodoInicialVencimentoEsic", DataUtil.getDataHoraInicioDia(filtroPedidoDTO.getPeriodoInicialVencimentoEsic()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : DataUtil.getDataHoraInicioDia(filtroPedidoDTO.getPeriodoInicialVencimentoEsic()));
        query.setParameter("igPeriodoFinalVencimentoEsic", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPeriodoFinalVencimentoEsic()));
        query.setParameter("periodoFinalVencimentoEsic", DataUtil.getDataHoraFinalDia(filtroPedidoDTO.getPeriodoFinalVencimentoEsic()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()) : DataUtil.getDataHoraFinalDia(filtroPedidoDTO.getPeriodoFinalVencimentoEsic()));
        query.setParameter("igPrazoProrrogadoFKS", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPrazoProrrogadoFKS()));
        query.setParameter("prazoProrrogadoFKS", filtroPedidoDTO.getPrazoProrrogadoFKS() == null ? Boolean.FALSE : filtroPedidoDTO.getPrazoProrrogadoFKS());
        query.setParameter("igPrazoProrrogadoEsic", QueryUtil.definirSeIgnoraClausula(filtroPedidoDTO.getPrazoProrrogadoEsic()));
        query.setParameter("prazoProrrogadoEsic", filtroPedidoDTO.getPrazoProrrogadoEsic() == null ? Boolean.FALSE : filtroPedidoDTO.getPrazoProrrogadoEsic());
        adicionarParametrosParte3Verificacao(query, filtroPedidoDTO);
    }

    private void adicionarParametrosParte3Verificacao(Query query, FiltroPedidoDTO filtroPedidoDTO){
        int perfil = PerfilAcessoEnum.getIdByPerfil(usuarioLogadoUtil.getPerfil());
        if (perfil == PerfilAcessoEnum.ATENDENTE_SIC.getIdPerfil() || perfil == PerfilAcessoEnum.ADMIN.getIdPerfil() ||
                perfil == PerfilAcessoEnum.OBSERVADOR_SIC.getIdPerfil()) {
            if (filtroPedidoDTO.getIdDemandasComigo() == 2 && filtroPedidoDTO.getIdStatusTramitacao() != null) {
                query.setParameter(IG_DEMANDAS_COMIGO, NAO_IG_CLAUSULA);
                query.setParameter(ID_STATUS_TRAMITACAO, filtroPedidoDTO.getIdStatusTramitacao());
            } else {
                query.setParameter(IG_DEMANDAS_COMIGO, IGNORA_CLAUSULA);
            }
        } else if (perfil == PerfilAcessoEnum.RESPONDENTE.getIdPerfil()) {
            if (filtroPedidoDTO.getIdDemandasComigo() == 2) {
                query.setParameter(IG_PERFIL, NAO_IG_CLAUSULA);
                query.setParameter(PERFIL, usuarioLogadoUtil.getUsuario().getId());
            } else {
                query.setParameter(IG_PERFIL, IGNORA_CLAUSULA);
                query.setParameter(PERFIL, -1);
            }
        }
    }

    private void adicionarParametrosParte4(Query query, int perfil, FiltroPedidoDTO filtroPedidoDTO) {
        query.setParameter("idUsuarioAcessos", usuarioLogadoUtil.getUsuario() == null ? null : usuarioLogadoUtil.getUsuario().getId());
        if (perfil == PerfilAcessoEnum.RESPONDENTE.getIdPerfil() || perfil == PerfilAcessoEnum.PONTO_FOCAL.getIdPerfil() ||
                perfil == PerfilAcessoEnum.OBSERVADOR_UNIDADE.getIdPerfil()) {
            if (filtroPedidoDTO.getIdDemandasComigo() == 2) {
                query.setParameter(IG_RESPONDENTE, NAO_IG_CLAUSULA);
            } else {
                query.setParameter(IG_RESPONDENTE, IGNORA_CLAUSULA);
            }
        } else {
            query.setParameter(IG_RESPONDENTE, IGNORA_CLAUSULA);
        }
        adicionarParametrosParte4Verificacao(query, perfil);
    }

    private void adicionarParametrosParte4Verificacao(Query query, int perfil){
        if (perfil != PerfilAcessoEnum.TECNICO.getIdPerfil() && perfil != PerfilAcessoEnum.AUTORIDADE_HIERARQUICA.getIdPerfil() && perfil != PerfilAcessoEnum.AUTORIDADE_MAXIMA.getIdPerfil()) {
            if (perfil == PerfilAcessoEnum.PONTO_FOCAL.getIdPerfil() || perfil == PerfilAcessoEnum.OBSERVADOR_UNIDADE.getIdPerfil()) {
                query.setParameter(IG_UNIDADE, QueryUtil.definirSeIgnoraClausula(usuarioLogadoUtil.getUsuario() == null ? null : usuarioLogadoUtil.getUsuario().getUnidade().getId()));
                query.setParameter(ID_UNIDADE, usuarioLogadoUtil.getUsuario() == null ? Long.valueOf(-1L) : usuarioLogadoUtil.getUsuario().getUnidade().getId());
                query.setParameter(IG_SUBUNIDADE, IGNORA_CLAUSULA);
                query.setParameter(ID_SUBUNIDADE, -1);
            } else if (perfil == PerfilAcessoEnum.RESPONDENTE.getIdPerfil()) {
                query.setParameter(IG_UNIDADE, IGNORA_CLAUSULA);
                query.setParameter(ID_UNIDADE, -1);
                query.setParameter(IG_SUBUNIDADE, IGNORA_CLAUSULA);
            }
        } else {
            query.setParameter(IG_SUBUNIDADE, IGNORA_CLAUSULA);
            query.setParameter(IG_UNIDADE, IGNORA_CLAUSULA);
            query.setParameter(ID_UNIDADE, -1);
        }
    }

    private void adicionarParametrosParte5(Query query, int perfil, FiltroPedidoDTO filtroPedidoDTO) {
        if (perfil == PerfilAcessoEnum.ATENDENTE_SIC.getIdPerfil() || perfil == PerfilAcessoEnum.ADMIN.getIdPerfil()) {
            switch (filtroPedidoDTO.getIdDemandasComigo()) {
                case 2:
                    query.setParameter(IG_DEMANDAS_COMIGO, NAO_IG_CLAUSULA);
                    query.setParameter(ID_STATUS_TRAMITACAO, StatusTramitacao.SIC);
                    break;
                case 3:
                    query.setParameter(IG_UNIDADE, NAO_IG_CLAUSULA);
                    query.setParameter(ID_UNIDADE, usuarioLogadoUtil.getUsuario() == null ? Long.valueOf(-1L) : usuarioLogadoUtil.getUsuario().getUnidade().getId());
                    query.setParameter(IG_DEMANDAS_COMIGO, IGNORA_CLAUSULA);
                    query.setParameter(ID_STATUS_TRAMITACAO, -1L);
                    break;
                default:
                    query.setParameter(IG_DEMANDAS_COMIGO, IGNORA_CLAUSULA);
                    query.setParameter(ID_STATUS_TRAMITACAO, -1L);
            }
        }
    }

    public Pedido detalharPedido(Long idPedido) {
        String hqlDetalharPedido = "";
        List<String> queries = Arrays.asList(SELECT_PEDIDO, JOIN_FETCH, JOIN_FETCH_STATUS_SOLICITACAO, JOIN_FETCH_SITUACAO_PEDIDO, JOIN_FETCH_ANEXOS, WHERE_PEDIDOID);
        hqlDetalharPedido = concatenarQuery(hqlDetalharPedido, queries);
        Query query = getEntityManager().createQuery(hqlDetalharPedido);
        query.setParameter("idPedido", idPedido);
        List<Pedido> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}