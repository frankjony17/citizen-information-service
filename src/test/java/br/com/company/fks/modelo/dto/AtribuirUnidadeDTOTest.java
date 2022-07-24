package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AtribuirUnidadeDTOTest {

    @InjectMocks
    private AtribuirUnidadeDTO dto;

    @Test
    public void AtribuirUnidadeDTO(){
        OrgaoSiorgDTO orgao = new OrgaoSiorgDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        UsuarioSiapeAcessoDTO usuario = new UsuarioSiapeAcessoDTO();
        List<UnidadeSiorgDTO> subunidadeList = new ArrayList<>();
        dto.getOrgao();
        dto.setOrgao(orgao);
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getUsuario();
        dto.setUsuario(usuario);
        dto.getSubunidadeList();
        dto.setSubunidadeList(subunidadeList);
    }

}