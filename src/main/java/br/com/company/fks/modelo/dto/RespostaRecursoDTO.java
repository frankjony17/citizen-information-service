package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaRecursoDTO {
    private String observacao;
    private Long idRecurso;
    private String nomeStatusSolicitacao;
    private Long idStatusSolicitacao;
    private String propostaResposta;
}
