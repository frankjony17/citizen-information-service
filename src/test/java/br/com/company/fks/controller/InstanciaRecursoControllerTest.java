package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.InstanciaRecursoDTO;
import br.com.company.fks.servico.InstanciaRecursoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 25/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class InstanciaRecursoControllerTest {

    @InjectMocks
    private InstanciaRecursoController instanciaRecursoController;

    @Mock
    private InstanciaRecursoService instanciaRecursoService;

    @Mock
    private List<InstanciaRecursoDTO> instanciaRecursoDTOList;

    @Test
    public void consultaInstanciaRecursoTest(){
        when(instanciaRecursoService.consultaInstanciaRecurso()).thenReturn(instanciaRecursoDTOList);
        instanciaRecursoController.consultaInstanciaRecurso();

    }
}
