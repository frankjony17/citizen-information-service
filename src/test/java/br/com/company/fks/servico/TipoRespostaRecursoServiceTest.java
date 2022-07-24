package br.com.company.fks.servico;

import br.com.company.fks.modelo.TipoRespostaRecurso;
import br.com.company.fks.modelo.dto.TipoRespostaRecursoDTO;
import br.com.company.fks.repositorio.TipoRespostaRecursoRepository;
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
public class TipoRespostaRecursoServiceTest {

    @InjectMocks
    private TipoRespostaRecursoService tipoRespostaRecursoService;

    @Mock
    private TipoRespostaRecursoRepository tipoRespostaRecursoRepository;


    @Test
    public void consultaTipoRespostaRecursoTest() {
        List<TipoRespostaRecurso> tipoRespostaRecursoList = new ArrayList<>();
        tipoRespostaRecursoList.add(new TipoRespostaRecurso());

        when(tipoRespostaRecursoRepository.findAll()).thenReturn(tipoRespostaRecursoList);

        List<TipoRespostaRecursoDTO> retorno = tipoRespostaRecursoService.consultaTipoRespostaRecurso();

        assertEquals(1, retorno.size());
    }
}
