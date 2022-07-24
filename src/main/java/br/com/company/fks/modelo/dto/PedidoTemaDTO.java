package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.PalavraChave;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PedidoTemaDTO {
    private Long idPedido;
    private Long idTema;
    private List<SubtemaDTO> subtemaDTO;
    private List<PalavraChave> palavrasChaves;
}
