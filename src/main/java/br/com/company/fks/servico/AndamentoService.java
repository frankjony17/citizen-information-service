package br.com.company.fks.servico;

import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AndamentoPedidoDTO;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import br.com.company.fks.modelo.dto.RespostaAssinadaDTO;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Service
public class AndamentoService {

    private static final String FKS_ADMIN = "FKS.ADMIN";
    private static final String FKS_PONTO_FOCAL = "FKS.PONTO.FOCAL";
    private static final String FKS_RESPONDENTE = "FKS.RESPONDENTE";
    private static final String FKS_TECNICO = "FKS.TECNICO";

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private UnidadeService unidadeService;

    public void criarAndamento(Andamento andamento) {
        andamentoRepository.save(andamento);
    }

    @Transactional
    public Andamento gerarAndamentoSolicitacao(Pedido pedido, Boolean isFluxoDeImportacaoPedido, String observacao) {
        if (isFluxoDeImportacaoPedido) {
            Andamento andamento = new Andamento();
            andamento.setUnidade(unidadeRepository.findOne(1L));
            andamento.setDataInicio(Calendar.getInstance());
            andamento.setDataFim(null);
            andamento.setResponsavel(observacao);
            andamento.setObservacao(null);
            andamento.setPedido(pedido);
            andamento.setStatusTramitacao(pedido.getStatusTramitacao());
            andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
            andamento.setListaUnidade(Arrays.asList(andamento.getUnidade()));
            return andamentoRepository.save(andamento);
        } else {
            reverterAndamento(pedido, observacao);
            return null;
        }
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao) {
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento();
        andamento.setUnidade(null);
        andamento.setDataInicio(dataNovoAndamento);
        andamento.setDataFim(null);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacao(observacao);
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setPedido(pedido);
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, Unidade unidade) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessos, unidade, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setListaUnidade(Arrays.asList(unidade));
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, Subunidade subunidade) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessos, subunidade ,dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setListaSubunidade(Arrays.asList(subunidade));
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, Unidade unidade, Subunidade subunidade) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessos, subunidade, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setListaUnidade(Arrays.asList(unidade));
        andamento.setListaSubunidade(Arrays.asList(subunidade));
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, Subunidade subunidade, UsuarioAcessos usuarioAcessos) {
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessos, subunidade, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setListaSubunidade(Arrays.asList(subunidade));
        andamento.setUsuarioAcessos(Arrays.asList(usuarioAcessos));
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, Unidade unidade, Subunidade subunidade, UsuarioAcessos usuarioAcessos) {
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessos, subunidade, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setListaUnidade(Arrays.asList(unidade));
        andamento.setListaSubunidade(Arrays.asList(subunidade));
        andamento.setUsuarioAcessos(Arrays.asList(usuarioAcessos));
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, String justificativa) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessos, (Unidade) null, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setJustificativa(justificativa);
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        andamentoRepository.save(andamento);
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, PropostaRespostaDTO propostaRespostaDTO) {
        UsuarioAcessos usuarioAcessosAssinatura = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);
        Andamento andamento = new Andamento(usuarioAcessosAssinatura, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());
        List<Unidade> listaUnidades = new ArrayList<>();
        reverterAndamentoVerificacaoLoop(propostaRespostaDTO, listaUnidades);
        if ((usuarioLogadoUtil.getPerfil().equals("FKS.ATENDENTE.SIC") || usuarioLogadoUtil.getPerfil().equals(FKS_ADMIN)) && (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF))) {
            andamento.setListaUnidade(listaUnidades);
            andamento.setUnidade(listaUnidades.get(0));
        } else {
            reverterAndamentoVerificacao1(pedido, andamento, propostaRespostaDTO, ultimoAndamento);
        }
        andamentoRepository.save(andamento);
    }

    private void reverterAndamentoVerificacaoLoop(PropostaRespostaDTO propostaRespostaDTO, List<Unidade> listaUnidades){
        if (propostaRespostaDTO.getListaUnidade() != null) {
            for (Unidade unidades : propostaRespostaDTO.getListaUnidade()) {
                if (unidades.getCodigoUnidade() != null) {
                    listaUnidades.add(unidades);
                }
            }
        }
    }

    private void reverterAndamentoVerificacao1(Pedido pedido, Andamento andamento, PropostaRespostaDTO propostaRespostaDTO, Andamento ultimoAndamento){
        if (usuarioLogadoUtil.getPerfil().equals("FKS.ATENDENTE.SIC") || usuarioLogadoUtil.getPerfil().equals(FKS_ADMIN)) {
            Unidade unidade = unidadeRepository.findOne(1L);
            andamento.setListaUnidade(Arrays.asList(unidade));
            andamento.setUnidade(unidade);
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_PONTO_FOCAL)
                && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_SIC)
                || pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PARA_ENVIO)) {
            Unidade unidade = unidadeRepository.findOne(1L);
            andamento.setListaUnidade(Arrays.asList(unidade));
            andamento.setUnidade(unidade);
        }else{
            reverterAndamentoVerificacao2(pedido, andamento, propostaRespostaDTO, ultimoAndamento);
        }
    }

    private void reverterAndamentoVerificacao2(Pedido pedido, Andamento andamento, PropostaRespostaDTO propostaRespostaDTO, Andamento ultimoAndamento){
        if (usuarioLogadoUtil.getPerfil().equals(FKS_PONTO_FOCAL) && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            andamento.setListaSubunidade(propostaRespostaDTO.getListaSubunidade());
            andamento.setUsuarioAcessos(propostaRespostaDTO.getListaUsuarioAcessos());
            andamento.setSubunidade(propostaRespostaDTO.getListaSubunidade().get(0));
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_RESPONDENTE) && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.EDICAO_TECNICO)) {
            andamento.setListaSubunidade(Collections.singletonList(unidadeService.getOneSubunidadePeloUsuarioCpf(propostaRespostaDTO.getListaUsuarioAcessos().get(0).getCpfUsuario())));
            andamento.setUsuarioAcessos(propostaRespostaDTO.getListaUsuarioAcessos());
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_TECNICO)) {
            Subunidade subunidade = unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf());
            andamento.setListaUnidade(Collections.singletonList(usuarioLogadoUtil.getUsuario().getUnidade()));
            andamento.setListaSubunidade(Collections.singletonList(subunidade));
            andamento.setUsuarioAcessos(Collections.singletonList(ultimoAndamento.getUsuarioAcessos().get(0)));
            andamento.setSubunidade(subunidade);
        }
    }

    @Transactional
    public void reverterAndamento(Pedido pedido, String observacao, RespostaAssinadaDTO respostaAssinadaDTO) {
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        Andamento ultimoAndamento = listaAndamento.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);

        Andamento andamento = new Andamento((Unidade) null, dataNovoAndamento, null, pedido, observacao);
        andamento.setResponsavel(usuarioLogadoUtil.getNome());
        andamento.setUsuarioAcessosAssinatura(usuarioLogadoUtil.getUsuario());
        andamento.setObservacaoUsuario(pedido.getObservacao());
        andamento.setStatusTramitacao(pedido.getStatusTramitacao());
        andamento.setStatusSolicitacao(pedido.getStatusSolicitacao());
        andamento.setStatusRespostaAssinada(pedido.getStatusRespostaAssinada());


        if (usuarioLogadoUtil.getPerfil().equals(FKS_RESPONDENTE) && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF)) {
            andamento.setListaUnidade(Arrays.asList(respostaAssinadaDTO.getUnidade()));
            andamento.setUnidade(respostaAssinadaDTO.getUnidade());
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_PONTO_FOCAL) && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_SIC)) {
            andamento.setListaUnidade(Arrays.asList(respostaAssinadaDTO.getUnidade()));
            andamento.setUnidade(respostaAssinadaDTO.getUnidade());
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_TECNICO) && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            andamento.setListaSubunidade(Arrays.asList(respostaAssinadaDTO.getSubunidade()));
            andamento.setSubunidade(respostaAssinadaDTO.getSubunidade());
            andamento.setUsuarioAcessos(Arrays.asList(listaAndamento.get(1).getUsuarioAcessos().get(0)));
        } else {
            reverterAndamentoVerificacao(pedido, andamento, respostaAssinadaDTO);
        }
        andamentoRepository.save(andamento);
    }

    private void reverterAndamentoVerificacao(Pedido pedido, Andamento andamento, RespostaAssinadaDTO respostaAssinadaDTO){
        if (usuarioLogadoUtil.getPerfil().equals(FKS_ADMIN)
                || usuarioLogadoUtil.getPerfil().equals("FKS.SIC")
                && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.TRIAGEM_SIC)
                || pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PARA_ENVIO)
                || pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)
                || pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_SIC)) {
            andamento.setListaUnidade(Arrays.asList(respostaAssinadaDTO.getUnidade()));
            andamento.setUnidade(respostaAssinadaDTO.getUnidade());
        }
    }

    public Page<AndamentoPedidoDTO> consultarAndamentoPedido(Long idPedido, Integer offset, Integer limit) {
        Pageable pageable = new PageRequest(offset, limit);

        return andamentoRepository.recuperarAndamentoPedidoEStatusTramitacao(pedidoRepository.findById(idPedido), pageable);
    }

    public String buscarObservacaoAndamento(Long idPedido) {
        List<Andamento> listaAndamento = andamentoRepository.findByPedido(idPedido);
        Andamento andamento = listaAndamento.get(listaAndamento.size() - 1);
        return andamento.getObservacaoUsuario();
    }

    public boolean verificaAssinatura(Long idPedido) {
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(idPedido);
        if (usuarioLogadoUtil.getPerfil().equals(FKS_RESPONDENTE)) {
            for (Andamento andamento : listaAndamento) {
                if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)
                        && andamento.getStatusRespostaAssinada()) {
                    return true;
                }
            }
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_TECNICO)) {
            for (Andamento andamento : listaAndamento) {
                if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)
                        && andamento.getStatusRespostaAssinada()) {
                    return true;
                }
            }
        }
        return false;
    }
}
