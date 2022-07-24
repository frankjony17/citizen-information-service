package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SolicitanteDTOTest {
    @InjectMocks
    private SolicitanteDTO dto;

    @Test
    public void SolicitanteDTO(){
        dto.getIdSolicitante();
        dto.setIdSolicitante(1L);
        dto.getTipoPessoa();
        dto.setTipoPessoa("tipoPessoa");
        dto.getNome();
        dto.setNome("nome");
        dto.getCpfOuCnpj();
        dto.setCpfOuCnpj("cpfOuCnpj");
        dto.getDocumentoIdentificacao();
        dto.setDocumentoIdentificacao("documentoIdentificacao");
        dto.getSexo();
        dto.setSexo("sexo");
        dto.getProfissao();
        dto.setProfissao("profissao");
        dto.getEmail();
        dto.setEmail("email");
        dto.getDdd();
        dto.setDdd("ddd");
        dto.getTelefone();
        dto.setTelefone("telefone");
        dto.getEndereco();
        dto.setEndereco("endereco");
        dto.getUf();
        dto.setUf("uf");
        dto.getPais();
        dto.setPais("pais");
        dto.getCidade();
        dto.setCidade("cidade");
        dto.getCep();
        dto.setCep("cep");
    }

}