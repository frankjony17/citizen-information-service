package br.com.company.fks.servico;

import br.com.company.fks.modelo.HistoricoTratamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.ConsultaHistoricoRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.repositorio.HistoricoTratamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HistoricoTratamentoRecursoServiceTest {

    @InjectMocks
    private HistoricoTratamentoRecursoService service;

    @Mock
    private HistoricoTratamentoRecursoRepository historicoTratamentoRecursoRepository;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private Recurso recurso;

    @Mock
    private Page<ConsultaHistoricoRecursoDTO> consultaHistoricoRecursoDTO;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private HistoricoTratamentoRecurso historicoTratamentoRecurso;

    @Mock
    private Calendar dataRespostaRecurso;

    @Test
    public void buscarRespostaHistorico(){
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setResposta("resposta");
        HistoricoTratamentoRecurso historicoTratamentoRecurso = new HistoricoTratamentoRecurso();
        historicoTratamentoRecurso.setRespostaRecurso("resposta-recurso");
        when(historicoTratamentoRecursoRepository.findOne(anyLong())).thenReturn(historicoTratamentoRecurso);
        service.buscarRespostaHistorico(1L);
    }

    @Test
    public void consultarHistoricoRecurso(){
        when(recursoRepository.findById(anyLong())).thenReturn(recurso);
        when(historicoTratamentoRecursoRepository.recuperarHistoricoRecurso(any(Recurso.class),any(Pageable.class))).thenReturn(consultaHistoricoRecursoDTO);
        assertEquals(service.consultarHistoricoRecurso(1L,1,1), consultaHistoricoRecursoDTO);
    }

    @Test
    public void gerarHistoricoTratamento(){
        when(usuarioLogadoUtil.getNome()).thenReturn("usuarioLogadoUtil");
        service.gerarHistoricoTratamento(recurso,1L);

    }

    @Test
    public void recuperarRespostaRecurso(){
        List<HistoricoTratamentoRecurso> listaHistoricoTratamentoRecurso = new ArrayList<>();
        listaHistoricoTratamentoRecurso.add(historicoTratamentoRecurso);
        when(historicoTratamentoRecursoRepository.recuperarRespostaHistoricoPorIdRecurso(anyLong())).thenReturn(listaHistoricoTratamentoRecurso);
        service.recuperarRespostaRecurso(1L);


    }

    @Test
    public void recuperarRespostaRecursoNull(){
        service.recuperarRespostaRecurso(1L);
    }

    @Test
    public void consultarDataRespostaRecurso(){
        List<HistoricoTratamentoRecurso> listaHistoricoTratamentoRecurso = new ArrayList<>();
        listaHistoricoTratamentoRecurso.add(historicoTratamentoRecurso);
        when(historicoTratamentoRecursoRepository.findAll()).thenReturn(listaHistoricoTratamentoRecurso);
        service.consultarDataRespostaRecurso(1L);
    }

    @Test
    public void consultarDataRespostaRecursoNull(){
        service.consultarDataRespostaRecurso(1L);
    }

}