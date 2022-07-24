package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.ConsultaHistoricoRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.HistoricoTratamentoRecursoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class HistoricoTratamentoRecursoControllerTest {
    @InjectMocks
    private HistoricoTratamentoRecursoController historicoTratamentoRecursoController;
    @Mock
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;
    @Mock
    private Page<ConsultaHistoricoRecursoDTO> consultaHistoricoRecursoDTOPage;
    @Mock
    private RespostaDTO respostaDTO;
    @Mock
    private Calendar calendar;
    @Test
    public void consultarHistoricoRecurso() {
        when(historicoTratamentoRecursoService.consultarHistoricoRecurso(anyLong(),anyInt(),anyInt())).thenReturn(consultaHistoricoRecursoDTOPage);
        historicoTratamentoRecursoController.consultarHistoricoRecurso(1L,2,3);
    }

    @Test
    public void buscarRepostaHistorico() {
        when(historicoTratamentoRecursoService.buscarRespostaHistorico(anyLong())).thenReturn(respostaDTO);
        historicoTratamentoRecursoController.buscarRepostaHistorico(1L);
    }

    @Test
    public void consultarDataRespostaRecurso() {
        when(historicoTratamentoRecursoService.consultarDataRespostaRecurso(anyLong())).thenReturn(calendar);
        historicoTratamentoRecursoController.consultarDataRespostaRecurso(1L);
    }
}