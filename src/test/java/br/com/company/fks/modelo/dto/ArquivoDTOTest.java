package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ArquivoDTOTest {

    @InjectMocks
    private ArquivoDTO dto;

    @Test
    public void ArquivoDTO(){
        dto.getNome();
        dto.setNome("nome");
        dto.getCaminho();
        dto.setCaminho("caminho");
        dto.getTamanho();
        dto.setTamanho(1L);
    }

}