package br.com.company.fks.modelo.dto.usuarioacesso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class PerfilAcessoDTOTest {

    @InjectMocks
    private PerfilAcessoDTO dto;

    @Test
    public void PerfilAcessoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNome();
        dto.setNome("nome");
        dto.getIsAtivo();
        dto.setIsAtivo(true);
    }

}