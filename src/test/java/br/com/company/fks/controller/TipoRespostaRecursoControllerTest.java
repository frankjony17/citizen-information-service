package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.TipoRespostaRecursoDTO;
import br.com.company.fks.servico.TipoRespostaRecursoService;
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
public class TipoRespostaRecursoControllerTest {
    @InjectMocks
    private TipoRespostaRecursoController tipoRespostaRecursoController;

    @Mock
    private TipoRespostaRecursoService tipoRespostaRecursoService;

    @Mock
    private List<TipoRespostaRecursoDTO> tipoRespostaRecursoDTOList;

    @Test
    public void consultaTipoRespostaRecurso() {
        when(tipoRespostaRecursoService.consultaTipoRespostaRecurso()).thenReturn(tipoRespostaRecursoDTOList);
        tipoRespostaRecursoController.consultaTipoRespostaRecurso();
    }
}