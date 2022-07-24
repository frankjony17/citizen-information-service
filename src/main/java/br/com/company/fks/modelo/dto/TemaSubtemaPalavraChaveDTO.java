package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.PalavraChave;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class TemaSubtemaPalavraChaveDTO {
    private TemaDTO tema;
    private List<SubtemaDTO> subtema;
    private List<PalavraChave> palavraChaveList;
}
