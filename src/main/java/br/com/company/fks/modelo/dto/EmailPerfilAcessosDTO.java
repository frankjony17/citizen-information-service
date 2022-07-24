package br.com.company.fks.modelo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailPerfilAcessosDTO {
    private Long id;
    private Integer tipoSolicitacao;
    private EmailDTO email;
    private PerfilDTO perfil;
}
