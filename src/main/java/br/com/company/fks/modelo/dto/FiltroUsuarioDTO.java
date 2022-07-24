package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class FiltroUsuarioDTO {
    private Integer offset;
    private Integer limit;
    private String codigoUsuario;
    private String perfilUsuario;
    private String nomePerfil;
    private Long idPerfil;
    private Long idUsuario;
    private String idsSubunidade;
    private Long idUnidade;
    private String cpfUsuario;
    private String nomeUnidade;
    private String nomeSubunidade;
    private Calendar dataQuery;
    private String statusUsuario;
}
