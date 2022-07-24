package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.ClassificacaoResposta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespostaClassificadaDTO {
    private Long id;
    private List<ClassificacaoResposta> listaClassificacaoResposta;
}
