package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuariosAcessoDTOTest {
    @InjectMocks
    private UsuariosAcessoDTO dto;

    @Test
    public void UsuariosAcessoDTO(){
        List<PerfilAcessosDTO> perfil = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getCpf();
        dto.setCpf("cpf");
        dto.getNome();
        dto.setNome("nome");
        dto.getEmail();
        dto.setEmail("email");
        dto.getAtivo();
        dto.setAtivo(true);
        dto.getTelefoneTrabalho();
        dto.setTelefoneTrabalho("telefoneTrabalho");
        dto.getTelefoneCelular();
        dto.setTelefoneCelular("telefoneCelular");
        dto.getExisteAcessos();
        dto.setExisteAcessos(true);
        dto.getPerfil();
        dto.setPerfil(perfil);
        dto.getClass();
    }

}