package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaClassificacaoRespostaDTO {
    private Long id;
    private Long idTipoClassificacaoResposta;
    private Integer offset;
    private String nomeClassificacao;
    private Integer limit;
}
