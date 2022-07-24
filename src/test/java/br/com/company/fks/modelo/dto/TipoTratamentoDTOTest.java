package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TipoTratamentoDTOTest {
    @InjectMocks
    private TipoTratamentoDTO dto;

    @Test
    public void TipoTratamentoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getTipoTratamento();
        dto.setTipoTratamento("tipoTratamento");
    }

}