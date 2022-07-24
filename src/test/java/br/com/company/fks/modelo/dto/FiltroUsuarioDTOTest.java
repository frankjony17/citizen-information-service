package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiltroUsuarioDTOTest {

    @InjectMocks
    private FiltroUsuarioDTO dto;

    @Test
    public void FiltroUsuarioDTO(){
        dto.getOffset();
        dto.setOffset(1);
        dto.getLimit();
        dto.setLimit(1);
        dto.getCodigoUsuario();
        dto.setCodigoUsuario("codigoUsuario");
        dto.getPerfilUsuario();
        dto.setPerfilUsuario("perfilUsuario");
        dto.getNomePerfil();
        dto.setNomePerfil("nomePerfil");
        dto.getIdPerfil();
        dto.setIdPerfil(1L);
        dto.getIdUsuario();
        dto.setIdUsuario(1L);
        dto.getCpfUsuario();
        dto.setCpfUsuario("cpfUsuario");
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
        dto.getNomeSubunidade();
        dto.setNomeSubunidade("nomeSubunidade");
    }

}