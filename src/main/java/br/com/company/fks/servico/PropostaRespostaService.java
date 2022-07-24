package br.com.company.fks.servico;

import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.command.PropostaRespostaCommandImpl;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropostaRespostaService {

    private static final String PROPOSTA_RESPOSTA = "Solicitação encaminhada como proposta de resposta";
    private static final String DISTRIBUICAO_PF = "Distribuição PF";
    private static final String PRODUCAO_RESPOSTA = "Produção de Resposta";
    private static final String EDICAO_TECNICO = "Edição Técnico";
    private static final String PARA_ENVIO = "Para Envio";
    private static final String RESPOSTA_SIC = "Resposta SIC";
    private static final String TRIAGEM_SIC = "Triagem SIC";

    @Autowired
    private HistoricoTratamentoService historicoTratamentoService;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Transactional
    public void enviar(PropostaRespostaDTO propostaRespostaDTO) {
        Pedido pedido = pedidoRepository.findById(propostaRespostaDTO.getIdPedido());
        if (propostaRespostaDTO.getObservacao() != null) {
            pedido.setObservacao(propostaRespostaDTO.getObservacao());
        }
        pedido.setStatusSolicitacao(new StatusSolicitacao());
        pedido.setStatusTramitacao(new StatusTramitacao());
        statusSolicitacao(pedido, propostaRespostaDTO);
        pedido.setIsDevolver(false);
        pedido.setRespostaEsic(pedido.getPropostaResposta());
        if (pedido.getRespostaEsic() != null) {
            historicoTratamentoService.gerarHistoricoTratamento(pedido, TipoTratamento.PROPOSTA_RESPOSTA, false);
        }
        andamentoGerarReverter(pedido, propostaRespostaDTO);
    }

    private void andamentoGerarReverter (Pedido pedido, PropostaRespostaDTO propostaRespostaDTO) {
        pedido.setRespostaEsic(null);
        if (StatusSolicitacao.DISTRIBUICAO_PF.equals(propostaRespostaDTO.getIdStatusSolicitacao())
                || StatusSolicitacao.PRODUCAO_RESPOSTA.equals(propostaRespostaDTO.getIdStatusSolicitacao())
                || StatusSolicitacao.EDICAO_TECNICO.equals(propostaRespostaDTO.getIdStatusSolicitacao())
                || (StatusSolicitacao.PARA_ENVIO.equals(propostaRespostaDTO.getIdStatusSolicitacao())
                || (StatusSolicitacao.RESPOSTA_SIC.equals(propostaRespostaDTO.getIdStatusSolicitacao())
                && usuarioLogadoUtil.getPerfil().equals(PerfilAcessoEnum.getPerfilById(5))))) {
            andamentoService.reverterAndamento(pedido, PROPOSTA_RESPOSTA, propostaRespostaDTO);
        } else {
            andamentoService.gerarAndamentoSolicitacao(pedido, false, PROPOSTA_RESPOSTA);
        }
    }

    private void statusSolicitacao (Pedido pedido, PropostaRespostaDTO propostaRespostaDTO) {
        PropostaRespostaCommandImpl command = new PropostaRespostaCommandImpl();
        command.setarStatusSolicitacao(propostaRespostaDTO.getIdStatusSolicitacao(), pedido, propostaRespostaDTO);
    }

    public void excluirRespostaFKS(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        pedido.setPropostaResposta(null);
        pedidoRepository.save(pedido);
    }

    public PropostaRespostaDTO buscarDadosEncaminhamento(Long idPedido) {
        PropostaRespostaDTO propostaRespostaDTO = new PropostaRespostaDTO();
        Pedido pedido = pedidoRepository.buscarPedidoEStatusSolicitacao(idPedido);
        Long id = pedido.getStatusSolicitacao().getId();
        if (id.equals(StatusSolicitacao.TRIAGEM_SIC)) {
            propostaRespostaDTO = montarPropostaRespostaDTO(pedido, DISTRIBUICAO_PF, StatusSolicitacao.DISTRIBUICAO_PF);
        } else if (id.equals(StatusSolicitacao.DISTRIBUICAO_PF) || id.equals(StatusSolicitacao.EDICAO_TECNICO)) {
            propostaRespostaDTO = montarPropostaRespostaDTO(pedido, PRODUCAO_RESPOSTA, StatusSolicitacao.PRODUCAO_RESPOSTA);
        } else if (id.equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            propostaRespostaDTO = montarPropostaRespostaDTO(pedido, EDICAO_TECNICO, StatusSolicitacao.EDICAO_TECNICO);
        } else if (id.equals(StatusSolicitacao.REVISAO)) {
            propostaRespostaDTO = montarPropostaRespostaDTO(pedido, PARA_ENVIO, StatusSolicitacao.PARA_ENVIO);
        } else if (id.equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF)) {
            propostaRespostaDTO = montarPropostaRespostaDTO(pedido, RESPOSTA_SIC, StatusSolicitacao.RESPOSTA_SIC);
        } else if (id.equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO)) {
            propostaRespostaDTO = defineStatusSolicitacaoQuandoSugestaoDeReencaminhamento(pedido);
        }
        return propostaRespostaDTO;
    }

    private PropostaRespostaDTO defineStatusSolicitacaoQuandoSugestaoDeReencaminhamento(Pedido pedido) {
        PropostaRespostaDTO propostaRespostaDTO = new PropostaRespostaDTO();
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Andamento andamento = listaAndamento.get(0);
        if (!andamento.getListaUnidade().isEmpty()) {
            if (andamento.getListaUnidade().get(0).getId() == 1L) {
                propostaRespostaDTO = montarPropostaRespostaDTO(pedido, DISTRIBUICAO_PF, StatusSolicitacao.DISTRIBUICAO_PF);
                propostaRespostaDTO.setNomeStatusSolicitacaoPedido(TRIAGEM_SIC);
            } else {
                propostaRespostaDTO = montarPropostaRespostaDTO(pedido, PRODUCAO_RESPOSTA, StatusSolicitacao.PRODUCAO_RESPOSTA);
                propostaRespostaDTO.setNomeStatusSolicitacaoPedido(DISTRIBUICAO_PF);
            }
        } else if (!andamento.getUsuarioAcessos().isEmpty() && andamento.getUsuarioAcessos().get(0).getPerfilUsuario().equals(PerfilAcessoEnum.getPerfilById(8))) {
            propostaRespostaDTO = montarPropostaRespostaDTO(pedido, EDICAO_TECNICO, StatusSolicitacao.EDICAO_TECNICO);
            propostaRespostaDTO.setNomeStatusSolicitacaoPedido(PRODUCAO_RESPOSTA);
        }
        return propostaRespostaDTO;
    }

    private PropostaRespostaDTO montarPropostaRespostaDTO(Pedido pedido, String nomeStatusSolicitacao, Long idStatusSolicitacao) {
        PropostaRespostaDTO propostaRespostaDTO = new PropostaRespostaDTO();
        propostaRespostaDTO.setPropostaResposta(pedido.getPropostaResposta());
        propostaRespostaDTO.setNomeStatusSolicitacaoPedido(pedido.getStatusSolicitacao().getNome());
        propostaRespostaDTO.setNomeStatusSolicitacao(nomeStatusSolicitacao);
        propostaRespostaDTO.setIdStatusSolicitacao(idStatusSolicitacao);
        return propostaRespostaDTO;
    }

    public String obterAssinatura (Long idPedido) {
        Unidade unidade;
        StringBuilder assinaturas = new StringBuilder();
        Andamento andamento = andamentoRepository.findTopByPedidoId(idPedido);
        if (andamento.getUnidade() != null) {
            unidade = andamento.getUnidade();
        } else if (andamento.getSubunidade() != null) {
            unidade = andamento.getSubunidade().getUnidade();
        } else {
            unidade = andamento.getUsuarioAcessosAssinatura().getUnidade();
        }
        getAssinaturas(assinaturas, unidade);
        return assinaturas.toString();
    }

    private void getAssinaturas (StringBuilder assinaturas, Unidade unidade) {
        UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(unidade.getId(), PerfilAcessoEnum.getPerfilById(6));
        UsuarioAcessoPerfilAcesso usuarioLogadoAssinatura = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(usuarioLogadoUtil.getUsuario().getCpfUsuario(), usuarioLogadoUtil.getPerfil());

        if (usuarioLogadoAssinatura != null && usuarioLogadoAssinatura.getAssinaturaUsuario() != null) {
            assinaturas.append(usuarioLogadoAssinatura.getAssinaturaUsuario());
        }
        assinaturas.append("#|#");
        if (usuarioAcessoPerfilAcesso != null && usuarioAcessoPerfilAcesso.getAssinaturaUsuario() != null) {
            assinaturas.append(usuarioAcessoPerfilAcesso.getAssinaturaUsuario());
        }
    }
}
