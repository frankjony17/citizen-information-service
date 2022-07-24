package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.AndamentoRecursoDTO;
import br.com.company.fks.servico.AndamentoRecursoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class AndamentoRecursoControllerTest {
    @InjectMocks
    private AndamentoRecursoController andamentoRecursoController;
    @Mock
    private AndamentoRecursoService andamentoRecursoService;
    @Mock
    private Page<AndamentoRecursoDTO> andamentoRecursoDTOS;

    @Test
    public void consultarAndamentoRecurso() {
        when(andamentoRecursoService.consultarAndamentoRecurso(anyLong(),anyInt(),anyInt())).thenReturn(andamentoRecursoDTOS);
        andamentoRecursoController.consultarAndamentoRecurso(1L,2,3);
    }
    @Test
    public void buscarUsuario(){
        when(andamentoRecursoService.buscarUsuario(anyLong())).thenReturn("nome_usuario");
        ResponseEntity<?> response = andamentoRecursoController.buscarUsuario(1L);
        assertEquals(response.getBody(), "nome_usuario");
    }
}