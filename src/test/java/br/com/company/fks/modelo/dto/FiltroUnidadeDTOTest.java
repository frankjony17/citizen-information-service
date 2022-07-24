package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiltroUnidadeDTOTest {
    @InjectMocks
    private FiltroUnidadeDTO dto;

    @Test
    public void FiltroUnidadeDTO(){
        dto.getOffset();
        dto.setOffset(1);
        dto.getLimit();
        dto.setLimit(1);
        dto.getUnidadeId();
        dto.setUnidadeId(1L);
        dto.getSubunidade();
        dto.setSubunidade(Arrays.asList(new SubunidadeDTO()));
    }

}