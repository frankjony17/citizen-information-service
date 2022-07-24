package br.com.company.fks.servico;

import br.com.company.fks.modelo.*;
import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.gov.cgu.esic.pedido.ResponseSolicitante;
import br.gov.mpog.fks.modelo.*;
import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.SolicitanteRepository;
import br.com.company.fks.wsdl.AnexoUtils;
import br.com.company.fks.utils.DataUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doNothing;

/**
 * Created by christian-tavares on 20/03/18.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(DataUtil.class)
public class ImportacaoPedidoServiceTest {

    @InjectMocks
    private ImportacaoPedidoService importacaoPedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private SolicitanteRepository solicitanteRepository;

    @Mock
    private ResponsePedido responsePedido;

    @Mock
    private Pedido pedido;
    @Mock
    private AndamentoService andamentoService;
    @Mock
    private Solicitante solicitante;
    @Mock
    private StatusTramitacao statusTramitacao;
    @Mock
    private StatusSolicitacao statusSolicitacao;
    @Mock
    private SituacaoPedido situacaoPedido;
    @Mock
    private List<Calendar> calendarList;
    @Mock
    private List<Feriado> feriadoList;
    @Mock
    private FeriadoRepository feriadoRepository;
    @Mock
    private Feriado feriado;
    @Mock
    private ResponseSolicitante responseSolicitante;

    @Mock
    private ResponseArquivo responseArquivo;

    @Mock
    private AnexoUtils anexoUtils;



    @Test
    public void sincronizarBaseDeDadosPedidosComPedidoNulo() throws Exception {
        when(pedidoRepository.recuperarPedidoPeloProtocolo(anyString())).thenReturn(null);
        when(responsePedido.getSituacao()).thenReturn("Em Tramitação");
        PowerMockito.mockStatic(DataUtil.class);
        when(DataUtil.isDiaUtil(any(Calendar.class),anyList())).thenReturn(false);
        when(responsePedido.getSolicitante()).thenReturn(responseSolicitante);
        when(solicitanteRepository.save(any(Solicitante.class))).thenReturn(solicitante);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        when(responseArquivo.getArquivoZipAndBase64()).thenReturn("");
        doNothing().when(anexoUtils).dezipaSalva(any(), any(), any());
        when(anexoUtils.getFile(anyString(), anyString())).thenReturn(mock(File.class));

        importacaoPedidoService.sincronizarBaseDeDadosPedidos(responsePedido, mockArrayResponseArquivos());


    }

    @Test
    public void sincronizarBaseDeDadosPedidosComPedidoNulo2() throws Exception {
        when(pedidoRepository.recuperarPedidoPeloProtocolo(anyString())).thenReturn(null);
        when(responsePedido.getSituacao()).thenReturn("Em Tramitação");
        PowerMockito.mockStatic(DataUtil.class);
        when(DataUtil.isDiaUtil(any(Calendar.class),anyList())).thenReturn(false);
        when(responsePedido.getSolicitante()).thenReturn(responseSolicitante);
        when(solicitanteRepository.save(any(Solicitante.class))).thenReturn(solicitante);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        when(responseArquivo.getArquivoZipAndBase64()).thenReturn("");
        doNothing().when(anexoUtils).dezipaSalva(any(), any(), any());
        when(anexoUtils.getFile(anyString(), anyString())).thenReturn(mock(File.class));

        when(solicitanteRepository.findByCpfOuCnpj("00000000000")).thenReturn(solicitante);
        when(responseSolicitante.getCPFouCNPJ()).thenReturn("00000000000");

        importacaoPedidoService.sincronizarBaseDeDadosPedidos(responsePedido, mockArrayResponseArquivos());


    }

    @Test
    public void sincronizarBaseDeDadosPedidosComPedidoNulo3() throws Exception {
        List<Feriado> listaFeriado = new ArrayList<>();
        listaFeriado.add(feriado);
        when(feriadoRepository.findAll()).thenReturn(listaFeriado);
        when(pedidoRepository.recuperarPedidoPeloProtocolo(anyString())).thenReturn(null);
        when(responsePedido.getSituacao()).thenReturn("Respondido");
        PowerMockito.mockStatic(DataUtil.class);
        when(DataUtil.isDiaUtil(any(Calendar.class),anyList())).thenReturn(false);
        when(responsePedido.getSolicitante()).thenReturn(responseSolicitante);
        when(solicitanteRepository.save(any(Solicitante.class))).thenReturn(solicitante);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        when(responseArquivo.getArquivoZipAndBase64()).thenReturn("");
        doNothing().when(anexoUtils).dezipaSalva(any(), any(), any());
        when(anexoUtils.getFile(anyString(), anyString())).thenReturn(mock(File.class));

        when(solicitanteRepository.findByCpfOuCnpj("00000000000")).thenReturn(solicitante);
        when(responseSolicitante.getCPFouCNPJ()).thenReturn("00000000000");

        importacaoPedidoService.sincronizarBaseDeDadosPedidos(responsePedido, mockArrayResponseArquivos());


    }

    @Test
    public void sincronizarBaseDeDadosPedidosComPedidoNaoNulo() throws IOException {
        when(pedidoRepository.recuperarPedidoPeloProtocolo(any(String.class))).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(new Solicitante());
        when(responsePedido.getSolicitante()).thenReturn(new ResponseSolicitante());

        when(responseArquivo.getArquivoZipAndBase64()).thenReturn("");
        doNothing().when(anexoUtils).dezipaSalva(any(), any(), any());
        when(anexoUtils.getFile(anyString(), anyString())).thenReturn(mock(File.class));

        importacaoPedidoService.sincronizarBaseDeDadosPedidos(responsePedido, mockArrayResponseArquivos());
    }

    private ResponseArquivo[] mockArrayResponseArquivos() {
        ResponseArquivo[] responseArquivosArray = new ResponseArquivo[1];
        responseArquivosArray[0] = responseArquivo;
        return responseArquivosArray;
    }
}
