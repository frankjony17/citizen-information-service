package br.com.company.fks.modelo.dto.usuarioacesso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDadosDTOTest {

    @InjectMocks
    private UsuarioDadosDTO dto;

    @Test
    public void UsuarioDadosDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getEmail();
        dto.setEmail("email");
        dto.getTelefone();
        dto.setTelefone("telefone");
    }

}