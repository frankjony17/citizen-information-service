package br.com.company.fks.rotina;

import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.com.company.fks.servico.ImportacaoRecursoService;
import br.com.company.fks.wsdl.ConsultaAnexoPedido;
import br.com.company.fks.servico.ConsultaPedido;
import br.com.company.fks.servico.ImportacaoPedidoService;
import br.gov.cgu.esic.recurso.ResponseRecurso;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by christian-tavares on 20/03/18.
 */
@RunWith(PowerMockRunner.class)
public class PedidoCargaRotinaAgendadaTest {

    @InjectMocks
    private PedidoCargaRotinaAgendada pedidoCargaRotinaAgendada;

    @Mock
    private ConsultaPedido consultaPedido;

    @Mock
    private ConsultaAnexoPedido consultaAnexoPedidoPedido;

    @Mock
    private ImportacaoPedidoService importacaoPedidoService;

    @Mock
    private ImportacaoRecursoService importacaoRecursoService;

    @Mock
    private ResponseRecurso responseRecurso;


    @Test
    public void verificaACadaTrintaMinutosTest() throws IOException, ServiceException {
        when(consultaPedido.consultaPedido(true)).thenReturn(mockArrayResponsePedidos());
        when(consultaAnexoPedidoPedido.consultaAnexosPedido(anyString())).thenReturn(mockArrayResponseArquivos());
        doNothing().when(importacaoPedidoService).sincronizarBaseDeDadosPedidos(any(ResponsePedido.class), any(ResponseArquivo[].class));

        pedidoCargaRotinaAgendada.verificaACadaTrintaMinutos();

        Mockito.doNothing().when(importacaoRecursoService).sincronizarBaseDeDadosRecursos(any(ResponseRecurso.class));

        verify(importacaoPedidoService).sincronizarBaseDeDadosPedidos(any(ResponsePedido.class), any(ResponseArquivo[].class));
    }

    @Test
    public void verificaACadaTrintaMinutosTestSemfor() throws IOException, ServiceException {
        when(consultaPedido.consultaPedido(anyBoolean())).thenReturn(new ResponsePedido[0]);
        pedidoCargaRotinaAgendada.verificaACadaTrintaMinutos();

        verify(importacaoPedidoService, times(0)).sincronizarBaseDeDadosPedidos(any(ResponsePedido.class), any(ResponseArquivo[].class));
    }
    @Test
    public void verificaDiariamenteMeiaNoiteTest() throws IOException, ServiceException {
        when(consultaPedido.consultaPedido(false)).thenReturn(mockArrayResponsePedidos());
        when(consultaAnexoPedidoPedido.consultaAnexosPedido(anyString())).thenReturn(mockArrayResponseArquivos());
        Mockito.doNothing().when(importacaoPedidoService).sincronizarBaseDeDadosPedidos(any(ResponsePedido.class), any(ResponseArquivo[].class));

        pedidoCargaRotinaAgendada.verificaDiariamenteMeiaNoite();

        verify(importacaoPedidoService).sincronizarBaseDeDadosPedidos(any(ResponsePedido.class), any(ResponseArquivo[].class));
    }

    @Test
    public void verificaDiariamenteMeiaNoiteTestSemFor() throws IOException, ServiceException {
        when(consultaPedido.consultaPedido(anyBoolean())).thenReturn(new ResponsePedido[0]);
        pedidoCargaRotinaAgendada.verificaDiariamenteMeiaNoite();

        verify(importacaoPedidoService, times(0)).sincronizarBaseDeDadosPedidos(any(ResponsePedido.class), any(ResponseArquivo[].class));
    }

    private ResponsePedido[] mockArrayResponsePedidos() {
        ResponsePedido responsePedido = mock(ResponsePedido.class);
        ResponsePedido[] responsePedidosArray = new ResponsePedido[1];
        responsePedidosArray[0] = responsePedido;
        return responsePedidosArray;
    }

    private ResponseArquivo[] mockArrayResponseArquivos() {
        ResponseArquivo responseArquivo = mock(ResponseArquivo.class);
        ResponseArquivo[] responseArquivosArray = new ResponseArquivo[1];
        responseArquivosArray[0] = responseArquivo;
        return responseArquivosArray;
    }




}
