package br.com.company.fks.servico;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.dto.DevolveRecursoDTO;
import br.com.company.fks.repositorio.RecursoRepository;
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
 * Created by Maicon Godoy - FKSolutions Tecnologia on 30/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class DevolveRecursoServiceTest {

    @InjectMocks
    private DevolveRecursoService devolveRecursoService;

    @Mock
    private AndamentoRecursoService andamentoRecursoService;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private Recurso recurso;

    @Mock
    private DevolveRecursoDTO devolveRecursoDTO;

    @Mock
    private StatusSolicitacaoRecurso statusSolicitacaoRecurso;

    @Test
    @SneakyThrows
    public void reverterAndamentoRecursoCASE4() {
        when(devolveRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.buscarRecursoEStatusSolicitacao(anyLong())).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(4L);
        when(devolveRecursoDTO.getJustificativa()).thenReturn("teste");
        Mockito.doNothing().when(andamentoRecursoService).reverterAndamentoRecurso(recurso,"Recurso 1ª Devolvido");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);

    }
    @Test
    @SneakyThrows
    public void reverterAndamentoRecursoCASE5() {
        when(devolveRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.buscarRecursoEStatusSolicitacao(anyLong())).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(5L);
        when(devolveRecursoDTO.getJustificativa()).thenReturn("teste");
        Mockito.doNothing().when(andamentoRecursoService).reverterAndamentoRecurso(recurso,"Recurso 1ª Devolvido");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);

    }
    @Test
    @SneakyThrows
    public void reverterAndamentoRecursoCASE6() {
        when(devolveRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.buscarRecursoEStatusSolicitacao(anyLong())).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(6L);
        when(devolveRecursoDTO.getJustificativa()).thenReturn("teste");
        Mockito.doNothing().when(andamentoRecursoService).reverterAndamentoRecurso(recurso,"Recurso 1ª Devolvido");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);

    }
    @Test
    @SneakyThrows
    public void reverterAndamentoRecursoCASE12() {
        when(devolveRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.buscarRecursoEStatusSolicitacao(anyLong())).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(12L);
        when(devolveRecursoDTO.getJustificativa()).thenReturn("teste");
        Mockito.doNothing().when(andamentoRecursoService).reverterAndamentoRecurso(recurso,"Recurso 1ª Devolvido");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);

    }
    @Test
    @SneakyThrows
    public void reverterAndamentoRecursoCASE13() {
        when(devolveRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.buscarRecursoEStatusSolicitacao(anyLong())).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(13L);
        when(devolveRecursoDTO.getJustificativa()).thenReturn("teste");
        Mockito.doNothing().when(andamentoRecursoService).reverterAndamentoRecurso(recurso,"Recurso 1ª Devolvido");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);

    }
    @Test
    @SneakyThrows
    public void reverterAndamentoRecursoCASE14() {
        when(devolveRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.buscarRecursoEStatusSolicitacao(anyLong())).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(14L);
        when(devolveRecursoDTO.getJustificativa()).thenReturn("teste");
        Mockito.doNothing().when(andamentoRecursoService).reverterAndamentoRecurso(recurso,"Recurso 1ª Devolvido");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);

    }

    @Test
    public void consultarStatusRecursoCASE4() {
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(4L);
        devolveRecursoService.consultarStatusRecurso(1L);
    }
    @Test
    public void consultarStatusRecursoCASE5() {
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(5L);
        devolveRecursoService.consultarStatusRecurso(1L);
    }
    @Test
    public void consultarStatusRecursoCASE6() {
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(6L);
        devolveRecursoService.consultarStatusRecurso(1L);
    }
    @Test
    public void consultarStatusRecursoCASE12() {
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(12L);
        devolveRecursoService.consultarStatusRecurso(1L);
    }
    @Test
    public void consultarStatusRecursoCASE13() {
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(13L);
        devolveRecursoService.consultarStatusRecurso(1L);
    }
    @Test
    public void consultarStatusRecursoCASE14() {
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(14L);
        devolveRecursoService.consultarStatusRecurso(1L);
    }
}