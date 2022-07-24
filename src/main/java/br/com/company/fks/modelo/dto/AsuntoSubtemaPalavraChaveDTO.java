package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AsuntoSubtemaPalavraChaveDTO {
    private TemaDTO tema;
    private List<SubtemaDTO> subtema;
}
