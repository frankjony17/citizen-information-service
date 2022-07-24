package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaUsuarioDTO {
    private String codigoUsuario;
    private Long idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String perfilUsuario;
    private String telefoneUsuario;
    private String nomeSubunidade;
    private String nomeUnidade;
}
