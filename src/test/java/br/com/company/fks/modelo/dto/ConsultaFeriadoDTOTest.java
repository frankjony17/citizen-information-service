package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaFeriadoDTOTest {

    @InjectMocks
    private ConsultaFeriadoDTO dto;

    @Mock
    private Calendar periodoInicialFeriado;

    @Mock
    private Calendar periodoFinalFeriado;

    @Test
    public void ConsultaFeriadoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getOffset();
        dto.setOffset(1);
        dto.getLimit();
        dto.setLimit(1);
        dto.getPeriodoInicialFeriado();
        dto.setPeriodoInicialFeriado(periodoInicialFeriado);
        dto.getPeriodoFinalFeriado();
        dto.setPeriodoFinalFeriado(periodoFinalFeriado);
        dto.getAno();
        dto.setAno(2019);
    }
}