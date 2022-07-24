package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlteracaoPedidoRecursoDTO {
    private Long idPedido;
    private Long idStatusSolicitacao;
    private String justificativa;
    private Boolean isPedido;
}
