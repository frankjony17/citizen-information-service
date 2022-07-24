package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadeDTOTest {

    @InjectMocks
    private UnidadeDTO dto;

    @Test
    public void UnidadeDTO(){
        List<SubunidadeDTO> subunidade = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getCodigoUnidade();
        dto.setCodigoUnidade("codigoUnidade");
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
        dto.getSiglaUnidade();
        dto.setSiglaUnidade("siglaUnidade");
        dto.getStatusUnidade();
        dto.setStatusUnidade(true);
        dto.getSubunidade();
        dto.setSubunidade(subunidade);
    }

}