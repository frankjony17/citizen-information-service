package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaUnidadeDTOTest {

    @InjectMocks
    private ConsultaUnidadeDTO dto;

    @Test
    public void ConsultaUnidadeDTO(){
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getIdSubunidade();
        dto.setIdSubunidade(1L);
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
        dto.getCodigoSubunidade();
        dto.setCodigoSubunidade("codigoSubunidade");
        dto.getNomeSubunidade();
        dto.setNomeSubunidade("nomeSubunidade");
    }

}