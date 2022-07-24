package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalvarPerfilDTO {
    private Long id;
    private String nomePerfil;
    private String descricaoPerfil;
}
