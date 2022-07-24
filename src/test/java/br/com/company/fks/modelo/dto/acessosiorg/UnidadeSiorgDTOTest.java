package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadeSiorgDTOTest {

    @InjectMocks
    private UnidadeSiorgDTO dto;

    @Test
    public void UnidadeSiorgDTO(){
        dto.getId();
        dto.setId("id");
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
        dto.getCodigoUnidade();
        dto.setCodigoUnidade("codigoUnidade");
        dto.getSiglaUnidade();
        dto.setSiglaUnidade("siglaUnidade");
        dto.getCodigoUnidadePai();
        dto.setCodigoUnidadePai("codigoUnidadePai");
        dto.getCodigoTipoUnidade();
        dto.setCodigoTipoUnidade("codigoTipoUnidade");
    }

}