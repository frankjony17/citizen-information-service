package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AndamentoDTOTest {

    @InjectMocks
    private AndamentoDTO dto;

    @Mock
    private Calendar dataInicio;

    @Mock
    private Calendar dataFim;

    @Test
    public void AndamentoDTO(){
        dto.getIdStatusTramitacao();
        dto.setIdStatusTramitacao(1L);
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getNomeResponsavel();
        dto.setNomeResponsavel("nomeResponsavel");
        dto.getObservacao();
        dto.setObservacao("observacao");
        dto.getDataInicio();
        dto.setDataInicio(dataInicio);
        dto.getDataFim();
        dto.setDataFim(dataFim);
    }

}