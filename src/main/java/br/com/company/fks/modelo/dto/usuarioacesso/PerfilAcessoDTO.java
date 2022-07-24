package br.com.company.fks.modelo.dto.usuarioacesso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilAcessoDTO {
    private Long id;
    private String nome;
    private Boolean isAtivo;
}
