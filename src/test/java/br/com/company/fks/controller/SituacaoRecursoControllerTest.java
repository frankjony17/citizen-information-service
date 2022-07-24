package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.SituacaoRecursoDTO;
import br.com.company.fks.servico.SituacaoRecursoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class SituacaoRecursoControllerTest {
    @InjectMocks
    private SituacaoRecursoController situacaoRecursoController;

    @Mock
    private SituacaoRecursoService situacaoRecursoService;

    @Mock
    private List<SituacaoRecursoDTO> situacaoRecursoDTOList;

    @Test
    public void consultaSituacaoRecurso() {
        when(situacaoRecursoService.consultaSituacaoRecurso()).thenReturn(situacaoRecursoDTOList);
        situacaoRecursoController.consultaSituacaoRecurso();
    }
}