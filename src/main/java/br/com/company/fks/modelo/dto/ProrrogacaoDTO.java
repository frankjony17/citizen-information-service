package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ProrrogacaoDTO {
    private String justificativaProrrogacao;
    private String nomeMotivoProrrogacao;
    private Calendar novoVencimentoUnidade;
}
