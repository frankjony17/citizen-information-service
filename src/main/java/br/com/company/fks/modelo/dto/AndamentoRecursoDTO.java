package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class AndamentoRecursoDTO {
    private Long unidade;
    private Calendar dataInicio;
    private Calendar dataFim;
    private String responsavel;
    private String observacao;
    private String statusTramitacao;

    public AndamentoRecursoDTO(Long unidade, Calendar dataInicio, Calendar dataFim, String responsavel, String observacao, String statusTramitacao) {
        this.unidade = unidade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.responsavel = responsavel;
        this.observacao = observacao;
        this.statusTramitacao = statusTramitacao;
    }
}
