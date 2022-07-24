package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllPerfilDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Boolean excluido;
}
