package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PalavraChaveDTOTest {
    @InjectMocks
    private PalavraChaveDTO dto;

    @Test
    public void PalavraChaveDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getDescricao();
        dto.setDescricao("descricao");
    }

}