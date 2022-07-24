package br.com.company.fks.servico;

import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.dto.RespostaAssinadaDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespostaAssinadaService {

    private static final String RESPOSTA_ASSINADA = "Solicitação encaminhada como resposta assinada";

    @Autowired
    private HistoricoTratamentoService historicoTratamentoService;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AndamentoRepository andamentoRepository;

    private static final String RESPOSTA_ASSINADA_CONST = "Resposta Assinada";
    private static final String PRODUCAO_DE_RESPOSTA = "Produção de Resposta";

    @Transactional
    public void enviar(RespostaAssinadaDTO respostaAssinadaDTO) {
        Pedido pedido = pedidoRepository.findById(respostaAssinadaDTO.getIdPedido());
        if (respostaAssinadaDTO.getObservacao() != null) {
            pedido.setObservacao(respostaAssinadaDTO.getObservacao());
        }

        pedidoIsDevolver(respostaAssinadaDTO, pedido);
        pedidoIsTramitacao(respostaAssinadaDTO, pedido);
    }

    private void pedidoIsTramitacao(RespostaAssinadaDTO respostaAssinadaDTO, Pedido pedido) {

        pedido.setStatusTramitacao(new StatusTramitacao());
        pedido.setStatusSolicitacao(new StatusSolicitacao());
        if (StatusSolicitacao.RESPOSTA_SIC.equals(respostaAssinadaDTO.getIdStatusSolicitacao())) {
            pedido.getStatusTramitacao().setId(StatusTramitacao.RESPONDIDAS);
            pedido.getStatusSolicitacao().setId(StatusSolicitacao.RESPOSTA_SIC);
        } else if (StatusSolicitacao.RESPOSTA_ASSINADA_PF.equals(respostaAssinadaDTO.getIdStatusSolicitacao())) {
            pedido.getStatusSolicitacao().setId(StatusSolicitacao.RESPOSTA_ASSINADA_PF);
            pedido.getStatusTramitacao().setId(StatusTramitacao.ANDAMENTO);
        } else if (StatusSolicitacao.PRODUCAO_RESPOSTA.equals(respostaAssinadaDTO.getIdStatusSolicitacao())) {
            pedido.getStatusTramitacao().setId(StatusTramitacao.ANDAMENTO);
            pedido.getStatusSolicitacao().setId(StatusSolicitacao.PRODUCAO_RESPOSTA);
        } else if (StatusSolicitacao.PARA_ENVIO.equals(respostaAssinadaDTO.getIdStatusSolicitacao())) {
            pedido.getStatusSolicitacao().setId(StatusSolicitacao.PARA_ENVIO);
            pedido.getStatusTramitacao().setId(StatusTramitacao.RESPONDIDAS);
        }

    }

    private void pedidoIsDevolver(RespostaAssinadaDTO respostaAssinadaDTO, Pedido pedido) {

        pedido.setIsDevolver(false);
        pedido.setRespostaEsic(pedido.getRespostaEsic());
        historicoTratamentoService.gerarHistoricoTratamento(pedido, TipoTratamento.RESPOSTA_ASSINADA, false);
        if (StatusSolicitacao.RESPOSTA_ASSINADA_PF.equals(respostaAssinadaDTO.getIdStatusSolicitacao())
                || StatusSolicitacao.PRODUCAO_RESPOSTA.equals(respostaAssinadaDTO.getIdStatusSolicitacao())) {
            pedido.setRespostaEsic(null);
        }

        if (StatusSolicitacao.RESPOSTA_ASSINADA_PF.equals(respostaAssinadaDTO.getIdStatusSolicitacao())
                || StatusSolicitacao.RESPOSTA_SIC.equals(respostaAssinadaDTO.getIdStatusSolicitacao())
                || StatusSolicitacao.PARA_ENVIO.equals(respostaAssinadaDTO.getIdStatusSolicitacao())
                || StatusSolicitacao.PRODUCAO_RESPOSTA.equals(respostaAssinadaDTO.getIdStatusSolicitacao())) {
            andamentoService.reverterAndamento(pedido, RESPOSTA_ASSINADA, respostaAssinadaDTO);
        } else {
            andamentoService.gerarAndamentoSolicitacao(pedido, false, RESPOSTA_ASSINADA);
        }
    }

    @Transactional
    public void salvar(RespostaAssinadaDTO respostaAssinadaDTO) {
        Pedido pedido = pedidoRepository.findById(respostaAssinadaDTO.getIdPedido());
        pedido.setPropostaResposta(respostaAssinadaDTO.getPropostaResposta());
        pedidoRepository.save(pedido);
    }

    public void editarResposta(RespostaAssinadaDTO respostaAssinadaDTO) throws IntegracaoException {
        Pedido pedido = pedidoRepository.findById(respostaAssinadaDTO.getIdPedido());
        pedidoRepository.save(pedido);
    }


    public RespostaDTO buscarResposta(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setResposta(pedido.getPropostaResposta());
        return respostaDTO;
    }

    public RespostaAssinadaDTO buscarDadosEncaminhamento(Long idPedido) {
        RespostaAssinadaDTO respostaAssinadaDTO = new RespostaAssinadaDTO();
        Pedido pedido = pedidoRepository.buscarPedidoEStatusSolicitacao(idPedido);
        StatusSolicitacao statusSolicitacao = pedido.getStatusSolicitacao();
        respostaAssinadaDTO.setPropostaResposta(pedido.getPropostaResposta());
        respostaAssinadaDTO.setNomeStatusSolicitacaoPedido(pedido.getStatusSolicitacao().getNome());

        respostaAssinadaDTO = validaDadosEncaminhamento(statusSolicitacao, respostaAssinadaDTO,pedido);

        return respostaAssinadaDTO;
    }

    private RespostaAssinadaDTO validaDadosEncaminhamento(StatusSolicitacao statusSolicitacao, RespostaAssinadaDTO respostaAssinadaDTO,Pedido pedido) {
        if (statusSolicitacao.getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            respostaAssinadaDTO.setNomeStatusSolicitacao(RESPOSTA_ASSINADA_CONST);
            respostaAssinadaDTO.setIdStatusSolicitacao(6L);
        } else if (statusSolicitacao.getId().equals(StatusSolicitacao.EDICAO_TECNICO)) {
            respostaAssinadaDTO.setNomeStatusSolicitacao(PRODUCAO_DE_RESPOSTA);
            respostaAssinadaDTO.setIdStatusSolicitacao(7L);
        } else if (statusSolicitacao.getId().equals(StatusSolicitacao.REVISAO)) {
            respostaAssinadaDTO.setNomeStatusSolicitacao("Para Envio");
            respostaAssinadaDTO.setIdStatusSolicitacao(5L);
        } else if (statusSolicitacao.getId().equals(StatusSolicitacao.SUGESTAO_DE_REENCAMINHAMENTO)) {
            return defineStatusSolicitacaoQuandoSugestaoDeReencaminhamento(pedido);
        } else {
            respostaAssinadaDTO.setNomeStatusSolicitacao("Resposta SIC");
            respostaAssinadaDTO.setIdStatusSolicitacao(2L);
        }
        return respostaAssinadaDTO;
    }

    private RespostaAssinadaDTO defineStatusSolicitacaoQuandoSugestaoDeReencaminhamento(Pedido pedido) {
        RespostaAssinadaDTO respostaAssinadaDTO = new RespostaAssinadaDTO();
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        Andamento andamento = listaAndamento.get(0);
        andamantoIsEmpty(respostaAssinadaDTO,andamento);
        return respostaAssinadaDTO;
    }

    private void andamantoIsEmpty(RespostaAssinadaDTO respostaAssinadaDTO, Andamento andamento) {
        if (!andamento.getListaUnidade().isEmpty()) {
            if (andamento.getListaUnidade().get(0).getId() == 1L || andamento.getListaUnidade().get(0).getId() != 1L) {
                respostaAssinadaDTO.setNomeStatusSolicitacao("Resposta SIC");
                respostaAssinadaDTO.setIdStatusSolicitacao(StatusSolicitacao.RESPOSTA_SIC);
                respostaAssinadaDTO.setNomeStatusSolicitacaoPedido("Triagem SIC");
            }
        } else if (!andamento.getUsuarioAcessos().isEmpty()) {
            if (andamento.getUsuarioAcessos().get(0).getPerfilUsuario().equals("FKS.RESPONDENTE")) {
                respostaAssinadaDTO.setNomeStatusSolicitacao(RESPOSTA_ASSINADA_CONST);
                respostaAssinadaDTO.setIdStatusSolicitacao(StatusSolicitacao.RESPOSTA_ASSINADA_PF);
                respostaAssinadaDTO.setNomeStatusSolicitacaoPedido(RESPOSTA_ASSINADA_CONST);
            } else if (andamento.getUsuarioAcessos().get(0).getPerfilUsuario().equals("FKS.TECNICO")) {
                respostaAssinadaDTO.setNomeStatusSolicitacao(PRODUCAO_DE_RESPOSTA);
                respostaAssinadaDTO.setIdStatusSolicitacao(StatusSolicitacao.PRODUCAO_RESPOSTA);
                respostaAssinadaDTO.setNomeStatusSolicitacaoPedido(PRODUCAO_DE_RESPOSTA);
            }
        }
    }
}
