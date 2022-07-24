package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class AndamentoDTO {
    private Long idStatusTramitacao;
    private Long idUnidade;
    private Calendar dataInicio;
    private Calendar dataFim;
    private String nomeResponsavel;
    private String observacao;
}
