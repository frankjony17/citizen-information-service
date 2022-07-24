package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class AndamentoRecursoDTOTest {

    @InjectMocks
    private AndamentoRecursoDTO andamentoRecursoDTO;

    @Mock
    private Calendar dataInicio;

    @Mock
    private Calendar dataFim;

    @Test
    public void getUnidade() {
        andamentoRecursoDTO.getUnidade();
    }

    @Test
    public void getDataInicio() {
        andamentoRecursoDTO.getDataInicio();
    }

    @Test
    public void getDataFim() {
        andamentoRecursoDTO.getDataFim();
    }

    @Test
    public void getResponsavel() {
        andamentoRecursoDTO.getResponsavel();
    }

    @Test
    public void getObservacao() {
        andamentoRecursoDTO.getObservacao();
    }

    @Test
    public void getStatusTramitacao() {
        andamentoRecursoDTO.getStatusTramitacao();
    }

    @Test
    public void setUnidade() {
        andamentoRecursoDTO.setUnidade(1L);
    }

    @Test
    public void setDataInicio() {
        andamentoRecursoDTO.setDataInicio(dataInicio);
    }

    @Test
    public void setDataFim() {
        andamentoRecursoDTO.setDataFim(dataFim);
    }

    @Test
    public void setResponsavel() {
        andamentoRecursoDTO.setResponsavel("responsavel");
    }

    @Test
    public void setObservacao() {
        andamentoRecursoDTO.setObservacao("observacao");
    }

    @Test
    public void setStatusTramitacao() {
        andamentoRecursoDTO.setStatusTramitacao("statusTramitacao");
    }
}