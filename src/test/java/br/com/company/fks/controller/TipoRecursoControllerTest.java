package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.TipoRecursoDTO;
import br.com.company.fks.servico.TipoRecursoService;
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
public class TipoRecursoControllerTest {
    @InjectMocks
    private TipoRecursoController tipoRecursoController;

    @Mock
    private TipoRecursoService tipoRecursoService;

    @Mock
    private List<TipoRecursoDTO> tipoRecursoDTOList;

    @Test
    public void consultaTipoRecurso() {
        when(tipoRecursoService.consultaTipoRecurso()).thenReturn(tipoRecursoDTOList);
        tipoRecursoController.consultaTipoRecurso();
    }
}