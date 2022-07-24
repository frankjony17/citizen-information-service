package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Subtema;
import br.com.company.fks.modelo.Tema;
import br.com.company.fks.modelo.dto.AsuntoSubtemaPalavraChaveDTO;
import br.com.company.fks.modelo.dto.ConsultaGlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.GlossarioDeAssuntoDTO;
import br.com.company.fks.modelo.dto.GlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.SubtemaDTO;
import br.com.company.fks.servico.TemaService;
import br.com.company.fks.utils.ControllerUtil;
import io.jsonwebtoken.lang.Assert;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class, RespostaBuilder.class})
public class TemaControllerTest {
    @InjectMocks
    private TemaController temaController;

    @Mock
    private TemaService temaService;

    @Mock
    private Subtema subtema;

    @Mock
    private ConsultaGlossarioDeTemaDTO consultaGlossarioDeTemaDTO;

    @Mock
    private ControllerUtil controllerUtil;

    @Mock
    private Resposta<List<SubtemaDTO>> listResposta;

    @Mock
    private List<Subtema> subtemaList;

    @Mock
    private RespostaBuilder respostaBuilder;

    @Mock
    private Resposta resposta;

    @Mock
    private List<Tema> temaList;

    @Mock
    private GlossarioDeTemaDTO glossarioDeTemaDTO;

    @Mock
    private List<GlossarioDeAssuntoDTO> glossarioAssuntoDTOList;

    @Test
    public void salvar() {
        Mockito.doNothing().when(temaService).salvar(glossarioAssuntoDTOList);
        temaController.salvar(glossarioAssuntoDTOList);
    }

    @Test
    public void salvarExceptionTest() {
        Mockito.doThrow(DataIntegrityViolationException.class).when(temaService).salvar(glossarioAssuntoDTOList);
        ResponseEntity<List<GlossarioDeAssuntoDTO>> response = temaController.salvar(glossarioAssuntoDTOList);
        Assert.notNull(response);
    }

    @Test
    public void buscar() {
        when(temaService.buscar(anyLong())).thenReturn(subtema);
        temaController.buscar(1L);
    }

//    @Test
//    @SneakyThrows
//    public void consultarGlossarioDeTemas() {
//        PowerMockito.mockStatic(ControllerUtil.class);
//        when(controllerUtil.montarFiltroDTO("consultar", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
//        when(temaService.consultaGlossarioDeTemas(consultaGlossarioDeTemaDTO)).thenReturn(listResposta);
//        temaController.consultarGlossarioDeTemas("consultar");
//    }

//    @Test
//    @SneakyThrows
//    public void consultarGlossarioDeTemasIntegracaoException() {
//        PowerMockito.mockStatic(ControllerUtil.class);
//        when(controllerUtil.montarFiltroDTO("consultar", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
//        Mockito.doThrow(IntegracaoException.class).when(temaService).consultaGlossarioDeTemas(consultaGlossarioDeTemaDTO);
//        temaController.consultarGlossarioDeTemas("consultar");
//    }
//
//    @Test
//    @SneakyThrows
//    public void consultarGlossarioDeTemasObjectMapperException() {
//        PowerMockito.mockStatic(ControllerUtil.class);
//        when(controllerUtil.montarFiltroDTO("consultar", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
//        Mockito.doThrow(ObjectMapperException.class).when(temaService).consultaGlossarioDeTemas(consultaGlossarioDeTemaDTO);
//        temaController.consultarGlossarioDeTemas("consultar");
//    }

    @Test
    public void buscarPorSubtemas() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(temaService.buscarPorSubTema(anyLong())).thenReturn(subtemaList);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(subtemaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        temaController.buscarPorSubtemas(1L);
    }

    @Test
    public void buscarTodosTemas() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(temaService.buscarTodostemas()).thenReturn(temaList);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(temaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        temaController.buscarTodosTemas();
    }

    @Test
    public void detalharTema() {
        when(temaService.detalharTema(anyLong())).thenReturn(subtema);
        temaController.detalharTema(1L);
    }

    @Test
    @SneakyThrows
    public void editar() {
        Mockito.doNothing().when(temaService).editar(glossarioDeTemaDTO);
        temaController.editar(glossarioDeTemaDTO);
    }

    @Test
    @SneakyThrows
    public void editarExceptionTest() {
        Mockito.doThrow(DataIntegrityViolationException.class).when(temaService).editar(glossarioDeTemaDTO);
        ResponseEntity<GlossarioDeTemaDTO> response = temaController.editar(glossarioDeTemaDTO);
        Assert.notNull(response);
    }

    @Test
    @SneakyThrows
    public void findGlossarioDeTemas(){
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("consultar", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
        ResponseEntity<Resposta<List<AsuntoSubtemaPalavraChaveDTO>>> response = temaController.findGlossarioDeTemas("Tema teste");
        Assert.notNull(response);
    }

    @Test
    public void buscarTodasPalavrasChaves(){
        ResponseEntity<List<PalavraChave>> reponse = temaController.buscarTodasPalavrasChaves();
        Assert.notNull(reponse);
    }

    @Test
    @SneakyThrows
    public void findGlossarioDeTemasExceptionTest() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("Tema", ConsultaGlossarioDeTemaDTO.class)).thenThrow(ObjectMapperException.class);
        temaController.findGlossarioDeTemas("Tema");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaGlossarioDeAsuntoSubtemaPalavraChave(){
        byte[] bytes = new byte[10];
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("teste", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
        when(temaService.exportarGlossarioDeAsuntoSubtemaPalavraChave(consultaGlossarioDeTemaDTO)).thenReturn(bytes);
        ResponseEntity<byte[]> reponse = temaController.exportarConsultaGlossarioDeAsuntoSubtemaPalavraChave("teste");
        Assert.notNull(reponse);
    }

    @Test
    @SneakyThrows
    public void exportarConsultaGlossarioDeAsuntoSubtemaPalavraChaveIntegracaoException(){
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("teste", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
        when(temaService.exportarGlossarioDeAsuntoSubtemaPalavraChave(consultaGlossarioDeTemaDTO)).thenThrow(IntegracaoException.class);
        temaController.exportarConsultaGlossarioDeAsuntoSubtemaPalavraChave("teste");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaGlossarioDeAsuntoSubtemaPalavraChaveObjectMapperException(){
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("teste", ConsultaGlossarioDeTemaDTO.class)).thenThrow(ObjectMapperException.class);
        temaController.exportarConsultaGlossarioDeAsuntoSubtemaPalavraChave("teste");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaGlossarioDeAsuntoSubtemaPalavraChaveIOException(){
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("teste", ConsultaGlossarioDeTemaDTO.class)).thenReturn(consultaGlossarioDeTemaDTO);
        when(temaService.exportarGlossarioDeAsuntoSubtemaPalavraChave(consultaGlossarioDeTemaDTO)).thenThrow(IOException.class);
        temaController.exportarConsultaGlossarioDeAsuntoSubtemaPalavraChave("teste");
    }


}