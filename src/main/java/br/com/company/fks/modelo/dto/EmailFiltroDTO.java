package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EmailFiltroDTO {
    private Integer limit;
    private Integer offset;
    private Integer tipoSolicitacao;
    private Integer tipoAlerta;
    private String assuntoEmail;
    private List<PerfilDTO> destinatarios;
}
