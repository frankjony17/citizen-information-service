package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ConsultaPedidoDulplicadoDTO {
    private Long idPedido;
    private String protocolo;
    private String nomeStatusSolicitacao;
    private Calendar dataVencimentoESic;

    public ConsultaPedidoDulplicadoDTO() {}

    public ConsultaPedidoDulplicadoDTO(Long idPedido, String protocolo, String nomeStatusSolicitacao, Calendar dataVencimentoESic) {
        this.protocolo = protocolo;
        this.nomeStatusSolicitacao = nomeStatusSolicitacao;
        this.dataVencimentoESic = dataVencimentoESic;
        this.idPedido = idPedido;
    }
}
