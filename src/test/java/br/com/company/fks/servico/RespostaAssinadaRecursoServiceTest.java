package br.com.company.fks.servico;

import br.com.company.fks.modelo.HistoricoTratamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.RespostaAssinadaRecursoDTO;
import br.com.company.fks.repositorio.HistoricoTratamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 03/09/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class RespostaAssinadaRecursoServiceTest {
    @InjectMocks
    private RespostaAssinadaRecursoService respostaAssinadaRecursoService;

    @Mock
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private HistoricoTratamentoRecursoRepository historicoTratamentoRecursoRepository;


    @Mock
    private HistoricoTratamentoRecurso historicoTratamentoRecurso;

    @Mock
    private RespostaAssinadaRecursoDTO respostaAssinadaRecursoDTO;

    @Mock
    private Recurso recurso;



    @Test
    public void buscarRespostaRecursoLista() {
        List<HistoricoTratamentoRecurso> historicoTratamentoRecursos = new ArrayList<>();
        historicoTratamentoRecursos.add(historicoTratamentoRecurso);
        historicoTratamentoRecursos.add(historicoTratamentoRecurso);
        historicoTratamentoRecursos.add(historicoTratamentoRecurso);
        when(historicoTratamentoRecursoRepository.recuperarRespostaHistoricoPorIdRecurso(1L)).thenReturn(historicoTratamentoRecursos);
        when(historicoTratamentoRecurso.getRespostaRecurso()).thenReturn("teste");
        respostaAssinadaRecursoService.buscarRespostaRecurso(1L);
    }

    @Test
    public void buscarRespostaRecursoListaVazia() {
        List<HistoricoTratamentoRecurso> historicoTratamentoRecursos = new ArrayList<>();
        when(historicoTratamentoRecursoRepository.recuperarRespostaHistoricoPorIdRecurso(1L)).thenReturn(historicoTratamentoRecursos);
        respostaAssinadaRecursoService.buscarRespostaRecurso(1L);
    }


    @Test
    @SneakyThrows
    public void salvarRespostaRecursoRespostaNula() {
        when(respostaAssinadaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recurso.getRespostaEsic()).thenReturn(null);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        when(respostaAssinadaRecursoDTO.getRespostaRecurso()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        respostaAssinadaRecursoService.salvarRespostaRecurso(respostaAssinadaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarRespostaRecursoRespostaNaoNula() {
        when(respostaAssinadaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        when(recurso.getStatusRespostaAssinada()).thenReturn(true);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        when(respostaAssinadaRecursoDTO.getRespostaRecurso()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        respostaAssinadaRecursoService.salvarRespostaRecurso(respostaAssinadaRecursoDTO);
    }
    @Test
    @SneakyThrows
    public void salvarRespostaRecursoRespostaNaoNulaStatusFalse() {
        when(respostaAssinadaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        when(recurso.getStatusRespostaAssinada()).thenReturn(false);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        when(respostaAssinadaRecursoDTO.getRespostaRecurso()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        respostaAssinadaRecursoService.salvarRespostaRecurso(respostaAssinadaRecursoDTO);
    }























}