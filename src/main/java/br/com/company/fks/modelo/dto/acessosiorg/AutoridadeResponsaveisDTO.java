package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoridadeResponsaveisDTO {
    private UsuarioSiapeAcessoDTO usuarioAutoridadeHierarquica;
    private UsuarioSiapeAcessoDTO usuarioAutoridadeMaxima;
    private ResponsaveisDTO responsavelRecurso;
}
