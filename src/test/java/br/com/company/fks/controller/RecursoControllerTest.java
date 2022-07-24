package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.dto.ConsultaRecursoDTO;
import br.com.company.fks.modelo.dto.FiltroRecursoDTO;
import br.com.company.fks.modelo.dto.RecursoDetalhadoDTO;
import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.servico.RecursoService;
import br.com.company.fks.utils.ControllerUtil;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class})
public class RecursoControllerTest {
    @InjectMocks
    private RecursoController recursoController;
    @Mock
    private RecursoService recursoService;
    @Mock
    private RecursoDetalhadoDTO recursoDetalhadoDTO;
    @Mock
    private StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO;
    @Mock
    private FiltroRecursoDTO filtroRecursoDTO;
    @Mock
    private Resposta<List<ConsultaRecursoDTO>> listResposta;
    @Mock
    private ControllerUtil controllerUtil;

    @Test
    public void detalharRecurso() {
        when(recursoService.detalharRecurso(anyLong(),anyString())).thenReturn(recursoDetalhadoDTO);
        recursoController.detalharRecurso(1L,"teste");
    }

    @Test
    public void buscarStratusSolicitacao() {
        when(recursoService.buscarStatusSolicitacaoRecurso(anyLong())).thenReturn(statusSolicitacaoRecursoDTO);
        recursoController.buscarStratusSolicitacao(1L);
    }

    @Test
    @SneakyThrows
    public void consultarRecurso() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        when(recursoService.consultarRecurso(filtroRecursoDTO)).thenReturn(listResposta);
        recursoController.consultarRecurso("teste");
    }

    @Test
    @SneakyThrows
    public void consultarRecursoIntegracaoException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        Mockito.doThrow(IntegracaoException.class).when(recursoService).consultarRecurso(null);
        recursoController.consultarRecurso("teste");
    }

    @Test
    @SneakyThrows
    public void consultarRecursoObjectMapperException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        Mockito.doThrow(ObjectMapperException.class).when(recursoService).consultarRecurso(null);
        recursoController.consultarRecurso("teste");
    }


    @Test
    @SneakyThrows
    public void exportarConsultaRecurso() {
        byte[] bytes = new byte[5];
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        when(recursoService.exportarConsultaRecurso(filtroRecursoDTO)).thenReturn(bytes);
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn("teste");
        recursoController.exportarConsultaRecurso("filtro");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaRecursoIntegracaoException() {
        byte[] bytes = new byte[5];
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        Mockito.doThrow(IntegracaoException.class).when(recursoService).exportarConsultaRecurso(filtroRecursoDTO);
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn("teste");
        recursoController.exportarConsultaRecurso("filtro");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaRecursoObjectMapperException() {
        byte[] bytes = new byte[5];
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        Mockito.doThrow(ObjectMapperException.class).when(recursoService).exportarConsultaRecurso(filtroRecursoDTO);
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn("teste");
        recursoController.exportarConsultaRecurso("filtro");
    }
    @Test
    @SneakyThrows
    public void exportarConsultaRecursoIOException() {
        byte[] bytes = new byte[5];
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroRecursoDTO.class)).thenReturn(filtroRecursoDTO);
        Mockito.doThrow(IOException.class).when(recursoService).exportarConsultaRecurso(filtroRecursoDTO);
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn("teste");
        recursoController.exportarConsultaRecurso("filtro");
    }



    @Test
    public void buscarIdPedido() {
        when(recursoService.buscarIdPedido(anyLong())).thenReturn(1L);
        recursoController.buscarIdPedido(1L);
    }

    @Test
    public void consultarStatusRespostaAssinada(){
        when(recursoService.consultarStatusRespostaAssinada(anyLong())).thenReturn(true);
        recursoController.consultarStatusRespostaAssinada(anyLong());
    }
}