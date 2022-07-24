package br.com.company.fks.servico;

import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.ReencaminharSolicitacao;
import br.com.company.fks.modelo.SituacaoPedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.dto.ReencaminharSolicitacaoDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.ReencaminharSolicitacaoRepository;
import br.com.company.fks.repositorio.SituacaoPedidoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReencaminharSolicitacaoService {

    private static final String REENCAMINHADA = "Solicitação reencaminhada para ";

    @Autowired
    private ReencaminharSolicitacaoRepository reencaminharSolicitacaoRepository;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Autowired
    private StatusTramitacaoRepository statusTramitacaoRepository;

    @Autowired
    private SituacaoPedidoRepository situacaoPedidoRepository;

    @Autowired
    private UnidadeService unidadeService;

    @Transactional
    public void salvar(ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO) {
        Pedido pedido = alterarStatusReencaminhar(reencaminharSolicitacaoDTO.getIdPedido());
        if (pedido.getRespostaEsic() != null) {
            pedido.setRespostaEsic(null);
        }
        ReencaminharSolicitacao reencaminharSolicitacao = new ReencaminharSolicitacao();
        reencaminharSolicitacao.setPedido(pedido);
        reencaminharSolicitacao.setOrgao(reencaminharSolicitacaoDTO.getOrgao());
        reencaminharSolicitacao.setNotificacaoEnviadaSolicitante(reencaminharSolicitacaoDTO.getNotificacaoEnviadaSolicitante());
        reencaminharSolicitacao.setNotificacaoEnviadaDestinatario(reencaminharSolicitacaoDTO.getNotificacaoEnviadaDestinatario());
        reencaminharSolicitacaoRepository.save(reencaminharSolicitacao);
        gerarAndamentoReverter(pedido, reencaminharSolicitacao, reencaminharSolicitacaoDTO);

    }

    private void gerarAndamentoReverter(Pedido pedido, ReencaminharSolicitacao reencaminharSolicitacao, ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO) {
        if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.REENCAMINHADA)) {
            andamentoService.gerarAndamentoSolicitacao(pedido, false, REENCAMINHADA + reencaminharSolicitacao.getOrgao().getDescricao());
        }
        else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO) && usuarioLogadoUtil.getPerfil().equals("FKS.RESPONDENTE")) {
            andamentoService.reverterAndamento(pedido, REENCAMINHADA + reencaminharSolicitacao.getOrgao().getDescricao(), usuarioLogadoUtil.getUsuario().getUnidade());
        }
        else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO) && usuarioLogadoUtil.getPerfil().equals("FKS.TECNICO")) {
            Subunidade subunidade = unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf());
            Andamento penultimoAndamento = andamentoRepository.recuperarAndamentosPedido(reencaminharSolicitacaoDTO.getIdPedido()).get(1);
            andamentoService.reverterAndamento(pedido, REENCAMINHADA + reencaminharSolicitacao.getOrgao().getDescricao(), subunidade, penultimoAndamento.getUsuarioAcessos().get(0));
        }
        else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO)) {
            andamentoService.reverterAndamento(pedido, REENCAMINHADA + reencaminharSolicitacao.getOrgao().getDescricao(), unidadeRepository.findOne(1L));
        }
    }

    public Pedido alterarStatusReencaminhar(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        novosStatusPedido(pedido, andamentoRepository.recuperarAndamentosPedido(idPedido));
        pedido.setIsDevolver(false);
        return pedidoRepository.save(pedido);
    }

    private void novosStatusPedido(Pedido pedido, List<Andamento> listaAndamento) {
        if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.TRIAGEM_SIC)) {
            setaNovosStatusPedido(pedido, StatusTramitacao.REENCAMINHADA, StatusSolicitacao.REENCAMINHADA, SituacaoPedido.REENCAMINHADO);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)) {
            setaNovosStatusPedido(pedido, StatusTramitacao.SIC, StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO, SituacaoPedido.EM_TRAMITACAO);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA) || pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.EDICAO_TECNICO)) {
            setaNovosStatusPedido(pedido, StatusTramitacao.ANDAMENTO, StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO, SituacaoPedido.EM_TRAMITACAO);
        }
        validaStatusPedido(listaAndamento, pedido);
    }

    private void validaStatusPedido(List<Andamento> listaAndamento, Pedido pedido) {

        if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO) && !listaAndamento.get(0).getUsuarioAcessos().isEmpty()) {
            setaNovosStatusPedido(pedido, StatusTramitacao.ANDAMENTO, StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO, SituacaoPedido.EM_TRAMITACAO);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO) && !listaAndamento.get(0).getListaUnidade().get(0).getId().equals(1L)) {
            setStatusPedido(pedido);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO) && !listaAndamento.get(0).getUnidade().getId().equals(1L)) {
            setaNovosStatusPedido(pedido, StatusTramitacao.REENCAMINHADA, StatusSolicitacao.REENCAMINHADA, SituacaoPedido.REENCAMINHADO);
        }

    }

    private void setStatusPedido(Pedido pedido) {
        if (usuarioLogadoUtil.getNome().equals("Ponto Focal")) {
            setaNovosStatusPedido(pedido, StatusTramitacao.SIC, StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO, SituacaoPedido.EM_TRAMITACAO);
        } else {
            setaNovosStatusPedido(pedido, StatusTramitacao.ANDAMENTO, StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO, SituacaoPedido.EM_TRAMITACAO);
        }
    }

    private void setaNovosStatusPedido(Pedido pedido, Long idStatusTramitacao, Long idStatusSolicitacao, String idSituacaoPedido) {
        pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(idStatusSolicitacao));
        pedido.setStatusTramitacao((statusTramitacaoRepository.findOne(idStatusTramitacao)));
        pedido.setSituacaoPedido(situacaoPedidoRepository.findByNome(idSituacaoPedido));
    }

    public ReencaminharSolicitacaoDTO buscarReencaminhamentoParaOrgao(Long idPedido) {
        ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO = new ReencaminharSolicitacaoDTO();
        Pedido pedido = pedidoRepository.findById(idPedido);
        List<ReencaminharSolicitacao> listaReencaminharSolicitacao = reencaminharSolicitacaoRepository.findByPedido(pedido);
        if (listaReencaminharSolicitacao.isEmpty()) {
            return reencaminharSolicitacaoDTO;
        } else {
            ReencaminharSolicitacao reencaminharSolicitacao = listaReencaminharSolicitacao.get(listaReencaminharSolicitacao.size() - 1);
            reencaminharSolicitacaoDTO.setId(reencaminharSolicitacao.getId());
            reencaminharSolicitacaoDTO.setNotificacaoEnviadaSolicitante(reencaminharSolicitacao.getNotificacaoEnviadaSolicitante());
            reencaminharSolicitacaoDTO.setNotificacaoEnviadaDestinatario(reencaminharSolicitacao.getNotificacaoEnviadaDestinatario());
            reencaminharSolicitacaoDTO.setOrgao(reencaminharSolicitacao.getOrgao());
            return reencaminharSolicitacaoDTO;
        }

    }
}
