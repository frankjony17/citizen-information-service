package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.UsuarioAcessos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioAcessosDTOTest {
    @InjectMocks
    private UsuarioAcessosDTO dto;

    @Test
    public void UsuarioAcessosDTO(){
        UsuarioAcessos usuario = new UsuarioAcessos();
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
        dto.getIdSubunidade();
        dto.setIdSubunidade(1L);
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getUsuario();
        dto.setUsuario(usuario);

    }

}