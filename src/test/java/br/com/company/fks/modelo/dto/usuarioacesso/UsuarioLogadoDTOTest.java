package br.com.company.fks.modelo.dto.usuarioacesso;

import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioLogadoDTOTest {

    @InjectMocks
    private UsuarioLogadoDTO dto;

    @Test
    public void UsuarioLogadoDTO(){
        UnidadeDTO unidade = new UnidadeDTO();
        List<SubunidadeDTO> subunidade = new ArrayList<>();
        List<PerfilAcessoDTO> perfis = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getCpf();
        dto.setCpf("cpf");
        dto.getNome();
        dto.setNome("nome");
        dto.getEmail();
        dto.setEmail("email");
        dto.getTelefone();
        dto.setTelefone("telefone");
        dto.getCargo();
        dto.setCargo("cargo");
        dto.getFuncao();
        dto.setFuncao("funcao");
        dto.getAssinatura();
        dto.setAssinatura("assinatura");
        dto.getAutoridadeHierarquica();
        dto.setAutoridadeHierarquica("autoridadeHierarquica");
        dto.getAutoridadeMaxima();
        dto.setAutoridadeMaxima("autoridadeMaxima");
        dto.getResponsavelTercera();
        dto.setResponsavelTercera("responsavelTercera");
        dto.getResponsavelQuarta();
        dto.setResponsavelQuarta("responsavelQuarta");
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getSubunidade();
        dto.setSubunidade(subunidade);
        dto.getPerfis();
        dto.setPerfis(perfis);
    }

}