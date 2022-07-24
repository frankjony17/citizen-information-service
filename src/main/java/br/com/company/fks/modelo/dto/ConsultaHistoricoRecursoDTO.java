package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ConsultaHistoricoRecursoDTO {
    private Long id;
    private String nomeResponsavel;
    private String tipoTratamentoRecurso;
    private Calendar data;

    public ConsultaHistoricoRecursoDTO(Long id, Calendar data, String nomeResponsavel, String tipoTratamentoRecurso) {
        this.id = id;
        this.data = data;
        this.nomeResponsavel = nomeResponsavel;
        this.tipoTratamentoRecurso = tipoTratamentoRecurso;
    }
}
