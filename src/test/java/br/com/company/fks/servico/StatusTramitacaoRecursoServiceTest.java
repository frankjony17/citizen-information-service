package br.com.company.fks.servico;

import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.dto.StatusTramitacaoRecursoDTO;
import br.com.company.fks.repositorio.StatusTramitacaoRecursoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StatusTramitacaoRecursoServiceTest {

    @InjectMocks
    private StatusTramitacaoRecursoService statusTramitacaoRecursoService;

    @Mock
    private StatusTramitacaoRecursoRepository statusTramitacaoRecursoRepository;


    @Test
    public void consultaTipoRespostaRecursoTest() {
        List<StatusTramitacaoRecurso> statusTramitacaoRecursoList = new ArrayList<>();
        statusTramitacaoRecursoList.add(new StatusTramitacaoRecurso());

        when(statusTramitacaoRecursoRepository.findAll()).thenReturn(statusTramitacaoRecursoList);

        List<StatusTramitacaoRecursoDTO> retorno = statusTramitacaoRecursoService.consultarStatusTramitacao();

        assertEquals(1, retorno.size());
    }
}
