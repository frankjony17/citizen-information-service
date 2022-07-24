package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.servico.PedidoDuplicadoService;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class PedidoDuplicadoControllerTest {

    @InjectMocks
    private PedidoDuplicadoController controller;

    @Mock
    private PedidoDuplicadoService pedidoDuplicadoService;

    @Test
    public void buscarPedidoPeloProtocolo() {
        Assert.assertNotNull(controller.buscarPedidoPeloProtocolo("123"));
    }

    @Test
    public void vincularPedidoDuplicado() {
        Assert.assertNotNull(controller.vincularPedidoDuplicado(1L, 2L));
    }

    @Test
    @SneakyThrows
    public void vincularPedidoDuplicadoIntegracaoException() {
        when(pedidoDuplicadoService.vincularPedidoDuplicado(1L, 2L)).thenThrow(IntegracaoException.class);
        controller.vincularPedidoDuplicado(1L, 2L);
    }

    @Test
    public void buscarPedidoPeloIdProtocolo() {
        Assert.assertNotNull(controller.buscarPedidoPeloProtocolo(1L));
    }

    @Test
    public void buscarProtocoloPedidoPai() {
        Assert.assertNotNull(controller.buscarProtocoloPedidoPai(1L));
    }
}
