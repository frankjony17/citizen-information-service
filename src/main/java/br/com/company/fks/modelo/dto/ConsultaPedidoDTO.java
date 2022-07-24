package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ConsultaPedidoDTO {

    public ConsultaPedidoDTO(){}
    public ConsultaPedidoDTO(Long idPedido, String protocolo, String nomeSolicitante, String nomeTema, String nomeStatusTramitacao){
        this.setIdPedido(idPedido);
        this.setProtocolo(protocolo);
        this.setNomeSolicitante(nomeSolicitante);
        this.setNomeTema(nomeTema);
        this.setNomeStatusTramitacao(nomeStatusTramitacao);
    }
    private Long idPedido;
    private String protocolo;
    private String nomeSolicitante;
    private String nomeTema;
    private String nomeStatusTramitacao;
    private Calendar dataAbertura;
    private Calendar prazoVencimento;
    private Calendar prazoVencimentoESic;
    private Boolean isEouv;
    private String nomeStatusSolicitacao;
    private String codigoUnidade;
    private String codigoSubunidade;
    private boolean tecnicoResponsavel;
}
