package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitanteDTO {
    private Long idSolicitante;
    private String tipoPessoa;
    private String nome;
    private String cpfOuCnpj;
    private String documentoIdentificacao;
    private String sexo;
    private String profissao;
    private String email;
    private String ddd;
    private String telefone;
    private String endereco;
    private String uf;
    private String pais;
    private String cidade;
    private String cep;
}
