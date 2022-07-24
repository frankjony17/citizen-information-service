package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PerfilAcessosDTOTest {
    @InjectMocks
    private PerfilAcessosDTO dto;

    @Test
    public void PerfilAcessosDTO(){
        PerfilDTO perfil = new PerfilDTO();
        dto.getPerfil();
        dto.setPerfil(perfil);
    }

}