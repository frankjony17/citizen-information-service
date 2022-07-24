package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoriaDTO {
    private Long id;
    private String descricao;
    private Categoria categoria;
}
