package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Unidade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDetalhadoDTOTest {
    @InjectMocks
    private UsuarioDetalhadoDTO dto;

    @Test
    public void UsuarioDetalhadoDTO(){
        Unidade unidade = new Unidade();
        OrgaoSiorg orgao = new OrgaoSiorg();
        dto.getId();
        dto.setId(1L);
        dto.getCpf();
        dto.setCpf("cpf");
        dto.getNome();
        dto.setNome("nome");
        dto.getPerfil();
        dto.setPerfil("perfil");
        dto.getEmail();
        dto.setEmail("email");
        dto.getConfirmacaoEmail();
        dto.setConfirmacaoEmail("confirmacaoEmail");
        dto.getCargo();
        dto.setCargo("cargo");
        dto.getTelefoneTrabalho();
        dto.setTelefoneTrabalho("telefoneTrabalho");
        dto.getTelefoneCelular();
        dto.setTelefoneCelular("telefoneCelular");
        dto.getAtivo();
        dto.setAtivo(true);
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getOrgao();
        dto.setOrgao(orgao);
    }

}