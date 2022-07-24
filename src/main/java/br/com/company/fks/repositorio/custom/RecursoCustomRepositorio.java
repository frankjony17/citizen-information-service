package br.com.company.fks.repositorio.custom;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.ConsultaRecursoDTO;
import br.com.company.fks.modelo.dto.FiltroRecursoDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.repositorio.base.RepositorioGenerico;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.utils.QueryUtil;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Repository
public class RecursoCustomRepositorio extends RepositorioGenerico<Recurso, Long> {
    private static final String DEMANDAS_COMIGO = "with tb_ultimo_andamento as (\n" +
            "\tselect ar.id_recurso,ar.id_usuario_acessos,ar.id_unidade,max(ar.id_andamento_recurso) from tb_andamento_recurso ar\n" +
            "\tjoin tb_recurso r on ar.id_recurso = r.id_recurso\n" +
            "\tgroup by ar.id_recurso,ar.id_usuario_acessos,ar.id_unidade\n" +
            "\torder by ar.id_recurso\n" +
            ")" +
            "select distinct r.id_recurso,r.cd_protocolo_pedido,r.dt_data_abertura,r.dt_data_prazo_atendimento,r.ds_descricao_justificativa,\n" +
            "\tr.qt_anexos,r.id_pedido, r.id_status_tramitacao_recurso,r.id_status_solicitacao_recurso,r.id_situacao_recurso,r.dt_data_vencimento_unidade,\n" +
            "\tr.id_instancia_recurso, r.id_tipo_resposta_recurso, r.id_tipo_recurso, r.ds_observacao, r.ds_justificativa_devolver,r.ds_proposta_resposta,\n" +
            "\tr.ds_resposta_esic,r.ds_observacao_resposta_enviada,r.st_status_resposta_assinada\n" +
            "from tb_recurso r \n" +
            "join tb_status_tramitacao_recurso str on str.id_status_tramitacao_recurso = r.id_status_tramitacao_recurso\n" +
            "join tb_status_solicitacao_recurso ssr on ssr.id_status_solicitacao_recurso = r.id_status_solicitacao_recurso\n" +
            "join tb_pedido p on p.id_pedido = r.id_pedido\n" +
            "join tb_solicitante s on p.id_solicitante = s.id_solicitante\n" +
            "join tb_instancia_recurso inst on inst.id_instancia_recurso = r.id_instancia_recurso\n" +
            "join tb_tipo_recurso tr on r.id_tipo_recurso = tr.id_tipo_recurso\n" +
            "join tb_situacao_recurso sr on sr.id_situacao_recurso = r.id_situacao_recurso\n" +
            "join tb_ultimo_andamento ua on ua.id_recurso = r.id_recurso\n" +
            "where 1 = 1 "+
            "AND (('ignoraClausula' = :igAtendenteSic OR ssr.id_status_solicitacao_recurso IN (1,5,6,7,9,13,14,15)) "+
            "AND ('ignoraClausula' = :igPontoFocal OR ssr.id_status_solicitacao_recurso IN (2,4)) "+
            "AND ('ignoraClausula' = :igPontoFocalAutMax OR ssr.id_status_solicitacao_recurso IN (10,12)) " +
            "AND ('ignoraClausula' = :igAutoridadeHieraq OR ssr.id_status_solicitacao_recurso IN (3)) " +
            "AND ('ignoraClausula' = :igAutoridadeMax OR ssr.id_status_solicitacao_recurso IN (11)) "+
            "OR ('ignoraClausula' = :igAcessos OR ua.id_usuario_acessos = :idUsuarioAcessos )) "+
            "AND ('ignoraClausula' = :igUnidade OR ua.id_unidade = :idUnidade) "+
            "AND ('ignoraClausula' = :igIdentidadePreservada OR s.nm_nome ~ ('^[0-9\\.]+$')) ";


    private static final String SELECT_COUNT_RECURSO = "with tb_ultimo_andamento as (\n" +
            "\tselect ar.id_recurso,ar.id_usuario_acessos,ar.id_unidade,max(ar.id_andamento_recurso) from tb_andamento_recurso ar\n" +
            "\tjoin tb_recurso r on ar.id_recurso = r.id_recurso\n" +
            "\tgroup by ar.id_recurso,ar.id_usuario_acessos,ar.id_unidade\n" +
            "\torder by ar.id_recurso\n" +
            ")" +
            "select count(distinct r.id_recurso) " +
            "from tb_recurso r \n" +
            "join tb_status_tramitacao_recurso str on str.id_status_tramitacao_recurso = r.id_status_tramitacao_recurso\n" +
            "join tb_status_solicitacao_recurso ssr on ssr.id_status_solicitacao_recurso = r.id_status_solicitacao_recurso\n" +
            "join tb_pedido p on p.id_pedido = r.id_pedido\n" +
            "join tb_solicitante s on p.id_solicitante = s.id_solicitante\n" +
            "join tb_instancia_recurso inst on inst.id_instancia_recurso = r.id_instancia_recurso\n" +
            "join tb_tipo_recurso tr on r.id_tipo_recurso = tr.id_tipo_recurso\n" +
            "join tb_situacao_recurso sr on sr.id_situacao_recurso = r.id_situacao_recurso\n" +
            "join tb_ultimo_andamento ua on ua.id_recurso = r.id_recurso\n" +
            "where 1 = 1 "+
            "AND (('ignoraClausula' = :igAtendenteSic OR ssr.id_status_solicitacao_recurso IN (1,5,6,7,9,13,14,15)) "+
            "AND ('ignoraClausula' = :igPontoFocal OR ssr.id_status_solicitacao_recurso IN (2,4)) "+
            "AND ('ignoraClausula' = :igPontoFocalAutMax OR ssr.id_status_solicitacao_recurso IN (10,12)) " +
            "AND ('ignoraClausula' = :igAutoridadeHieraq OR ssr.id_status_solicitacao_recurso IN (3)) " +
            "AND ('ignoraClausula' = :igAutoridadeMax OR ssr.id_status_solicitacao_recurso IN (11)) "+
            "OR ('ignoraClausula' = :igAcessos OR ua.id_usuario_acessos = :idUsuarioAcessos )) "+
            "AND ('ignoraClausula' = :igUnidade OR ua.id_unidade = :idUnidade) "+
            "AND ('ignoraClausula' = :igIdentidadePreservada OR s.nm_nome ~ ('^[0-9\\.]+$')) ";

    private static final String SELECT_RECURSO = "SELECT recurso FROM Recurso recurso ";
    private static final String JOIN_FETCH_PEDIDO = "JOIN FETCH recurso.pedido pedido ";
    private static final String JOIN_FETCH_SOLICITANTE = "JOIN FETCH pedido.solicitante solicitante ";
    private static final String WHERE_RECURSO = "WHERE (1 = 1) ";
    private static final String JOIN_FETCH_STATUS_TRAMITACAO = "JOIN FETCH recurso.statusTramitacao ";
    private static final String JOIN_FETCH_STATUS_SOLICITACAO = "LEFT JOIN FETCH recurso.statusSolicitacao ";
    private static final String JOIN_FETCH_INSTANCIA_RECURSO = "JOIN FETCH recurso.instanciaRecurso ";
    private static final String JOIN_FETCH_SITUACAO_RECURSO = "JOIN FETCH recurso.situacaoRecurso ";
    private static final String JOIN_FETCH_TIPO_RECURSO = "JOIN FETCH recurso.tipoRecurso ";
    private static final String WHERE_RECURSO_ID = "WHERE recurso.id = :idRecurso ";
    private static final String NAO_IGNORA_CLAUSULA = "naoIgnoraClausula";
    private static final String IG_IDENTIDADE_PRESERVADA = "igIdentidadePreservada";
    private static final String IGNORA_CLAUSULA = "ignoraClausula";
    private static final String ID_USUARIO_ACESSOS = "idUsuarioAcessos";
    private static final String ID_UNIDADE= "idUnidade";
    private static final String IG_UNIDADE = "igUnidade";
    private static final String IG_PONTO_FOCAL = "igPontoFocal";
    private static final String IG_PONTO_FOCAL_AUT_MAX = "igPontoFocalAutMax";
    private static final String IG_AUTORIDADE_HIERARQ = "igAutoridadeHieraq";
    private static final String IG_AUTORIDADE_MAX = "igAutoridadeMax";
    private static final String IG_ATENDENTE_SIC = "igAtendenteSic";
    @Override
    protected Class<Recurso> getEntityClass() {
        return Recurso.class;
    }

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    public List<Recurso> efetuarConsultaPaginadaRecurso(FiltroRecursoDTO filtroRecursoDTO, boolean isExport) {
        int perfil = PerfilAcessoEnum.getIdByPerfil(usuarioLogadoUtil.getPerfil());
        Query query = null;
        switch (perfil) {
            case 1: case 2: case 4: case 5: case 6: case 10:
                query = efetuarConsultaPaginaRecursoTratamento(filtroRecursoDTO);
                break;
            default:
        }
        return efetuarConsultaPaginaRecursoVerificacao(filtroRecursoDTO, perfil, query, isExport);
    }

    private Query efetuarConsultaPaginaRecursoTratamento(FiltroRecursoDTO filtroRecursoDTO){
        String hqlEfetuarConsultaPaginadaRecurso = "";
        Query query = null;
        if (filtroRecursoDTO.getIdDemandasComigo() == 2 || filtroRecursoDTO.getIdDemandasComigo() == 3 || filtroRecursoDTO.getIdDemandasComigo() == 0) {
            String sql = DEMANDAS_COMIGO.concat(montarCondicionaisNative());
            query = getEntityManager().createNativeQuery(sql,Recurso.class);
            adicionarParametrosParte3(query, filtroRecursoDTO);
        }else if(filtroRecursoDTO.getIdDemandasComigo() == 1){
            hqlEfetuarConsultaPaginadaRecurso = montarQueryPrincipalHQL(hqlEfetuarConsultaPaginadaRecurso);
            hqlEfetuarConsultaPaginadaRecurso = hqlEfetuarConsultaPaginadaRecurso.concat(montarCondicionais());
            query = getEntityManager().createQuery(hqlEfetuarConsultaPaginadaRecurso);
        }
        return query;
    }

    private List<Recurso> efetuarConsultaPaginaRecursoVerificacao(FiltroRecursoDTO filtroRecursoDTO, int perfil, Query query, boolean isExport){
        List<Recurso> listaRecurso = new ArrayList<>();
        if(perfil != 3 && perfil != 7 && perfil != 8 && perfil != 9 && query != null) {
            adicionarParametrosParte1(query, filtroRecursoDTO);
            adicionarParametrosParte2(query, filtroRecursoDTO);
            listaRecurso = query.getResultList();
            if(!isExport) {
                query.setFirstResult(filtroRecursoDTO.getOffset() * filtroRecursoDTO.getLimit());
                query.setMaxResults(filtroRecursoDTO.getLimit());
            }
        }
        return listaRecurso;
    }

    public List<ConsultaRecursoDTO> efetuarConsultaPaginadaFiltroRecurso(FiltroRecursoDTO filtroRecursoDTO, boolean isExport) {
        return montarListaConsultaRecursoDTO(efetuarConsultaPaginadaRecurso(filtroRecursoDTO,isExport));
    }

    private String montarQueryPrincipalHQL(String hqlEfetuarConsultaPaginadaRecurso) {
        String newString = hqlEfetuarConsultaPaginadaRecurso;
        newString = newString.concat(SELECT_RECURSO);
        newString = newString.concat(JOIN_FETCH_STATUS_TRAMITACAO);
        newString = newString.concat(JOIN_FETCH_STATUS_SOLICITACAO);
        newString = newString.concat(JOIN_FETCH_PEDIDO);
        newString = newString.concat(JOIN_FETCH_SOLICITANTE);
        newString = newString.concat(JOIN_FETCH_INSTANCIA_RECURSO);
        newString = newString.concat(JOIN_FETCH_TIPO_RECURSO);
        newString = newString.concat(JOIN_FETCH_SITUACAO_RECURSO);
        newString = newString.concat(WHERE_RECURSO);
        return newString;
    }

    public List<ConsultaRecursoDTO> montarListaConsultaRecursoDTO(List<Recurso> listaRecurso) {
        List<ConsultaRecursoDTO> listaConsultaRecursoDTO = new ArrayList<>();
        for (Recurso recurso : listaRecurso) {
            ConsultaRecursoDTO consultaRecursoDTO = new ConsultaRecursoDTO();
            consultaRecursoDTO.setIdRecurso(recurso.getId());
            consultaRecursoDTO.setIdPedido(recurso.getPedido().getId());
            consultaRecursoDTO.setProtocolo(recurso.getProtocoloPedido());
            consultaRecursoDTO.setNomeTipoRecurso(recurso.getTipoRecurso().getNome());
            consultaRecursoDTO.setDataAbertura(recurso.getDataAbertura());
            consultaRecursoDTO.setPrazoAtendimento(recurso.getDataPrazoAtendimento());
            consultaRecursoDTO.setNomeSituacaoRecurso(recurso.getSituacaoRecurso().getNome());
            consultaRecursoDTO.setNomeSolicitante(recurso.getPedido().getSolicitante().getNome());
            listaConsultaRecursoDTO.add(consultaRecursoDTO);
        }
        return listaConsultaRecursoDTO;
    }

    public Long efetuarConsultaContadorTotalRecurso(FiltroRecursoDTO filtroRecursoDTO) {
        int perfil = PerfilAcessoEnum.getIdByPerfil(usuarioLogadoUtil.getPerfil());
        Query query = null;
        switch (perfil) {
            case 1: case 2: case 4: case 5: case 6: case 10:
                query = efetuarConsultaContadorTotalRecursoTratamentoQuery(filtroRecursoDTO);
                break;
            default:
                break;
        }
        return efetuarConsultaContadorTotalRecursoVerificacao(query, filtroRecursoDTO, perfil);
    }

    private Long efetuarConsultaContadorTotalRecursoVerificacao(Query query, FiltroRecursoDTO filtroRecursoDTO, int perfil){
        if(perfil != 3 && perfil != 7 && perfil != 8 && perfil != 9 && query != null) {
            adicionarParametrosParte1(query, filtroRecursoDTO);
            adicionarParametrosParte2(query, filtroRecursoDTO);
            return Long.parseLong(query.getSingleResult().toString());
        }else{
            return 0L;
        }
    }

    private Query efetuarConsultaContadorTotalRecursoTratamentoQuery(FiltroRecursoDTO filtroRecursoDTO){
        Query query = null;
        String hqlEfetuarConsultaPaginadaRecurso = "";
        if (filtroRecursoDTO.getIdDemandasComigo() == 2 || filtroRecursoDTO.getIdDemandasComigo() == 3 || filtroRecursoDTO.getIdDemandasComigo() == 0) {
            hqlEfetuarConsultaPaginadaRecurso =  hqlEfetuarConsultaPaginadaRecurso.concat(SELECT_COUNT_RECURSO);
            hqlEfetuarConsultaPaginadaRecurso = hqlEfetuarConsultaPaginadaRecurso.concat(montarCondicionaisNative());
            query = getEntityManager().createNativeQuery(hqlEfetuarConsultaPaginadaRecurso);
            adicionarParametrosParte3(query, filtroRecursoDTO);
        }else if (filtroRecursoDTO.getIdDemandasComigo() == 1) {
            String hql = getHqlCountConsultaRecurso();
            query = getEntityManager().createQuery(hql);
        }
        return query;
    }

    private String getHqlCountConsultaRecurso() {
        String hql = "SELECT COUNT(recurso) FROM Recurso recurso  ";
        hql = hql.concat(WHERE_RECURSO);
        hql = hql.concat(montarCondicionais());
        return hql;
    }

    private String montarCondicionais() {
        String hql = "";
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusTramitacao OR recurso.statusTramitacao.id = :idStatusTramitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusSolicitacao OR recurso.statusSolicitacao.id = :idStatusSolicitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igProtocolo OR recurso.protocoloPedido = :protocolo) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoVencidoFKS OR recurso.vencimentoUnidade < :prazoVencidoFKS) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoVencidoEsic OR recurso.dataPrazoAtendimento < :prazoVencidoEsic) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR recurso.dataAbertura >= :periodoInicialDataAbertura) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR recurso.dataAbertura <= :periodoFinalDataAbertura) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR recurso.dataPrazoAtendimento >= :periodoInicialPrazoAtendimento) ");
        hql = montarCondicionaisParte2(hql);
        return hql;
    }

    private String montarCondicionaisParte2(String hql){
        String newHql = hql;
        newHql = newHql.concat("AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR recurso.dataPrazoAtendimento <= :periodoFinalPrazoAtendimento) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igTipoPessoa OR recurso.pedido.solicitante.tipoPessoa = :tipoPessoa) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdInstanciaRecurso OR recurso.instanciaRecurso.id = :IdInstanciaRecurso) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igPeriodoInicialVencimentoEsic OR recurso.vencimentoUnidade >= :periodoInicialVencimentoEsic) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igPeriodoFinalVencimentoEsic OR recurso.vencimentoUnidade <= :periodoFinalVencimentoEsic) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdSituacaoRecurso OR recurso.situacaoRecurso.id = :idSituacaoRecurso) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdTipoRecurso OR recurso.tipoRecurso.id = :idTipoRecurso) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igNomeSolicitante OR UPPER(recurso.pedido.solicitante.nome) LIKE UPPER(:nomeSolicitante)) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igDescricaoJustificativa OR UPPER(recurso.descricaoJustificativa) LIKE UPPER(:descricaoJustificativa)) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdentidadePreservada OR substring(pedido.solicitante.nome,1,1) in ('0','1','2','3','4','5','6','7','8','9')) ");
        return newHql;
    }

    private String montarCondicionaisNative() {
        String hql = "";
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusTramitacao OR str.id_status_tramitacao_recurso = :idStatusTramitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igIdStatusSolicitacao OR ssr.id_status_solicitacao_recurso = :idStatusSolicitacao) ");
        hql = hql.concat("AND ('ignoraClausula' = :igProtocolo OR r.cd_protocolo_pedido = :protocolo) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoVencidoFKS OR r.dt_data_vencimento_unidade < :prazoVencidoFKS) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPrazoVencidoEsic OR r.dt_data_prazo_atendimento < :prazoVencidoEsic) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR r.dt_data_abertura >= :periodoInicialDataAbertura) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR r.dt_data_abertura <= :periodoFinalDataAbertura) ");
        hql = hql.concat("AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR r.dt_data_prazo_atendimento >= :periodoInicialPrazoAtendimento) ");
        hql = montarCondicionaisNativeParte2(hql);
        return hql;
    }

    private String montarCondicionaisNativeParte2(String hql){
        String newHql = hql;
        newHql = newHql.concat("AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR r.dt_data_prazo_atendimento <= :periodoFinalPrazoAtendimento) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igTipoPessoa OR s.tp_tipo_nome = :tipoPessoa) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdInstanciaRecurso OR r.id_instancia_recurso = :IdInstanciaRecurso) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igPeriodoInicialVencimentoEsic OR r.dt_data_vencimento_unidade >= :periodoInicialVencimentoEsic) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igPeriodoFinalVencimentoEsic OR r.dt_data_vencimento_unidade <= :periodoFinalVencimentoEsic) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdSituacaoRecurso OR r.id_situacao_recurso = :idSituacaoRecurso) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igIdTipoRecurso OR r.id_tipo_recurso = :idTipoRecurso) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igNomeSolicitante OR UPPER(s.nm_nome) LIKE UPPER(:nomeSolicitante)) ");
        newHql = newHql.concat("AND ('ignoraClausula' = :igDescricaoJustificativa OR UPPER(r.ds_descricao_justificativa) LIKE UPPER(:descricaoJustificativa)) ");
        return newHql;
    }

    private void adicionarParametrosParte1(Query query, FiltroRecursoDTO filtroRecursoDTO) {
        query.setParameter("igIdStatusTramitacao", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getIdStatusTramitacao()));
        query.setParameter("idStatusTramitacao", filtroRecursoDTO.getIdStatusTramitacao() == null ? Long.valueOf(-1L): filtroRecursoDTO.getIdStatusTramitacao());
        query.setParameter("igIdStatusSolicitacao", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getIdStatusSolicitacao()));
        verificaPerfilDoUsuario(filtroRecursoDTO);
        query.setParameter("idStatusSolicitacao", filtroRecursoDTO.getIdStatusSolicitacao() == null ? Long.valueOf(-1L): filtroRecursoDTO.getIdStatusSolicitacao());
        query.setParameter("igProtocolo", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getProtocolo()));
        query.setParameter("protocolo", filtroRecursoDTO.getProtocolo() == null ? "": filtroRecursoDTO.getProtocolo());
        query.setParameter("igPeriodoInicialDataAbertura", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPeriodoInicialDataAbertura()));
        query.setParameter("periodoInicialDataAbertura", DataUtil.getDataHoraInicioDia(filtroRecursoDTO.getPeriodoInicialDataAbertura()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  DataUtil.getDataHoraInicioDia(filtroRecursoDTO.getPeriodoInicialDataAbertura()));
        query.setParameter("igPeriodoFinalDataAbertura", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPeriodoFinalDataAbertura()));
        query.setParameter("periodoFinalDataAbertura", DataUtil.getDataHoraFinalDia(filtroRecursoDTO.getPeriodoFinalDataAbertura()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  DataUtil.getDataHoraFinalDia(filtroRecursoDTO.getPeriodoFinalDataAbertura()) );
        query.setParameter("igPeriodoInicialPrazoAtendimento", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPeriodoInicialPrazoAtendimento()));
        query.setParameter("periodoInicialPrazoAtendimento", DataUtil.getDataHoraInicioDia(filtroRecursoDTO.getPeriodoInicialPrazoAtendimento()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  DataUtil.getDataHoraInicioDia(filtroRecursoDTO.getPeriodoInicialPrazoAtendimento()));
        query.setParameter("igPeriodoFinalPrazoAtendimento", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPeriodoFinalPrazoAtendimento()));
        query.setParameter("periodoFinalPrazoAtendimento", DataUtil.getDataHoraFinalDia(filtroRecursoDTO.getPeriodoFinalPrazoAtendimento()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  DataUtil.getDataHoraFinalDia(filtroRecursoDTO.getPeriodoFinalPrazoAtendimento()));
        query.setParameter("igTipoPessoa", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getTipoPessoa()));
        query.setParameter("tipoPessoa", filtroRecursoDTO.getTipoPessoa()== null ? "": filtroRecursoDTO.getTipoPessoa());
        adicionarParametrosParte1Verificacao(filtroRecursoDTO, query);
    }

    private void adicionarParametrosParte1Verificacao(FiltroRecursoDTO filtroRecursoDTO, Query query){
        if(filtroRecursoDTO.getTipoPessoa()!= null) {
            if (filtroRecursoDTO.getTipoPessoa().equals("I")) {
                query.setParameter(IG_IDENTIDADE_PRESERVADA, NAO_IGNORA_CLAUSULA);
                query.setParameter("igTipoPessoa", IGNORA_CLAUSULA);
            } else {
                query.setParameter(IG_IDENTIDADE_PRESERVADA, IGNORA_CLAUSULA);
            }
        }else{
            query.setParameter(IG_IDENTIDADE_PRESERVADA, IGNORA_CLAUSULA);
        }
    }

    private void adicionarParametrosParte2(Query query, FiltroRecursoDTO filtroRecursoDTO) {
        query.setParameter("igPrazoVencidoFKS", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPrazoVencidoFKS()));
        query.setParameter("prazoVencidoFKS", filtroRecursoDTO.getPrazoVencidoFKS() == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  filtroRecursoDTO.getPrazoVencidoFKS());
        query.setParameter("igPrazoVencidoEsic", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPrazoVencidoEsic()));
        query.setParameter("prazoVencidoEsic", filtroRecursoDTO.getPrazoVencidoEsic() == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  filtroRecursoDTO.getPrazoVencidoEsic());
        query.setParameter("igIdInstanciaRecurso", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getIdInstanciaRecurso()));
        query.setParameter("IdInstanciaRecurso", filtroRecursoDTO.getIdInstanciaRecurso() == null ? Long.valueOf(-1L): filtroRecursoDTO.getIdInstanciaRecurso());
        query.setParameter("igPeriodoInicialVencimentoEsic", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPeriodoInicialVencimentoEsic()));
        query.setParameter("periodoInicialVencimentoEsic", DataUtil.getDataHoraInicioDia(filtroRecursoDTO.getPeriodoInicialVencimentoEsic()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  DataUtil.getDataHoraInicioDia(filtroRecursoDTO.getPeriodoInicialVencimentoEsic()));
        query.setParameter("igPeriodoFinalVencimentoEsic", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getPeriodoFinalVencimentoEsic()));
        query.setParameter("periodoFinalVencimentoEsic", DataUtil.getDataHoraFinalDia(filtroRecursoDTO.getPeriodoFinalVencimentoEsic()) == null ? DataUtil.getDataHoraInicioDia(Calendar.getInstance()):  DataUtil.getDataHoraFinalDia(filtroRecursoDTO.getPeriodoFinalVencimentoEsic()));
        query.setParameter("igIdSituacaoRecurso", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getIdSituacaoRecurso()));
        query.setParameter("idSituacaoRecurso", filtroRecursoDTO.getIdSituacaoRecurso() == null ? Long.valueOf(-1L): filtroRecursoDTO.getIdSituacaoRecurso());
        query.setParameter("igIdTipoRecurso", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getIdTipoRecurso()));
        query.setParameter("idTipoRecurso", filtroRecursoDTO.getIdTipoRecurso() == null ? Long.valueOf(-1L): filtroRecursoDTO.getIdTipoRecurso());
        query.setParameter("igNomeSolicitante", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getNomeSolicitante()));
        query.setParameter("nomeSolicitante",  filtroRecursoDTO.getNomeSolicitante() == null ? " ": "%" +  filtroRecursoDTO.getNomeSolicitante()  + "%");
        query.setParameter("igDescricaoJustificativa", QueryUtil.definirSeIgnoraClausula(filtroRecursoDTO.getDescricaoJustificativa()));
        query.setParameter("descricaoJustificativa", filtroRecursoDTO.getDescricaoJustificativa() == null ? " ": "%" +  filtroRecursoDTO.getDescricaoJustificativa()  + "%");
    }

    private void adicionarParametrosParte3(Query query, FiltroRecursoDTO filtroRecursoDTO) {
        int perfil = PerfilAcessoEnum.getIdByPerfil(usuarioLogadoUtil.getPerfil());
        query.setParameter(ID_USUARIO_ACESSOS, usuarioLogadoUtil.getUsuario() == null ? Long.valueOf(-1L) : usuarioLogadoUtil.getUsuario().getId());
        query.setParameter(ID_UNIDADE, usuarioLogadoUtil.getUsuario() == null ? Long.valueOf(-1L) : usuarioLogadoUtil.getUsuario().getUnidade().getId());
        query.setParameter(IG_UNIDADE,IGNORA_CLAUSULA);
        query.setParameter("igAcessos",NAO_IGNORA_CLAUSULA);
        if (!adicionarParametrosParte3Verificacao1(filtroRecursoDTO, query, perfil)){
            if(perfil == PerfilAcessoEnum.AUTORIDADE_MAXIMA.getIdPerfil() && filtroRecursoDTO.getIdDemandasComigo() == 2){
                query.setParameter(IG_PONTO_FOCAL, IGNORA_CLAUSULA);
                query.setParameter(IG_ATENDENTE_SIC, IGNORA_CLAUSULA);
                query.setParameter(IG_PONTO_FOCAL_AUT_MAX, IGNORA_CLAUSULA);
                query.setParameter(IG_AUTORIDADE_HIERARQ, IGNORA_CLAUSULA);
                query.setParameter(IG_AUTORIDADE_MAX, NAO_IGNORA_CLAUSULA);
            }else if(filtroRecursoDTO.getIdDemandasComigo() != 1){
                ignoreAllPerfil(query);
            }
        }
    }

    public boolean adicionarParametrosParte3Verificacao1(FiltroRecursoDTO filtroRecursoDTO, Query query, int perfil){
        if(filtroRecursoDTO.getIdDemandasComigo() == 3) {
            query.setParameter("igAcessos",IGNORA_CLAUSULA);
            query.setParameter(IG_UNIDADE,NAO_IGNORA_CLAUSULA);
            ignoreAllPerfil(query);
            return true;
        }else if (perfil == PerfilAcessoEnum.ATENDENTE_SIC.getIdPerfil() && filtroRecursoDTO.getIdDemandasComigo() == 2) {
            query.setParameter(IG_ATENDENTE_SIC, NAO_IGNORA_CLAUSULA);
            query.setParameter(IG_PONTO_FOCAL, IGNORA_CLAUSULA);
            query.setParameter(IG_PONTO_FOCAL_AUT_MAX, IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_HIERARQ, IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_MAX, IGNORA_CLAUSULA);
            return true;
        }
        return adiconarParametrosParte3Verificacao2(filtroRecursoDTO, query, perfil);
    }

    public boolean adiconarParametrosParte3Verificacao2(FiltroRecursoDTO filtroRecursoDTO, Query query, int perfil){
        if (perfil == PerfilAcessoEnum.PONTO_FOCAL.getIdPerfil() && filtroRecursoDTO.getIdDemandasComigo() == 2) {
            query.setParameter(IG_PONTO_FOCAL, NAO_IGNORA_CLAUSULA);
            query.setParameter(IG_ATENDENTE_SIC, IGNORA_CLAUSULA);
            query.setParameter(IG_PONTO_FOCAL_AUT_MAX, IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_HIERARQ, IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_MAX, IGNORA_CLAUSULA);
            return true;
        } else if (perfil == PerfilAcessoEnum.PONTO_FOCAL_AUTORIDADE_MAXIMA.getIdPerfil() && filtroRecursoDTO.getIdDemandasComigo() == 2) {
            query.setParameter(IG_PONTO_FOCAL, IGNORA_CLAUSULA);
            query.setParameter(IG_ATENDENTE_SIC, IGNORA_CLAUSULA);
            query.setParameter(IG_PONTO_FOCAL_AUT_MAX, NAO_IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_HIERARQ, IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_MAX, IGNORA_CLAUSULA);
            return true;
        }
        return adiconarParametrosParte3Verificacao3(filtroRecursoDTO, query, perfil);
    }

    public boolean adiconarParametrosParte3Verificacao3(FiltroRecursoDTO filtroRecursoDTO, Query query, int perfil){
         if (perfil == PerfilAcessoEnum.AUTORIDADE_HIERARQUICA.getIdPerfil() && filtroRecursoDTO.getIdDemandasComigo() == 2) {
            query.setParameter(IG_PONTO_FOCAL, IGNORA_CLAUSULA);
            query.setParameter(IG_ATENDENTE_SIC, IGNORA_CLAUSULA);
            query.setParameter(IG_PONTO_FOCAL_AUT_MAX, IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_HIERARQ, NAO_IGNORA_CLAUSULA);
            query.setParameter(IG_AUTORIDADE_MAX, IGNORA_CLAUSULA);
            return true;
        }
         return false;
    }


    public void ignoreAllPerfil(Query query){
        query.setParameter(IG_PONTO_FOCAL, IGNORA_CLAUSULA);
        query.setParameter(IG_ATENDENTE_SIC, IGNORA_CLAUSULA);
        query.setParameter(IG_PONTO_FOCAL_AUT_MAX, IGNORA_CLAUSULA);
        query.setParameter(IG_AUTORIDADE_HIERARQ, IGNORA_CLAUSULA);
        query.setParameter(IG_AUTORIDADE_MAX, IGNORA_CLAUSULA);
    }


    public Recurso detalharRecurso(Long idRecurso) {
        String hqlDetalharRecurso = "";
        hqlDetalharRecurso = hqlDetalharRecurso.concat(SELECT_RECURSO);
        hqlDetalharRecurso = hqlDetalharRecurso.concat(JOIN_FETCH_STATUS_SOLICITACAO);
        hqlDetalharRecurso = hqlDetalharRecurso.concat(JOIN_FETCH_TIPO_RECURSO);
        hqlDetalharRecurso = hqlDetalharRecurso.concat(JOIN_FETCH_SITUACAO_RECURSO);
        hqlDetalharRecurso = hqlDetalharRecurso.concat(JOIN_FETCH_PEDIDO);
        hqlDetalharRecurso = hqlDetalharRecurso.concat(JOIN_FETCH_SOLICITANTE);
        hqlDetalharRecurso = hqlDetalharRecurso.concat(WHERE_RECURSO_ID);
        Query query = getEntityManager().createQuery(hqlDetalharRecurso);
        query.setParameter("idRecurso", idRecurso);
        List<Recurso> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public List<Recurso> efetuarConsultaRecurso(FiltroRecursoDTO filtroRecursoDTO) {
        String hqlEfetuarConsultaRecurso = "";
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(SELECT_RECURSO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(JOIN_FETCH_SITUACAO_RECURSO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(JOIN_FETCH_STATUS_TRAMITACAO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(JOIN_FETCH_STATUS_SOLICITACAO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(JOIN_FETCH_PEDIDO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(JOIN_FETCH_SOLICITANTE);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(JOIN_FETCH_TIPO_RECURSO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(WHERE_RECURSO);
        hqlEfetuarConsultaRecurso = hqlEfetuarConsultaRecurso.concat(montarCondicionais());
        Query query = getEntityManager().createQuery(hqlEfetuarConsultaRecurso);
        adicionarParametrosParte1(query, filtroRecursoDTO);
        adicionarParametrosParte2(query, filtroRecursoDTO);
        return query.getResultList();
    }

    public void verificaPerfilDoUsuario(FiltroRecursoDTO filtroRecursoDTO) {
        if (usuarioLogadoUtil.getPerfil().equals("FKS.PONTO.FOCAL")) {
            filtroRecursoDTO.setIdStatusSolicitacao(2L);
        }
    }
}
