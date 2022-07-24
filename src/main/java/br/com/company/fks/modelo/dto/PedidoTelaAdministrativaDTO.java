package br.com.company.fks.modelo.dto;


import br.com.company.fks.modelo.Subtema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PedidoTelaAdministrativaDTO {
    private Long idPedido;
    private TemaDTO temaDTO;
    private List<Subtema> subtemas;
    private StatusSolicitacaoDTO statusSolicitacaoDTO;
    private StatusTramitacaoDTO statusTramitacaoDTO;
    private UnidadeDTO unidadeDTO;
    private SubunidadeTelaAdministrativaDTO subunidadeTelaAdministrativaDTO;
    private String nomeUsuario;
}
