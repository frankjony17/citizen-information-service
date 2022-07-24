package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Tema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GlossarioDeTemaDTO {
    private Long id;
    private String nomeSubtema;
    private List<PalavraChave> palavrasChaves = new ArrayList<>();
    private Tema tema;
}
