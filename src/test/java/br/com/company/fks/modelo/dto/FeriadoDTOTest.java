package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FeriadoDTOTest {
    @InjectMocks
    private FeriadoDTO dto;

    @Mock
    private Calendar dataFeriado;

    @Test
    public void FeriadoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getDataFeriado();
        dto.setDataFeriado(dataFeriado);
        dto.getNome();
        dto.setNome("nome");
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getAno();
        dto.setAno(2019);
    }

}