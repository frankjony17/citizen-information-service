package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.ClassificacaoTipoResposta;
import br.com.company.fks.repositorio.ClassificacaoRespostaRepository;
import br.com.company.fks.servico.ClassificacaoTipoRespostaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RespostaBuilder.class})
public class ClassificacaoTipoRespostaControllerTest {
    @InjectMocks
    private ClassificacaoTipoRespostaController classificacaoTipoRespostaController;

    @Mock
    private ClassificacaoTipoRespostaService classificacaoTipoRespostaService;

    @Mock
    private ClassificacaoTipoResposta classificacaoTipoResposta;

    @Mock
    private RespostaBuilder respostaBuilder;

    @Mock
    private Resposta resposta;

    @Mock
    private ClassificacaoRespostaRepository classificacaoRespostaRepository;

    @Test
    public void buscarTodasClassificacaoTipoRespostaTest(){
        List<ClassificacaoTipoResposta> listaClassificacaoTipoResposta = new ArrayList<>();
        listaClassificacaoTipoResposta.add(classificacaoTipoResposta);
        when(classificacaoTipoRespostaService.buscarTodasClassificacaoTipoResposta()).thenReturn(listaClassificacaoTipoResposta);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(listaClassificacaoTipoResposta)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoTipoRespostaController.buscarTodasClassificacaoTipoResposta();
    }

    @Test
    public void buscarPorTipoRespostaTest(){
        List<ClassificacaoTipoResposta> listaClassificacaoTipoResposta = new ArrayList<>();
        listaClassificacaoTipoResposta.add(classificacaoTipoResposta);
        when(classificacaoTipoRespostaService.buscarPorTipoResposta(anyLong())).thenReturn(listaClassificacaoTipoResposta);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(listaClassificacaoTipoResposta)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        classificacaoTipoRespostaController.buscarPorTipoResposta(1L);
    }
}
