package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Categoria;
import br.com.company.fks.modelo.ClassificacaoTipoResposta;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.SubCategoria;
import br.com.company.fks.modelo.TipoResposta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassificarRespostaSicDTO {
    private Long id;
    private Categoria categoria;
    private SubCategoria subcategoria;
    private TipoResposta tipoResposta;
    private ClassificacaoTipoResposta classificacaoTipoResposta;
    private List<PalavraChave> palavrasChaves;
    private Long numeroPagina;
    private Boolean restricaoConteudo;
}
