package br.com.company.fks.servico;

import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.repositorio.StatusSolicitacaoRecursoRepository;
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
public class StatusSolicitacaoRecursoServiceTest {

    @InjectMocks
    private StatusSolicitacaoRecursoService statusSolicitacaoRecursoService;

    @Mock
    private StatusSolicitacaoRecursoRepository statusSolicitacaoRecursoRepository;


    @Test
    public void consultaTipoRespostaRecursoTest() {
        List<StatusSolicitacaoRecurso> statusSolicitacaoRecursoList = new ArrayList<>();
        statusSolicitacaoRecursoList.add(new StatusSolicitacaoRecurso());

        when(statusSolicitacaoRecursoRepository.findAll()).thenReturn(statusSolicitacaoRecursoList);

        List<StatusSolicitacaoRecursoDTO> retorno = statusSolicitacaoRecursoService.consultarStatusSolicitacao();

        assertEquals(1, retorno.size());
    }
}
