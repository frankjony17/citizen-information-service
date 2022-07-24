package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;

public class UsuarioSiapeAcessoDTO {
    @Getter
    @Setter
    private  Long id;
    @Getter
    @Setter
    private String cpf;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String ativo;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String telefoneTrabalho;
    @Getter
    @Setter
    private String telefoneCelular;
    @Getter
    private String telefone;
    @Getter
    @Setter
    private String cargo;
    @Getter
    @Setter
    private String assinatura;
    @Getter
    @Setter
    private String funcao;
    @Getter
    @Setter
    private String perfil;

    public void pushTelefone (String telefone) {
        this.telefone = telefone;
    }
}
