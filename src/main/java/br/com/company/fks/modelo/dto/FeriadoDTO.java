package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class FeriadoDTO {
    private Long id;
    private Calendar dataFeriado;
    private String nome;
    private String descricao;
    private Integer ano;
}
