package br.com.company.fks.modelo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class ProrrogacaoCadastroDTO {
    private Long idMotivoProrrogacao;
    private String justificativaProrrogacao;
    private Long idPedido;
    private Calendar novoVencimentoUnidade;
    private Calendar previsaoEsic;
    @JsonProperty("eSic")
    private boolean eSic;
}
