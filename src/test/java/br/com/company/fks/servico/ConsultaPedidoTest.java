package br.com.company.fks.servico;

import br.gov.cgu.esic.pedido.RequestObterPedido;
import br.gov.cgu.esic.pedido.ResponseObterPedido;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoLocator;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoSoap_BindingStub;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoSoap_PortType;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.util.Calendar;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 04/09/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Calendar.class, Logger.class})
public class ConsultaPedidoTest {
    @InjectMocks
    private ConsultaPedido consultaPedido;

    @Mock
    private Calendar calendar;

    @Mock
    private ServicoConsultaPedidoLocator servicoConsultaPedidoLocator;

    @Mock
    private ServicoConsultaPedidoSoap_PortType servicoConsultaPedidoSoap_portType;

    @Mock
    private RequestObterPedido requestObterPedido;

    @Mock
    private ServicoConsultaPedidoSoap_BindingStub servicoConsultaPedidoSoap_bindingStub;

    @Mock
    private ResponseObterPedido responseObterPedido;

    @Mock
    private Logger logger;

    @Test
    @SneakyThrows
    public void consultaPedido() {
        ResponsePedido[] pedidos = new ResponsePedido[0];
        PowerMockito.mockStatic(Calendar.class);
        when(calendar.getInstance()).thenReturn(calendar);
        when(servicoConsultaPedidoLocator.getServicoConsultaPedidoSoap()).thenReturn(servicoConsultaPedidoSoap_portType);
        when(servicoConsultaPedidoSoap_bindingStub.obterPedidos(requestObterPedido)).thenReturn(responseObterPedido);
        when(responseObterPedido.getPedidos()).thenReturn(pedidos);
        consultaPedido.consultaPedido(true);
    }
    @Test
    @SneakyThrows
    public void consultaPedidoRemoteException() {
        PowerMockito.mockStatic(Logger.class);
        when(logger.getLogger(ConsultaPedido.class)).thenReturn(logger);
        ResponsePedido[] pedidos = new ResponsePedido[0];
        PowerMockito.mockStatic(Calendar.class);
        when(calendar.getInstance()).thenReturn(calendar);
        when(servicoConsultaPedidoLocator.getServicoConsultaPedidoSoap()).thenReturn(servicoConsultaPedidoSoap_portType);
        Mockito.doThrow(RemoteException.class).when(servicoConsultaPedidoSoap_bindingStub).obterPedidos(null);
        when(responseObterPedido.getPedidos()).thenReturn(pedidos);
        consultaPedido.consultaPedido(false);
    }
}