package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaUsuarioDTOTest {
    @InjectMocks
    private ConsultaUsuarioDTO dto;

    @Test
    public void ConsultaUsuarioDTO(){
        dto.getCodigoUsuario();
        dto.setCodigoUsuario("codigoUsuario");
        dto.getIdUsuario();
        dto.setIdUsuario(1L);
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
        dto.getEmailUsuario();
        dto.setEmailUsuario("emailUsuario");
        dto.getPerfilUsuario();
        dto.setPerfilUsuario("perfilUsuario");
        dto.getTelefoneUsuario();
        dto.setTelefoneUsuario("telefoneUsuario");
        dto.getNomeSubunidade();
        dto.setNomeSubunidade("nomeSubunidade");
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
    }


}