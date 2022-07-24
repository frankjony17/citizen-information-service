package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.TipoResposta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassificacaoTipoRespostaDTO {
    private Long id;
    private String descricao;
    private TipoResposta tipoResposta;
}
