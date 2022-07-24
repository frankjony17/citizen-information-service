package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.TipoClassificacaoResposta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassificacaoRespostaDTO {
    private Long id;
    private String descricao;
    private TipoClassificacaoResposta tipoClassificacaoResposta;
    private Boolean statusClassificacaoResposta;
}
