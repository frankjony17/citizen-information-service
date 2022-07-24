package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.servico.StatusSolicitacaoRecursoService;
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
public class StatusSolicitacaoRecursoControllerTest {
    @InjectMocks
    private StatusSolicitacaoRecursoController statusSolicitacaoRecursoController;
    @Mock
    private List<StatusSolicitacaoRecursoDTO> statusSolicitacaoRecursoDTOS;

    @Mock
    private StatusSolicitacaoRecursoService statusSolicitacaoRecursoService;

    @Test
    public void consultaStatusSolicitacao() {
        when(statusSolicitacaoRecursoService.consultarStatusSolicitacao()).thenReturn(statusSolicitacaoRecursoDTOS);
        statusSolicitacaoRecursoController.consultaStatusSolicitacao();
    }
}