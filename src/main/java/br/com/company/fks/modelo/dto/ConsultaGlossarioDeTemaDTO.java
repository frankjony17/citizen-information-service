package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaGlossarioDeTemaDTO {
    private Long id;
    private String nomeSubtema;
    private Long idPalavraChave;
    private Long idTema;
    private Integer offset;
    private Integer limit;
}
