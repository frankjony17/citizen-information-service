package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Unidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDetalhadoDTO {
    private Long id;
    private String cpf;
    private String nome;
    private String perfil;
    private String email;
    private String confirmacaoEmail;
    private String cargo;
    private String telefoneTrabalho;
    private String telefoneCelular;
    private Boolean ativo;
    private Unidade unidade;
    private OrgaoSiorg orgao;
}
