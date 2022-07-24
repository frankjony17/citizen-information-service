package br.com.company.fks.servico;

import br.com.company.fks.modelo.InstanciaRecurso;
import br.com.company.fks.repositorio.InstanciaRecursoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 25/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class InstanciaRecursoServiceTest {

    @InjectMocks
    private InstanciaRecursoService instanciaRecursoService;

    @Mock
    private InstanciaRecursoRepository instanciaRecursoRepository;

    @Mock
    private InstanciaRecurso instanciaRecurso;

    @Test
    public void consultaInstanciaRecursoTest(){
        List<InstanciaRecurso> instanciaRecursoList = new ArrayList<>();
        instanciaRecursoList.add(instanciaRecurso);
        when(instanciaRecursoRepository.findAll()).thenReturn(instanciaRecursoList);
        instanciaRecursoService.consultaInstanciaRecurso();

    }
}
