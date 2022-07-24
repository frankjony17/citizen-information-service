package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OrgaoUnidadeSubunidadeDTOTest {

    @InjectMocks
    private OrgaoUnidadeSubunidadeDTO dto;

    @Test
    public void OrgaoUnidadeSubunidadeDTO(){
        List<UnidadeDTO> unidades = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getNomeOrgao();
        dto.setNomeOrgao("testeNomeOrgao");
        dto.getSiglaOrgao();
        dto.setSiglaOrgao("TesteSigla");
        dto.getUnidades();
        dto.setUnidades(unidades);
    }

}