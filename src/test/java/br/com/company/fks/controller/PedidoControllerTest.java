package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.AlteracaoPedidoRecursoDTO;
import br.com.company.fks.modelo.dto.AndamentoPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaHistoricoPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaPedidoDTO;
import br.com.company.fks.modelo.dto.FiltroPedidoDTO;
import br.com.company.fks.modelo.dto.PedidoDetalhadoDTO;
import br.com.company.fks.modelo.dto.PedidoTemaDTO;
import br.com.company.fks.modelo.dto.RespostaPedidoDTO;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.custom.ArmazenamentoArquivoCustomRepositorio;
import br.com.company.fks.servico.AndamentoService;
import br.com.company.fks.servico.HistoricoTratamentoService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.wsdl.AnexoUtils;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class,Files.class})
public class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private PedidoService pedidoService;
    @Mock
    private FiltroPedidoDTO filtroPedidoDTO;
    @Mock
    private PedidoDetalhadoDTO pedidoDetalhadoDTO;
    @Mock
    private Page<AndamentoPedidoDTO> andamentoPedidoDTOPage;
    @Mock
    private AndamentoService andamentoService;
    @Mock
    private HistoricoTratamentoService historicoTratamentoService;
    @Mock
    private  Page<ConsultaHistoricoPedidoDTO> consultaHistoricoPedidoDTOPage;
    @Mock
    private AnexoUtils anexoUtils;
    @Mock
    private File file;
    @Mock
    private Path path1;
    @Mock
    private RespostaPedidoDTO respostaPedidoDTO;
    @Mock
    private Pedido pedido;
    @Mock
    private PedidoTemaDTO pedidoTemaDTO;
    @Mock
    private RecursoRepository recursoRepository;
    @Mock
    private ArmazenamentoArquivoCustomRepositorio armazenamento;
    @Mock
    private List<ConsultaPedidoDTO> consultaPedidoDTOS;

    @Test
    @SneakyThrows
    public void lançamentoErrorConsultarPedidoTest_1() {

        when(pedidoService.consultarPedido(any(FiltroPedidoDTO.class))).thenThrow(IntegracaoException.class);
        ResponseEntity<Resposta<List<ConsultaPedidoDTO>>> retorno = pedidoController.consultarPedido("{}");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, retorno.getStatusCode());
    }

    @Test
    @SneakyThrows
    public void lançamentoErrorConsultarPedidoTest_2(){
        when(pedidoService.consultarPedido(any(FiltroPedidoDTO.class))).thenThrow(ObjectMapperException.class);
        ResponseEntity<Resposta<List<ConsultaPedidoDTO>>> retorno = pedidoController.consultarPedido("{}");
        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());

    }

    @Test
    public void exportarConsultaPedidoTest() throws IntegracaoException, ObjectMapperException, IOException {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(ControllerUtil.montarFiltroDTO("filtro",FiltroPedidoDTO.class)).thenReturn(filtroPedidoDTO);
        when(pedidoService.exportarConsultaPedido(any(FiltroPedidoDTO.class))).thenReturn(new byte[10]);
        pedidoController.exportarConsultaPedido("filtro");
    }

    @Test
    public void exportarConsultaPedidoTest_2() throws ObjectMapperException, IntegracaoException, IOException {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(ControllerUtil.montarFiltroDTO("filtro",FiltroPedidoDTO.class)).thenReturn(filtroPedidoDTO);
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).exportarConsultaPedido(any(FiltroPedidoDTO.class));
        pedidoController.exportarConsultaPedido("filtro");
    }

    @Test
    public void exportarConsultaPedidoTest_3() throws ObjectMapperException, IntegracaoException, IOException {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(ControllerUtil.montarFiltroDTO("filtro",FiltroPedidoDTO.class)).thenReturn(filtroPedidoDTO);
        Mockito.doThrow(ObjectMapperException.class).when(pedidoService).exportarConsultaPedido(any(FiltroPedidoDTO.class));
        pedidoController.exportarConsultaPedido("filtro");
    }
    @Test
    public void exportarConsultaPedidoTest_4() throws ObjectMapperException, IntegracaoException, IOException {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(ControllerUtil.montarFiltroDTO("filtro",FiltroPedidoDTO.class)).thenReturn(filtroPedidoDTO);
        Mockito.doThrow(IOException.class).when(pedidoService).exportarConsultaPedido(any(FiltroPedidoDTO.class));
        pedidoController.exportarConsultaPedido("filtro");
    }

    @Test
    public void detalharPedidoTest(){
        when(pedidoService.detalharPedido(anyLong())).thenReturn(pedidoDetalhadoDTO);
        pedidoController.detalharPedido(5L);

    }

    @Test
    public void enviarPedidoRevisaoTest() throws IntegracaoException {
        Mockito.doNothing().when(pedidoService).enviarPedidoRevisao(anyLong());
        pedidoController.enviarPedidoRevisao(6L);
    }

    @Test
    public void enviarPedidoRevisaoTest_2() throws IntegracaoException {
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).enviarPedidoRevisao(anyLong());
        pedidoController.enviarPedidoRevisao(6L);
    }

    @Test
    public void  consultarAndamentoPedidoTest(){
        when(andamentoService.consultarAndamentoPedido(anyLong(),anyInt(),anyInt())).thenReturn(andamentoPedidoDTOPage);
        pedidoController.consultarAndamentoPedido(5L,4,3);
    }
    @Test
    public void consultarHistoricoPedidoTest(){
        when(historicoTratamentoService.consultarHistoricoPedido(anyLong(),anyInt(),anyInt())).thenReturn(consultaHistoricoPedidoDTOPage);
        pedidoController.consultarHistoricoPedido(5L,4,2);
    }

    @Test
    @SneakyThrows
    public void downloadAnexoTest(){
        byte[] bytes = new byte[0x7ffff];
        File file2 = new File("/home/");
        when(anexoUtils.getFile("protocolo","nome")).thenReturn(file2);
        when(file.toPath()).thenReturn(path1);
        PowerMockito.mockStatic(Files.class);
        Files filesmock = PowerMockito.mock(Files.class);
        Mockito.when(filesmock.readAllBytes(Matchers.any(Path.class))).thenReturn(bytes);
        filesmock.readAllBytes(Mockito.mock(Path.class));
        pedidoController.downloadAnexo("protocolo","nome");
    }

    @Test
    @SneakyThrows
    public void salvarRespostaTestTry(){
        Mockito.doNothing().when(pedidoService).salvarResposta(respostaPedidoDTO);
        pedidoController.salvarResposta(respostaPedidoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarRespostaTestCatch(){
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).salvarResposta(respostaPedidoDTO);
        pedidoController.salvarResposta(respostaPedidoDTO);
    }

    @Test
    @SneakyThrows
    public void cancelarRespostaTestTry(){
        Mockito.doNothing().when(pedidoService).cancelarResposta(anyLong());
        pedidoController.cancelarResposta(1L);
    }

    @Test
    @SneakyThrows
    public void cancelarRespostaTestCatch(){
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).cancelarResposta(anyLong());
        pedidoController.cancelarResposta(1L);

    }

    @Test
    @SneakyThrows
    public void buscarRespostaPedidoTest(){
        when(pedidoService.buscarRespostaPedido(anyLong())).thenReturn(pedido);
        pedidoController.buscarRespostaPedido(1L);
    }

    @Test
    @SneakyThrows
    public void entregarRespostaTestTry(){
        when(pedidoService.entregarResposta(anyLong())).thenReturn(pedido);
        pedidoController.entregarResposta(1L);
    }

    @Test
    @SneakyThrows
    public void entregarRespostaTestCatch(){
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).entregarResposta(anyLong());
        pedidoController.entregarResposta(1L);
    }

    @Test
    public void associarPedidoTema(){
        Mockito.doNothing().when(pedidoService).associarPedidoTema(pedidoTemaDTO);
        pedidoController.associarPedidoTema(pedidoTemaDTO);
    }

    @Test
    public void consultarStatusRespostaAssinada(){
        when(pedidoService.consultarStatusRespostaAssinada(anyLong())).thenReturn(true);
        pedidoController.consultarStatusRespostaAssinada(anyLong());
    }

    @Test
    public void verificaTema() {
        when(pedidoService.verificaTema(1L)).thenReturn(true);
        assertTrue(pedidoController.verificaTema(1L).getBody());
    }

    @Test
    public void buscarStratusSolicitacao(){
        assertNotNull(pedidoController.buscarStratusSolicitacao(1L));
    }

    @Test
    public void buscarPeloProtocoloRecurso(){
        List<Recurso> recursoList = Collections.emptyList();
        when(recursoRepository.buscarProtocoloPedido(anyString())).thenReturn(recursoList);
        assertNotNull(pedidoController.buscarPeloProtocolo("pedido"));
    }

    @Test
    public void buscarPeloProtocolo(){
        Recurso recurso = new Recurso();
        recurso.setId(1L);
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(recursoRepository.buscarProtocoloPedido(anyString())).thenReturn(recursoList);
        assertNotNull(pedidoController.buscarPeloProtocolo("pedido"));
    }

    @Test
    public void buscarStatusSolicitacaoPedido(){
        assertNotNull(pedidoController.buscarStatusSolicitacaoPedido("status"));
    }

    @Test
    public void buscarStatusSolicitacaoRecurso(){
        assertNotNull(pedidoController.buscarStatusSolicitacaoRecurso("status",1L));
    }

    @Test
    public void consultarPedidoSolicitante(){
        assertNotNull(pedidoController.consultarPedidoSolicitante(1L, 0,10));
    }

    @Test
    public void alterarPedidoRecurso() {
        assertNotNull(pedidoController.alterarPedidoRecurso(new AlteracaoPedidoRecursoDTO()));
    }

    @Test
    public void buscarTodosTemasSubtemasPalavraChavePedido() {
        assertNotNull(pedidoController.buscarTodosTemasSubtemasPalavraChavePedido(1L));
    }

    @Test
    public void buscarUltimaUnidade() {
        assertNotNull(pedidoController.buscarUltimaUnidade(1L));
    }

    @Test
    public void alterarVencimentoEouv() {
        assertNotNull(pedidoController.alterarVencimentoEouv(consultaPedidoDTOS));
    }


}
