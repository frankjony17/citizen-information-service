package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilDetalhadoDTO {
    private Long id;
    private String descricao;
    private String nome;
    private Boolean excluido;
}
