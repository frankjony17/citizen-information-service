package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalvarUsuarioDTO {
    private Long id;
    private String nomeUsuario;
    private String assinaturaUsuario;
    private String cargoUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    private String funcaoUsuario;
    private String telefoneUsuario;
}
