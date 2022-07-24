package br.com.company.fks.modelo.dto.usuarioacesso;

import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioParametrosDTOTest {

    @InjectMocks
    private UsuarioParametrosDTO dto;

    @Test
    public void UsuarioParametrosDTO(){
        UsuarioAcessos usuario = new UsuarioAcessos();
        Unidade unidade = new Unidade();
        List<SubunidadeDTO> subunidades = new ArrayList<>();
        dto.getCpf();
        dto.setCpf("cpf");
        dto.getNomePerfil();
        dto.setNomePerfil("nomePerfil");
        dto.getUsuario();
        dto.setUsuario(usuario);
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getSubunidades();
        dto.setSubunidades(subunidades);
    }

}