package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SalvarPerfilDTOTest {
    @InjectMocks
    private SalvarPerfilDTO dto;

    @Test
    public void SalvarPerfilDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNomePerfil();
        dto.setNomePerfil("nomePerfil");
        dto.getDescricaoPerfil();
        dto.setDescricaoPerfil("descricaoPerfil");
    }

}