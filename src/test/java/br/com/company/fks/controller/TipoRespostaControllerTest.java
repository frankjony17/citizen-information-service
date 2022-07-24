package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.TipoResposta;
import br.com.company.fks.servico.TipoRespostaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 25/07/18.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({RespostaBuilder.class})
public class TipoRespostaControllerTest {

    @InjectMocks
    private TipoRespostaController tipoRespostaController;

    @Mock
    private TipoRespostaService tipoRespostaService;

    @Mock
    private List<TipoResposta> tipoRespostaList;

    @Mock
    private RespostaBuilder respostaBuilder;

    @Mock
    private Resposta resposta;

    @Test
    public void buscaTodosTipoRespostaTest() {
        PowerMockito.mockStatic(RespostaBuilder.class);
        when(tipoRespostaService.buscarTodasDescricaoTipoResposta()).thenReturn(tipoRespostaList);
        when(respostaBuilder.getBuilder()).thenReturn(respostaBuilder);
        when(respostaBuilder.setResultado(tipoRespostaList)).thenReturn(respostaBuilder);
        when(respostaBuilder.build()).thenReturn(resposta);
        tipoRespostaController.buscaTodosTipoResposta();

    }
























}
