package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosPerfilsAcessosDTOTest {
    @InjectMocks
    private UsuariosPerfilsAcessosDTO dto;

    @Test
    public void UsuariosPerfilsAcessosDTO(){
        UsuarioDetalhadoDTO usuario = new UsuarioDetalhadoDTO();
        PerfilDetalhadoDTO perfil = new PerfilDetalhadoDTO();
        dto.getUsuario();
        dto.setUsuario(usuario);
        dto.getPerfil();
        dto.setPerfil(perfil);
    }

}