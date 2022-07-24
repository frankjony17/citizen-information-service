package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevolveRecursoDTO {
    private Long idRecurso;
    private String justificativa;
    private String nomeStatusSolicitacao;
}
