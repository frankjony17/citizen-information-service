package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.ClassificarRespostaSic;
import br.com.company.fks.modelo.dto.ClassificarRespostaSicDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.ClassificarRespostaSicService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.EntityConverter;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClassificarRespostaSicControllerTest {

    @InjectMocks
    private ClassificarRespostaSicController classificarRespostaSicController;

    @Mock
    private ClassificarRespostaSicService classificarRespostaSicService;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private PedidoService pedidoService;

    @Mock
    private ClassificarRespostaSicDTO classificarRespostaSicDTO;

    @Mock
    private RespostaDTO respostaDTO;

    @Mock
    private ClassificarRespostaSic classificarRespostaSic;

    @Test
    public void salvarClassificarRespostaSicTest(){
        Mockito.doNothing().when(classificarRespostaSicService).salvar(any(ClassificarRespostaSicDTO.class));
        classificarRespostaSicController.salvarClassificarRespostaSic(classificarRespostaSicDTO);
    }

    @Test
    public void buscarRespostaTest(){
        when(classificarRespostaSicService.buscarResposta(anyLong())).thenReturn(respostaDTO);
         classificarRespostaSicController.buscarResposta(1L);
    }

    @Test
    public void buscarTest(){
        when(classificarRespostaSicService.buscarClassificacaoRespostaESic(anyLong())).thenReturn(classificarRespostaSic);
        classificarRespostaSicController.buscar(1L);
    }

    @Test
    @SneakyThrows
    public void editarTest(){
        when(entityConverter.converterStrict(classificarRespostaSicDTO,ClassificarRespostaSic.class)).thenReturn(classificarRespostaSic);
        Mockito.doNothing().when(classificarRespostaSicService).editarClassificacaoSic(any(ClassificarRespostaSic.class));
        classificarRespostaSicController.editar(classificarRespostaSicDTO);
    }

    @Test
    @SneakyThrows
    public void editarTestCatch(){
        when(entityConverter.converterStrict(classificarRespostaSicDTO,ClassificarRespostaSic.class)).thenReturn(classificarRespostaSic);
        Mockito.doThrow(IntegracaoException.class).when(classificarRespostaSicService).editarClassificacaoSic(any(ClassificarRespostaSic.class));
        classificarRespostaSicController.editar(classificarRespostaSicDTO);
    }

    @Test
    public void verificaSePossuiClassificacaoRespostaESicTest(){
        when(pedidoService.verificaSePossuiClassificacaoRespostaESic(anyLong())).thenReturn(true);
        classificarRespostaSicController.verificaSePossuiClassificacaoRespostaESic(1L);
    }

    @Test
    public void buscarClassificacaoRespostaESicTest(){
        when(classificarRespostaSicService.buscarClassificacaoRespostaESic(anyLong())).thenReturn(classificarRespostaSic);
        classificarRespostaSicController.buscarClassificacaoRespostaESic(1L);
    }


























}
