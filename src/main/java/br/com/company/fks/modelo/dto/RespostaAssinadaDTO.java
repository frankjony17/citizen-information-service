package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaAssinadaDTO {
    private Long idStatusSolicitacao;
    private String observacao;
    private String nomeStatusSolicitacao;
    private String propostaResposta;
    private Long idPedido;
    private String nomeStatusSolicitacaoPedido;
    private Unidade unidade;
    private Subunidade subunidade;
}
