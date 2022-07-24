package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SalvarUsuarioDTOTest {
    @InjectMocks
    private SalvarUsuarioDTO dto;

    @Test
    public void SalvarUsuarioDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
        dto.getAssinaturaUsuario();
        dto.setAssinaturaUsuario("assinaturaUsuario");
        dto.getCargoUsuario();
        dto.setCargoUsuario("cargoUsuario");
        dto.getCpfUsuario();
        dto.setCpfUsuario("cpfUsuario");
        dto.getEmailUsuario();
        dto.setEmailUsuario("emailUsuario");
        dto.getFuncaoUsuario();
        dto.setFuncaoUsuario("funcaoUsuario");
        dto.getTelefoneUsuario();
        dto.setTelefoneUsuario("telefoneUsuario");
    }

}