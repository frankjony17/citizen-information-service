package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubunidadeDTOTest {
    @InjectMocks
    private SubunidadeDTO dto;

    @Test
    public void SubunidadeDTO(){
        dto.getCodigoUg();
        dto.setCodigoUg("codigoUg");
        dto.getNome();
        dto.setNome("nome");
        dto.getSigla();
        dto.setSigla("sigla");
    }

}