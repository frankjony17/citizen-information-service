package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StatusSolicitacaoDTOTest {
    @InjectMocks
    private StatusSolicitacaoDTO dto;

    @Test
    public void StatusSolicitacaoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNome();
        dto.setNome("nome");
    }

}