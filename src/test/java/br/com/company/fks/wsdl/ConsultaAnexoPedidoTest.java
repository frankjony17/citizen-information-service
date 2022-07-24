package br.com.company.fks.wsdl;

import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ResponseObterPedidoAnexo;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoLocator;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoSoap_BindingStub;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
public class ConsultaAnexoPedidoTest {



    @InjectMocks
    private ConsultaAnexoPedido consultaAnexoPedido;

    @Mock
    private ServicoConsultaPedidoLocator servicoConsultaPedidoLocator;

    @Mock
    private ServicoConsultaPedidoSoap_BindingStub cliente;

    @Mock
    private ResponseObterPedidoAnexo responseObterPedidoAnexo;

    @Mock
    private ResponseArquivo responseArquivo;

    @Mock
    private AnexoUtils anexoUtils;


    @Test
    @Ignore
    public void consultaPedidoTest() throws Exception {
        ResponseArquivo[] mockResponseAqruivos = mockArrayResponseArquivos();

        whenNew(ServicoConsultaPedidoLocator.class).withNoArguments().thenReturn(servicoConsultaPedidoLocator);
        when(servicoConsultaPedidoLocator.getServicoConsultaPedidoSoap()).thenReturn(cliente);
        when(cliente.obterAnexosPedidos(any(), any(), any())).thenReturn(responseObterPedidoAnexo);
        when(responseObterPedidoAnexo.getArquivos()).thenReturn(mockResponseAqruivos);
        when(responseArquivo.getArquivoZipAndBase64()).thenReturn("");
        doNothing().when(anexoUtils).dezipaSalva(any(), any(), any());

        ResponseArquivo[] resultado = consultaAnexoPedido.consultaAnexosPedido("");

        assertTrue(resultado.equals(mockResponseAqruivos));
    }

    @Test(expected = Exception.class)
    public void consultaPedidoLancaException() throws Exception {
        ResponseArquivo[] mockResponseAqruivos = mockArrayResponseArquivos();

        whenNew(ServicoConsultaPedidoLocator.class).withNoArguments().thenReturn(servicoConsultaPedidoLocator);
        when(servicoConsultaPedidoLocator.getServicoConsultaPedidoSoap()).thenReturn(cliente);
        when(cliente.obterAnexosPedidos(any(), any(), any())).thenReturn(responseObterPedidoAnexo);
        when(responseObterPedidoAnexo.getArquivos()).thenReturn(mockResponseAqruivos);

        ResponseArquivo[] resultado = consultaAnexoPedido.consultaAnexosPedido("");
    }

    private ResponseArquivo[] mockArrayResponseArquivos() {
        ResponseArquivo[] responseArquivosArray = new ResponseArquivo[1];
        responseArquivosArray[0] = responseArquivo;
        return responseArquivosArray;
    }




}
