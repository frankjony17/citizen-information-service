package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.ClassificacaoResposta;
import br.com.company.fks.modelo.dto.ClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.ConsultaClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.RespostaClassificadaDTO;
import br.com.company.fks.servico.ClassificacaoRespostaService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.IOException;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class, RespostaBuilder.class})
public class ClassificacaoRespostaControllerTest {
    @InjectMocks
    private ClassificacaoRespostaController classificacaoRespostaController;

    @Mock
    private ClassificacaoRespostaService classificacaoRespostaService;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private PedidoService pedidoService;

    @Mock
    private List<ClassificacaoRespostaDTO> classificacaoRespostaDTOList;

    @Mock
    private ClassificacaoResposta classificacaoResposta;

    @Mock
    private ControllerUtil controlerUtil;

    @Mock
    private ConsultaClassificacaoRespostaDTO consultaClassificacaoRespostaDTO;

    @Mock
    private RespostaBuilder respostaBuilder;

    @Mock
    private Resposta resposta;

    @Mock
    private ClassificacaoRespostaDTO classificacaoRespostaDTO;

    @Mock
    private List<ClassificacaoResposta> classificacaoRespostaList;

    @Mock
    private RespostaClassificadaDTO respostaClassificadaDTO;

    @Test
    public void classificarTest() {
        Mockito.doNothing().when(classificacaoRespostaService).salvar(classificacaoRespostaDTOList);
        classificacaoRespostaController.classificar(classificacaoRespostaDTOList);
    }

    @Test
    public void classificarExceptionTest() {
        Mockito.doThrow(DataIntegrityViolationException.class).when(classificacaoRespostaService).salvar(classificacaoRespostaDTOList);
        classificacaoRespostaController.classificar(classificacaoRespostaDTOList);
    }

    @Test
    public void buscarTest() {
        when(classificacaoRespostaService.buscarClassificacaoResposta(anyLong())).thenReturn(classificacaoResposta);
        classificacaoRespostaController.buscar(1L);
    }

    @Test
    public void deletarClassificacaoRespostaTest() {
        Mockito.doNothing().when(classificacaoRespostaService).excluirClassificacaoResposta(anyLong());
        classificacaoRespostaController.deletarClassificacaoResposta(1L);
    }

    @Test
    @SneakyThrows
    public void consultarClassificaoRespostaTestCatchIntegracao() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controlerUtil.montarFiltroDTO("consultar", ConsultaClassificacaoRespostaDTO.class)).thenReturn(consultaClassificacaoRespostaDTO);
        Mockito.doThrow(IntegracaoException.class).when(classificacaoRespostaService).consultaClassificacaoResposta(any(ConsultaClassificacaoRespostaDTO.class));
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setErro(anyString())).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoRespostaController.consultarClassificaoResposta("test");
    }

    @Test
    @SneakyThrows
    public void consultarClassificaoRespostaTestCatchObjectMapper() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controlerUtil.montarFiltroDTO("consultar", ConsultaClassificacaoRespostaDTO.class)).thenReturn(consultaClassificacaoRespostaDTO);
        Mockito.doThrow(ObjectMapperException.class).when(classificacaoRespostaService).consultaClassificacaoResposta(any(ConsultaClassificacaoRespostaDTO.class));
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setErro(anyString())).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoRespostaController.consultarClassificaoResposta("test");
    }

    @Test
    @SneakyThrows
    public void editarTest() {
        when(entityConverter.converterStrict(classificacaoRespostaDTO, ClassificacaoResposta.class)).thenReturn(classificacaoResposta);
        Mockito.doNothing().when(classificacaoRespostaService).editar(classificacaoRespostaDTO);
        classificacaoRespostaController.editar(classificacaoRespostaDTO);

    }

    @Test
    @SneakyThrows
    public void editarTestCatch() {
        when(entityConverter.converterStrict(classificacaoRespostaDTO, ClassificacaoResposta.class)).thenReturn(classificacaoResposta);
        Mockito.doThrow(DataIntegrityViolationException.class).when(classificacaoRespostaService).editar(classificacaoRespostaDTO);
        classificacaoRespostaController.editar(classificacaoRespostaDTO);
    }

    @Test
    public void buscarOrientacaoSolicitanteTest() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(classificacaoRespostaService.buscarTodasOrientacaoSolicitacao()).thenReturn(classificacaoRespostaList);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(classificacaoRespostaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoRespostaController.buscarOrientacaoSolicitante();
    }

    @Test
    public void buscarTransparenciaAtivaTest() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(classificacaoRespostaService.buscarTodasTransparenciaAtiva()).thenReturn(classificacaoRespostaList);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(classificacaoRespostaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoRespostaController.buscarTransparenciaAtiva();
    }

    @Test
    public void buscarTransparenciaPassivaTest() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(classificacaoRespostaService.buscarTodasTransparenciaPassiva()).thenReturn(classificacaoRespostaList);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(classificacaoRespostaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoRespostaController.buscarTransparenciaPassiva();
    }

    @Test
    public void buscarAcessoNegadoTest() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(classificacaoRespostaService.buscarTodasAcessoNegado()).thenReturn(classificacaoRespostaList);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(classificacaoRespostaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoRespostaController.buscarAcessoNegado();
    }

    @Test
    public void salvarRespostaClassificadaTest() {
        Mockito.doNothing().when(pedidoService).salvarRespostaClassificada(any(RespostaClassificadaDTO.class));
        classificacaoRespostaController.salvarRespostaClassificada(respostaClassificadaDTO);
    }

    @Test
    public void verificaSePossuiClassificacaoRespostaTest() {
        when(pedidoService.verificaSeRespostaEClassificada(anyLong())).thenReturn(true);
        classificacaoRespostaController.verificaSePossuiClassificacaoResposta(1L);
    }

    @Test
    public void buscarClassificacaoRespostaTest() {
        when(classificacaoRespostaService.buscarRespostaClassificada(anyLong())).thenReturn(classificacaoRespostaList);
        classificacaoRespostaController.buscarClassificacaoResposta(1L);
    }

    @Test
    public void ativaDesativaStatusClassificacaoResposta() {
        Assert.assertNotNull(classificacaoRespostaController.ativaDesativaStatusClassificacaoResposta(1L, true));
    }


    @Test
    @SneakyThrows
    public void exportarConsultaClassificacaoRespostaIntegracao() {
        byte[] bytes = new byte[0x7ffff];
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controlerUtil.montarFiltroDTO("consultar", ConsultaClassificacaoRespostaDTO.class)).thenReturn(consultaClassificacaoRespostaDTO);
        when(classificacaoRespostaService.exportarClassificacaoResposta(consultaClassificacaoRespostaDTO)).thenReturn(bytes);
        classificacaoRespostaController.exportarConsultaClassificacaoResposta("consultar");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaClassificacaoRespostaIntegracaoException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controlerUtil.montarFiltroDTO("consultar", ConsultaClassificacaoRespostaDTO.class)).thenReturn(consultaClassificacaoRespostaDTO);
        when(classificacaoRespostaService.exportarClassificacaoResposta(consultaClassificacaoRespostaDTO)).thenThrow(IntegracaoException.class);
        classificacaoRespostaController.exportarConsultaClassificacaoResposta("consultar");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaClassificacaoRespostaObjectMapperException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controlerUtil.montarFiltroDTO("consultar", ConsultaClassificacaoRespostaDTO.class)).thenThrow(ObjectMapperException.class);
        classificacaoRespostaController.exportarConsultaClassificacaoResposta("consultar");
    }

    @Test
    @SneakyThrows
    public void exportarConsultaClassificacaoRespostaIOException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controlerUtil.montarFiltroDTO("consultar", ConsultaClassificacaoRespostaDTO.class)).thenReturn(consultaClassificacaoRespostaDTO);
        when(classificacaoRespostaService.exportarClassificacaoResposta(consultaClassificacaoRespostaDTO)).thenThrow(IOException.class);
        classificacaoRespostaController.exportarConsultaClassificacaoResposta("consultar");
    }

}
