package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiltroUsuarioAcessosDTOTest {
    @InjectMocks
    private FiltroUsuarioAcessosDTO dto;

    @Test
    public void FiltroUsuarioAcessosDTO(){
        dto.getOffset();
        dto.setOffset(1);
        dto.getLimit();
        dto.setLimit(1);
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
        dto.getPerfilUsuario();
        dto.setPerfilUsuario("perfilUsuario");
    }

}