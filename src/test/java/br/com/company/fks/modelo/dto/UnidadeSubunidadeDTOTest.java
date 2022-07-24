package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadeSubunidadeDTOTest {
    @InjectMocks
    private UnidadeSubunidadeDTO dto;

    @Test
    public void UnidadeSubunidadeDTO(){
        List<SubunidadeDTO> subunidade = new ArrayList<>();
        dto.getNome();
        dto.setNome("nome");
        dto.getCodigoUg();
        dto.setCodigoUg("codigoUg");
        dto.getSiglaUnidade();
        dto.setSiglaUnidade("siglaUnidade");
        dto.getSubunidade();
        dto.setSubunidade(subunidade);
    }
}