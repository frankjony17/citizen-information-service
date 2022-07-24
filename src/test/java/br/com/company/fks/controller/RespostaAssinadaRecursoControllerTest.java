package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.RespostaAssinadaRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.RespostaAssinadaRecursoService;
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
public class RespostaAssinadaRecursoControllerTest {
    @InjectMocks
    private RespostaAssinadaRecursoController respostaAssinadaRecursoController;
    @Mock
    private RespostaAssinadaRecursoService respostaAssinadaRecursoService;
    @Mock
    private RespostaDTO respostaDTO;
    @Mock
    private RespostaAssinadaRecursoDTO respostaAssinadaRecursoDTO;

    @Test
    public void buscarRespostaRecurso() {
        when(respostaAssinadaRecursoService.buscarRespostaRecurso(anyLong())).thenReturn(respostaDTO);
        respostaAssinadaRecursoController.buscarRespostaRecurso(1L);
    }

    @Test
    @SneakyThrows
    public void salvarRespostaRecurso() {
        Mockito.doNothing().when(respostaAssinadaRecursoService).salvarRespostaRecurso(respostaAssinadaRecursoDTO);
        respostaAssinadaRecursoController.salvarRespostaRecurso(respostaAssinadaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarRespostaRecursoIntegracaoException() {
        Mockito.doThrow(IntegracaoException.class).when(respostaAssinadaRecursoService).salvarRespostaRecurso(respostaAssinadaRecursoDTO);
        respostaAssinadaRecursoController.salvarRespostaRecurso(respostaAssinadaRecursoDTO);
    }
}