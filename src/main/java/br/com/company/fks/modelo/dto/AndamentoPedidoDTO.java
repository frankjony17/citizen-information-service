package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Unidade;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class AndamentoPedidoDTO {
    private Calendar dataInicio;
    private Calendar dataFim;
    private String observacao;
    private String responsavel;
    private String statusTramitacao;
    private String statusSolicitacao;
    private Unidade unidade;

    public AndamentoPedidoDTO(Calendar dataInicio, Calendar dataFim, String responsavel, String observacao, String statusTramitacao, String statusSolicitacao) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.responsavel = responsavel;
        this.observacao = observacao;
        this.statusTramitacao = statusTramitacao;
        this.statusSolicitacao = statusSolicitacao;
    }
}
