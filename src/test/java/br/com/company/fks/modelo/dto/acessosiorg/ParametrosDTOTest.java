package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ParametrosDTOTest {

    @InjectMocks
    private ParametrosDTO dto;

    @Test
    public void ParametrosDTO(){
        List<Long> subunidade = new ArrayList<>();
        dto.getOrgao();
        dto.setOrgao(1L);
        dto.getUnidade();
        dto.setUnidade(1L);
        dto.getSubunidade();
        dto.setSubunidade(subunidade);
    }

}