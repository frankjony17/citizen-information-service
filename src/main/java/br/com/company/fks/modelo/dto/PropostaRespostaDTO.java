package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PropostaRespostaDTO {
    private Long idPedido;
    private String observacao;
    private String nomeStatusSolicitacao;
    private Long idStatusSolicitacao;
    private String nomeStatusSolicitacaoPedido;
    private String propostaResposta;
    private List<Unidade> listaUnidade;
    private List<Subunidade> listaSubunidade;
    private List<UsuarioAcessos> listaUsuarioAcessos;
}
