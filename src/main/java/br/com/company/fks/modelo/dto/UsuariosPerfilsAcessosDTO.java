package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosPerfilsAcessosDTO {
    private UsuarioDetalhadoDTO usuario;
    private PerfilDetalhadoDTO perfil;
}
