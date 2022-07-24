package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.ConsultaPedidoDTO;
import br.com.company.fks.modelo.dto.DevolvePedidoDTO;
import br.com.company.fks.modelo.dto.DevolveStatusSolicitacaoDTO;
import br.com.company.fks.servico.PedidoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DevolvePedidoControllerTest {
    @InjectMocks
    private DevolvePedidoController devolvePedidoController;
    @Mock
    private PedidoService pedidoService;
    @Mock
    private ConsultaPedidoDTO consultaPedidoDTO;
    @Mock
    private DevolvePedidoDTO devolvePedidoDTO;
    @Mock
    private DevolveStatusSolicitacaoDTO devolveStatusSolicitacaoDTO;

    @Test
    public void devolverTest() throws IntegracaoException {
        Mockito.doNothing().when(pedidoService).reverterAndamentoPedido(any(DevolvePedidoDTO.class));
        devolvePedidoController.devolver(devolvePedidoDTO);
    }

    @Test
    public void devolverTestCatch() throws IntegracaoException {
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).reverterAndamentoPedido(any(DevolvePedidoDTO.class));
        devolvePedidoController.devolver(devolvePedidoDTO);
    }

    @Test
    public void consultarStatusRecurso() {
        when(pedidoService.consultarStatusRecurso(anyLong())).thenReturn(devolvePedidoDTO);
        devolvePedidoController.consultarStatusRecurso(anyLong());
    }

}
