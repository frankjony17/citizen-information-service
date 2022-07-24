package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioPerfilAcessoDTOTest {
    @InjectMocks
    private UsuarioPerfilAcessoDTO dto;

    @Test
    public void UsuarioPerfilAcessoDTO(){
        OrgaoSiorgDTO orgaoSiorgDTO = new OrgaoSiorgDTO();
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        dto.getId();
        dto.setId(1L);
        dto.getNome();
        dto.setNome("nome");
        dto.getPerfil();
        dto.setPerfil("perfil");
        dto.getCpf();
        dto.setCpf("cpf");
        dto.getEmail();
        dto.setEmail("email");
        dto.getCargo();
        dto.setCargo("cargo");
        dto.getFuncao();
        dto.setFuncao("funcao");
        dto.getTelefone();
        dto.setTelefone("telefone");
        dto.getAssinatura();
        dto.setAssinatura("assinatura");
        dto.getOrgao();
        dto.setOrgao(orgaoSiorgDTO);
        dto.getSubunidades();
        dto.setSubunidades(subunidadeDTOList);
        dto.getUnidade();
        dto.setUnidade(unidadeDTO);
        dto.getAutoridadeHier();
        dto.setAutoridadeHier("autoridadeHier");
        dto.getAutoridadeMaxi();
        dto.setAutoridadeMaxi("autoridadeMaxi");
        dto.getResponsavelRecurso3();
        dto.setResponsavelRecurso3("responsavelRecurso3");
        dto.getResponsavelRecurso4();
        dto.setResponsavelRecurso4("responsavelRecurso4");
    }
}