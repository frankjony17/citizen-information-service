package br.com.company.fks.servico;

import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.ConsultaHistoricoPedidoDTO;
import br.com.company.fks.repositorio.HistoricoTratamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HistoricoTratamentoServiceTest {

    @InjectMocks
    private HistoricoTratamentoService historicoTratamentoService;

    @Mock
    private HistoricoTratamentoRepository historicoTratamentoRepository;

    @Mock
    private PedidoService pedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private Pedido pedido;

    @Mock
    private HistoricoTratamento historicoTratamento;

    @Mock
    private Page<ConsultaHistoricoPedidoDTO> consultaHistoricoPedidoDTOPage;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private ConsultaHistoricoPedidoDTO consultaHistoricoPedidoDTO;

    @Test
    public void gerarHistoricoTratamentoTest(){
        when(usuarioLogadoUtil.getNome()).thenReturn("usuarioLogadoUtil");
        historicoTratamentoService.gerarHistoricoTratamento(pedido, 1L, true);
    }

    @Test
    public void recuperarRespostaPedidoTest(){
        List<HistoricoTratamento> listaHistoricoTratamento = new ArrayList<>();
        listaHistoricoTratamento.add(historicoTratamento);
        when(historicoTratamentoRepository.recuperarHistoricoPorIdPedido(anyLong())).thenReturn(listaHistoricoTratamento);
        historicoTratamentoService.recuperarRespostaPedido(1L);
    }

    @Test
    public void recuperarRespostaPedidoTestListaNull(){
        List<HistoricoTratamento> listaHistoricoTratamento = new ArrayList<>();
        when(historicoTratamentoRepository.recuperarHistoricoPorIdPedido(anyLong())).thenReturn(listaHistoricoTratamento);
        historicoTratamentoService.recuperarRespostaPedido(1L);
    }

    @Test
    public void recuperarRespostaPedidoPerfilNull() {
        historicoTratamentoService.recuperarRespostaPedidoPerfil(1L);
    }

    @Test
    public void recuperarRespostaPedidoPerfil(){
        when(usuarioLogadoUtil.getNome()).thenReturn("usuarioLogadoUtil");
        List<HistoricoTratamento> historicoTratamentoList = new ArrayList<>();
        historicoTratamentoList.add(historicoTratamento);
        when(historicoTratamentoRepository.recuperarHistoricoPorIdPedido(1L)).thenReturn(historicoTratamentoList);
        List<ConsultaHistoricoPedidoDTO> consultaHistoricoPedidoDTOList = new ArrayList<>();
        consultaHistoricoPedidoDTOList.add(consultaHistoricoPedidoDTO);
        when(pedidoService.montarListaConsultaPedidoDTOPorHistorico(historicoTratamentoList)).thenReturn(consultaHistoricoPedidoDTOList);
        when(consultaHistoricoPedidoDTO.getNomeResponsavel()).thenReturn("perfil");
        when(consultaHistoricoPedidoDTO.getResposta()).thenReturn("resposta");
        historicoTratamentoService.recuperarRespostaPedidoPerfil(1L);
    }

    @Test
    public void consultarHistoricoPedidoTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(historicoTratamentoRepository.recuperarHistoricoPedido(any(Pedido.class), any(Pageable.class))).thenReturn(consultaHistoricoPedidoDTOPage);
        assertEquals(historicoTratamentoService.consultarHistoricoPedido(1L, 1, 1), consultaHistoricoPedidoDTOPage);
    }

    @Test
    public void buscarRespostaHistoricoTest(){
        when(historicoTratamentoRepository.findOne(anyLong())).thenReturn(historicoTratamento);
        historicoTratamentoService.buscarRespostaHistorico(1L);
    }

    @Test
    public void recuperarHistoricos() {
        List<HistoricoTratamento> list = new ArrayList<>();
        when(historicoTratamentoRepository.recuperarHistoricos(anyLong())).thenReturn(list);
        List<HistoricoTratamento> result = historicoTratamentoService.recuperarHistoricos(1L);
        Assert.assertTrue(result.isEmpty());
    }

}
