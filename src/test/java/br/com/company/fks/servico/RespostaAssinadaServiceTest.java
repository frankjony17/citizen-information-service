package br.com.company.fks.servico;

import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.RespostaAssinadaDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import lombok.SneakyThrows;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RespostaAssinadaServiceTest {
    @InjectMocks
    private RespostaAssinadaService respostaAssinadaService;

    @Mock
    private HistoricoTratamentoService historicoTratamentoService;
    @Mock
    private AndamentoService andamentoService;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private RespostaAssinadaDTO respostaAssinadaDTO;
    @Mock
    private Pedido pedido;
    @Mock
    private StatusSolicitacao statusSolicitacao;
    @Mock
    private StatusTramitacao statusTramitacao;
    @Mock
    private AndamentoRepository andamentoRepository;
    @Mock
    private Andamento andamento;
    @Mock
    private List<Andamento> listaAndamento;

    @Mock
    private Unidade unidade;

    @Mock
    private List<Unidade> unidadeList;

    @Test
    public void enviarTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(any(Pedido.class), anyLong(), anyBoolean());
        respostaAssinadaService.enviar(respostaAssinadaDTO);
    }

    @Test
    public void enviarTestIfRespostaSicTest(){
        when(respostaAssinadaDTO.getIdStatusSolicitacao()).thenReturn(2L);
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(respostaAssinadaDTO.getObservacao()).thenReturn("Teste");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(any(Pedido.class), anyLong(), anyBoolean());
        respostaAssinadaService.enviar(respostaAssinadaDTO);
    }

    @Test
    public void enviarTestIfDistribuicaoPfTest(){
        when(respostaAssinadaDTO.getIdStatusSolicitacao()).thenReturn(6L);
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(respostaAssinadaDTO.getObservacao()).thenReturn("Teste");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(any(Pedido.class), anyLong(), anyBoolean());
        respostaAssinadaService.enviar(respostaAssinadaDTO);
    }

    @Test
    public void enviarTestIfProducaoRespostaTest(){
        when(respostaAssinadaDTO.getIdStatusSolicitacao()).thenReturn(7L);
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(respostaAssinadaDTO.getObservacao()).thenReturn("Teste");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(any(Pedido.class), anyLong(), anyBoolean());
        respostaAssinadaService.enviar(respostaAssinadaDTO);
    }

    @Test
    public void enviarTestIfParaEnvioTest(){
        when(respostaAssinadaDTO.getIdStatusSolicitacao()).thenReturn(5L);
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(respostaAssinadaDTO.getObservacao()).thenReturn("Teste");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(any(Pedido.class), anyLong(), anyBoolean());
        respostaAssinadaService.enviar(respostaAssinadaDTO);
    }

    @Test
    public void salvarTest() {
        when(respostaAssinadaDTO.getIdPedido()).thenReturn(1L);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(respostaAssinadaDTO.getPropostaResposta()).thenReturn("teste");
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        respostaAssinadaService.salvar(respostaAssinadaDTO);
    }

    @Test
    @SneakyThrows
    public void editarRespostaTest() {
        when(respostaAssinadaDTO.getIdPedido()).thenReturn(1L);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        respostaAssinadaService.editarResposta(respostaAssinadaDTO);
    }

    @Test
    public void buscarRespostaTest() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getPropostaResposta()).thenReturn("teste");
        respostaAssinadaService.buscarResposta(1L);
    }

    @Test
    public void buscarDadosEncaminhamento(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        respostaAssinadaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoIf(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        respostaAssinadaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamento2(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(8L);
        respostaAssinadaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamento3(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(4L);
        respostaAssinadaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamento4(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(11L);
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(listaAndamento);
        when(pedido.getId()).thenReturn(1L);
        respostaAssinadaService.buscarDadosEncaminhamento(1L);
    }

}
