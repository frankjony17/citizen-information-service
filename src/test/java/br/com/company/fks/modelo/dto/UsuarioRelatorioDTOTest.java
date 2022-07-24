package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioRelatorioDTOTest {
    @InjectMocks
    private UsuarioRelatorioDTO dto;

    @Test
    public void UsuarioRelatorioDTO(){
        dto.getTelefoneUsuario();
        dto.setTelefoneUsuario("telefoneUsuario");
        dto.getPerfilUsuario();
        dto.setPerfilUsuario("perfilUsuario");
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
        dto.getEmailUsuario();
        dto.setEmailUsuario("emailUsuario");
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
        dto.getNomeSubunidade();
        dto.setNomeSubunidade("nomeSubunidade");
    }

}