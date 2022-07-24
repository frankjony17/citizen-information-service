package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroUsuarioAcessosDTO {
    private Integer offset;
    private Integer limit;
    private String nomeUsuario;
    private String perfilUsuario;

}
