package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.DevolveRecursoDTO;
import br.com.company.fks.servico.DevolveRecursoService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class DevolveRecursoControllerTest {
    @InjectMocks
    private DevolveRecursoController devolveRecursoController;

    @Mock
    private DevolveRecursoService devolveRecursoService;

    @Mock
    private DevolveRecursoDTO devolveRecursoDTO;

    @Test
    @SneakyThrows
    public void devolver() {
        Mockito.doNothing().when(devolveRecursoService).reverterAndamentoRecurso(devolveRecursoDTO);
        devolveRecursoController.devolver(devolveRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void devolverCatch(){
        Mockito.doThrow(IntegracaoException.class).when(devolveRecursoService).reverterAndamentoRecurso(devolveRecursoDTO);
        devolveRecursoController.devolver(devolveRecursoDTO);
    }

    @Test
    public void consultarStatusRecurso() {
        when(devolveRecursoService.consultarStatusRecurso(anyLong())).thenReturn(devolveRecursoDTO);
        devolveRecursoController.consultarStatusRecurso(1L);
    }
}