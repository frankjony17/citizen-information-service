package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ConsultaFeriadoDTO {

    private Long id;

    private Integer offset;

    private Integer limit;

    private Calendar periodoInicialFeriado;

    private Calendar periodoFinalFeriado;

    private Integer ano;
}
