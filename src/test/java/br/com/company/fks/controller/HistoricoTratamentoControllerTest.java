package br.com.company.fks.controller;

import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.servico.HistoricoTratamentoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 25/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class HistoricoTratamentoControllerTest {

    @InjectMocks
    private HistoricoTratamentoController historicoTratamentoController;

    @Mock
    private HistoricoTratamentoService historicoTratamentoService;

    @Mock
    private HistoricoTratamento historicoTratamento;

    @Test
    public void buscarRepostaHistoricoTest(){
        when(historicoTratamentoService.buscarRespostaHistorico(anyLong())).thenReturn(historicoTratamento);
        historicoTratamentoController.buscarRepostaHistorico(1L);
    }
}
