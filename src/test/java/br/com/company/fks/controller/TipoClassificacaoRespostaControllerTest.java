package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.TipoClassificacaoResposta;
import br.com.company.fks.servico.TipoClassificacaoRespostaService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RespostaBuilder.class})
public class TipoClassificacaoRespostaControllerTest {

    @InjectMocks
    private TipoClassificacaoRespostaController tipoClassificacaoRespostaController;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private TipoClassificacaoRespostaService tipoClassificacaoRespostaService;

    @Mock
    private List<TipoClassificacaoResposta> tipoClassificacaoRespostas;

    @Mock
    private RespostaBuilder respostaBuilder;

    @Mock
    private Resposta resposta;

    @Test
    public void buscarTipoClassificacaoRespostaTest() {
        when(tipoClassificacaoRespostaService.buscarTodosTiposClassificacaoResposta()).thenReturn(tipoClassificacaoRespostas);
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(anyString())).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        tipoClassificacaoRespostaController.buscarTipoClassificacaoResposta();
    }
}
