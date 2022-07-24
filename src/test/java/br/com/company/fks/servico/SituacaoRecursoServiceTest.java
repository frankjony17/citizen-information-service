package br.com.company.fks.servico;

import br.com.company.fks.modelo.SituacaoRecurso;
import br.com.company.fks.modelo.dto.SituacaoRecursoDTO;
import br.com.company.fks.repositorio.SituacaoRecursoRepository;
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
public class SituacaoRecursoServiceTest {

    @InjectMocks
    private SituacaoRecursoService situacaoRecursoService;

    @Mock
    private SituacaoRecursoRepository situacaoRecursoRepository;


    @Test
    public void consultaTipoRespostaRecursoTest() {
        List<SituacaoRecurso> situacaoRecursoList = new ArrayList<>();
        situacaoRecursoList.add(new SituacaoRecurso());

        when(situacaoRecursoRepository.findAll()).thenReturn(situacaoRecursoList);

        List<SituacaoRecursoDTO> retorno = situacaoRecursoService.consultaSituacaoRecurso();

        assertEquals(1, retorno.size());
    }
}
