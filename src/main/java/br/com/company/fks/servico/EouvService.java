package br.com.company.fks.servico;

import br.com.company.fks.modelo.EOuv;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.EouvDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.EouvRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EouvService {

    private static final String E_OUV = "Solicitação encaminhada para e-OUV";
    private static final String VALIDAR_E_OUV = "Validação e-OUV";
    private static final String FKS_RESPONDENTE = "FKS.RESPONDENTE";

    @Autowired
    private EouvRepository eouvRepository;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private HistoricoTratamentoService historicoTratamentoService;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Autowired
    private StatusTramitacaoRepository statusTramitacaoRepository;

    @Autowired
    private UnidadeService unidadeService;

    @Transactional
    public void salvar(EouvDTO eouvDTO) {
        TipoTratamento tipoTratamento = new TipoTratamento();
        tipoTratamento.setId(TipoTratamento.ENCAMINHADA_EOUV);
        Pedido pedido = pedidoService.alterarStatusEouv(eouvDTO);
        saveEouv(pedido, tipoTratamento, eouvDTO);
        historicoTratamentoService.gerarHistoricoTratamento(pedido, TipoTratamento.ENCAMINHADA_EOUV, false);
        validaSolicitacaoEouv(pedido, eouvDTO);
    }

    private void saveEouv (Pedido pedido, TipoTratamento tipoTratamento, EouvDTO eouvDTO) {
        EOuv eOuv = new EOuv();
        eOuv.setPedido(pedido);
        eOuv.setTipoTratamento(tipoTratamento);
        eOuv.getPedido().setRespostaEsic(eouvDTO.getTipoManifestacao().getDescricao());
        eOuv.setCategoria(eouvDTO.getCategoria());
        eOuv.setSubcategoria(eouvDTO.getSubcategoria());
        eOuv.setTipoManifestacao(eouvDTO.getTipoManifestacao());
        eOuv.setRestricaoConteudo(eouvDTO.getRestricaoConteudo());
        eouvRepository.save(eOuv);
    }

    private void validaSolicitacaoEouv(Pedido pedido, EouvDTO eouvDTO) {
        Long idStatus = pedido.getStatusSolicitacao().getId();
        if (isValid(idStatus)) {
            save1(pedido, E_OUV, andamentoRepository.recuperarAndamentosPedido(eouvDTO.getIdPedido()).get(1).getUsuarioAcessos().get(0));
        }
        else if (idStatus.equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF) && usuarioLogadoUtil.getPerfil().equals(FKS_RESPONDENTE)) {
            save2(pedido, E_OUV);
        }
        else if (idStatus.equals(StatusSolicitacao.RESPOSTA_SIC) && usuarioLogadoUtil.getPerfil().equals("FKS.PONTO.FOCAL")) {
            andamentoService.reverterAndamento(pedido, E_OUV, unidadeRepository.findOne(1L));
        }
        else {
            save2(pedido, E_OUV);
        }
    }

    public boolean verificaSeExisteEOuvPedido(Pedido pedido) {
        EOuv eOuv = eouvRepository.findByEOuvPorIdPedido(pedido);
        return eOuv != null;
    }

    public List<PalavraChave> buscarPalavraChavePedido(Long idPedido) {
        return pedidoRepository.findOne(idPedido).getPalavraChaveList();
    }

    public void validarEouv(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        Long idStatus = pedido.getStatusSolicitacao().getId();
        if (usuarioLogadoUtil.getPerfil().equals(FKS_RESPONDENTE) && idStatus.equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            pedido.setStatusRespostaAssinada(true);
        }
        if (idStatus.equals(StatusSolicitacao.RESPOSTA_SIC) && usuarioLogadoUtil.getPerfil().equals("FKS.ATENDENTE.SIC")) {
            setStatusSolicitacao(pedido, StatusSolicitacao.REVISAO, StatusTramitacao.RESPONDIDAS);
            save2(pedido, VALIDAR_E_OUV);
        } else if (idStatus.equals(StatusSolicitacao.TRIAGEM_SIC) && usuarioLogadoUtil.getPerfil().equals("FKS.ATENDENTE.SIC")) {
            setStatusSolicitacao(pedido, StatusSolicitacao.RESPOSTA_SIC, StatusTramitacao.RESPONDIDAS);
            save2(pedido, VALIDAR_E_OUV);
        }
        validacaoEouv(pedido);
        pedidoRepository.save(pedido);
    }

    private void validacaoEouv(Pedido pedido) {
        Long idStatus = pedido.getStatusSolicitacao().getId();
        if ((idStatus.equals(StatusSolicitacao.DISTRIBUICAO_PF) || idStatus.equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF)) && usuarioLogadoUtil.getPerfil().equals("FKS.PONTO.FOCAL")) {
            setStatusSolicitacao(pedido, StatusSolicitacao.RESPOSTA_SIC, StatusTramitacao.RESPONDIDAS);
            save2(pedido, VALIDAR_E_OUV);
        }
        else if (idStatus.equals(StatusSolicitacao.PRODUCAO_RESPOSTA) && usuarioLogadoUtil.getPerfil().equals(FKS_RESPONDENTE)) {
            setStatusSolicitacao(pedido, StatusSolicitacao.RESPOSTA_ASSINADA_PF, StatusTramitacao.ANDAMENTO);
            save1(pedido, E_OUV, usuarioLogadoUtil.getUsuario());
        }
        else if (idStatus.equals(StatusSolicitacao.EDICAO_TECNICO) && usuarioLogadoUtil.getPerfil().equals("FKS.TECNICO")) {
            setStatusSolicitacao(pedido, StatusSolicitacao.PRODUCAO_RESPOSTA, StatusTramitacao.ANDAMENTO);
            save1(pedido, E_OUV, usuarioLogadoUtil.getUsuario());
        }
    }

    private void setStatusSolicitacao (Pedido pedido, Long statusUm, Long statusDois) {
        pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(statusUm));
        pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(statusDois));
    }

    private void save1 (Pedido pedido, String eouv, UsuarioAcessos usuario) {
        andamentoService.reverterAndamento(pedido, eouv, unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf()), usuario);
    }

    private void save2 (Pedido pedido, String eouv) {
        andamentoService.reverterAndamento(pedido, eouv, usuarioLogadoUtil.getUsuario().getUnidade());
    }

    private boolean isValid (Long idStatus) {
        boolean bool = false;
        Long status1 = StatusSolicitacao.PRODUCAO_RESPOSTA;
        Long status2 = StatusSolicitacao.RESPOSTA_ASSINADA_PF;
        if (idStatus.equals(status1) || (idStatus.equals(status2) && usuarioLogadoUtil.getPerfil().equals("FKS.TECNICO"))) {
            bool = true;
        }
        return bool;
    }
}
