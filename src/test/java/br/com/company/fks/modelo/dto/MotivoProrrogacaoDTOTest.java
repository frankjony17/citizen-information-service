package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MotivoProrrogacaoDTOTest {
    @InjectMocks
    private MotivoProrrogacaoDTO dto;

    @Test
    public void MotivoProrrogacaoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNome();
        dto.setNome("nome");
    }

}