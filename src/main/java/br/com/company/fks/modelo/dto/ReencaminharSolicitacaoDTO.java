package br.com.company.fks.modelo.dto;


import br.com.company.fks.modelo.Orgao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReencaminharSolicitacaoDTO {
    private Long id;
    private Orgao orgao;
    private String notificacaoEnviadaSolicitante;
    private String notificacaoEnviadaDestinatario;
    private Long idPedido;
}
