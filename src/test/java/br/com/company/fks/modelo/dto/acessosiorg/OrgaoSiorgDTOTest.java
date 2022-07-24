package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OrgaoSiorgDTOTest {

    @InjectMocks
    private OrgaoSiorgDTO dto;

    @Test
    public void OrgaoSiorgDTO(){
        dto.getCodigoUnidade();
        dto.setCodigoUnidade("testeCod");
        dto.getId();
        dto.setId(1L);
        dto.getNomeUnidade();
        dto.setNomeUnidade("testeNome");
        dto.getSiglaUnidade();
        dto.setSiglaUnidade("testeSig");
        dto.getStatusUnidade();
        dto.setStatusUnidade(true);

    }

}