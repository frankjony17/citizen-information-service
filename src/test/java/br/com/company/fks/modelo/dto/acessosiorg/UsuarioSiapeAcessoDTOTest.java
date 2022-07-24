package br.com.company.fks.modelo.dto.acessosiorg;

import org.apache.xpath.operations.String;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioSiapeAcessoDTOTest {

    @InjectMocks
    private UsuarioSiapeAcessoDTO dto;

    @Test
    public void UsuarioSiapeAcessoDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getCpf();
        dto.setCpf("cpf");
        dto.getNome();
        dto.setNome("nome");
        dto.getAtivo();
        dto.setAtivo("ativo");
        dto.getEmail();
        dto.setEmail("email");
        dto.getTelefoneTrabalho();
        dto.setTelefoneTrabalho("telefoneTrabalho");
        dto.getTelefoneCelular();
        dto.setTelefoneCelular("telefoneCelular");
        dto.getTelefone();
        dto.getCargo();
        dto.setCargo("cargo");
        dto.getAssinatura();
        dto.setAssinatura("assinatura");
        dto.getFuncao();
        dto.setFuncao("funcao");
        dto.getPerfil();
        dto.setPerfil("perfil");
    }

    @Test
    public void pushTelefone(){dto.pushTelefone("telefone");    }

}