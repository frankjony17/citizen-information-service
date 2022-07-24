package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.PalavraChave;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubtemaDTO {
    private Long idSubtemaDTO;
    @JsonFormat(shape=JsonFormat.Shape.ARRAY)
    private String nomeSubtema;
    private List<PalavraChave> palavrasChaves;
    private String nomeTema;
}
