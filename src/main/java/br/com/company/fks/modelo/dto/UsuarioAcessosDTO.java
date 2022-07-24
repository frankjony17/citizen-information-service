package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.UsuarioAcessos;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioAcessosDTO {
    private String nomeUsuario;
    private UsuarioAcessos usuario;
    private Long idSubunidade;
    private Long idUnidade;
}
