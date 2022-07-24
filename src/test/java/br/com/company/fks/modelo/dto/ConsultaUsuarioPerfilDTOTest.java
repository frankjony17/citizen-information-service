package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaUsuarioPerfilDTOTest {
    @InjectMocks
    private ConsultaUsuarioPerfilDTO dto;

    @Test
    public void ConsultaUsuarioPerfilDTO(){
        List<PerfilAcessosDTO> perfil = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getNome();
        dto.setNome("nome");
        dto.getEmail();
        dto.setEmail("email");
        dto.getPerfil();
        dto.setPerfil(perfil);
        dto.getTelefoneUsuario();
        dto.setTelefoneUsuario("telefoneUsuario");
        dto.getInexistenteNoAcesso();
        dto.setInexistenteNoAcesso(true);
    }

}