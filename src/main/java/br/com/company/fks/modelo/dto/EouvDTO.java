package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Categoria;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.SubCategoria;
import br.com.company.fks.modelo.TipoManifestacao;
import br.com.company.fks.modelo.TipoTratamento;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EouvDTO {
    private Long id;
    private Long idPedido;
    private TipoTratamento tipoTratamento;
    private TipoManifestacao tipoManifestacao;
    private Categoria categoria;
    private SubCategoria subcategoria;
    private List<PalavraChave> palavraChave;
    private Boolean assinou;
    private Boolean restricaoConteudo;
}
