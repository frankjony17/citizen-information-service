package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailPerfilAcessosDTOTest {
    @InjectMocks
    private EmailPerfilAcessosDTO dto;

    @Test
    public void EmailPerfilAcessosDTO(){
        EmailDTO email = new EmailDTO();
        PerfilDTO perfil = new PerfilDTO();
        dto.getId();
        dto.setId(1L);
        dto.getTipoSolicitacao();
        dto.setTipoSolicitacao(1);
        dto.getEmail();
        dto.setEmail(email);
        dto.getPerfil();
        dto.setPerfil(perfil);
    }

}