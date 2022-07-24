package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusTramitacaoRecursoDTO;
import br.com.company.fks.servico.StatusTramitacaoRecursoService;
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
public class StatusTramitacaoRecursoControllerTest {
    @InjectMocks
    private StatusTramitacaoRecursoController statusTramitacaoRecursoController;
    @Mock
    private StatusTramitacaoRecursoService statusTramitacaoRecursoService;
    @Mock
    private List<StatusTramitacaoRecursoDTO> statusTramitacaoRecursoDTOList;
    @Test
    public void consultaStatusTramitacao() {
        when(statusTramitacaoRecursoService.consultarStatusTramitacao()).thenReturn(statusTramitacaoRecursoDTOList);
        statusTramitacaoRecursoController.consultaStatusTramitacao();
    }
}