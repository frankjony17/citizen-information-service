package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ConsultaHistoricoPedidoDTO {
    private Long id;
    private Calendar data;
    private String nomeResponsavel;
    private String tipoTratamento;
    private Long idTipoTratamento;
    private String resposta;

    public ConsultaHistoricoPedidoDTO() {}

    public ConsultaHistoricoPedidoDTO(Long id, Calendar data, String nomeResponsavel, String tipoTratamento) {
        this.id = id;
        this.data = data;
        this.nomeResponsavel = nomeResponsavel;
        this.tipoTratamento = tipoTratamento;
    }
}
