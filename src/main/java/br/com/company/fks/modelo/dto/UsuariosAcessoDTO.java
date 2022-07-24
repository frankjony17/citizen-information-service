package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UsuariosAcessoDTO {

    public UsuariosAcessoDTO(){}

    public UsuariosAcessoDTO(Long id, String cpf, String nome, String telefoneTrabalho, Boolean ativo){
        this.setId(id);
        this.setCpf(cpf);
        this.setNome(nome);
        this.setTelefoneTrabalho(telefoneTrabalho);
        this.setAtivo(ativo);
    }
    private  Long id;
    private String cpf;
    private String nome;
    private String email;
    private Boolean ativo;
    private String telefoneTrabalho;
    private String telefoneCelular;
    private Boolean existeAcessos;
    private List<PerfilAcessosDTO> perfil;
}
