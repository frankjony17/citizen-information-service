package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.RespostaRecursoDTO;
import br.com.company.fks.servico.RespostaRecursoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class RespostaRecursoControllerTest {
    @InjectMocks
    private RespostaRecursoController respostaRecursoController;
    @Mock
    private RespostaRecursoService respostaRecursoService;
    @Mock
    private RespostaRecursoDTO respostaRecursoDTO;

    @Test
    public void enviar() {
        Mockito.doNothing().when(respostaRecursoService).enviar(respostaRecursoDTO);
        respostaRecursoController.enviar(respostaRecursoDTO);
    }

    @Test
    public void verificarAndamentoRecurso(){
        respostaRecursoController.verificarAndamentoRecurso(1L);
    }
}