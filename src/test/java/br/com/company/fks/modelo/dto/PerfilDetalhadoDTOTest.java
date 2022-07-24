package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PerfilDetalhadoDTOTest {
    @InjectMocks
    private PerfilDetalhadoDTO dto;

    @Test
    public void PerfilDetalhadoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getNome();
        dto.setNome("nome");
        dto.getExcluido();
        dto.setExcluido(true);
    }

}