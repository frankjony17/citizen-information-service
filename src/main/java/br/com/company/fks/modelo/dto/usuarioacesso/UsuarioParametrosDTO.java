package br.com.company.fks.modelo.dto.usuarioacesso;

import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioParametrosDTO {
    private String cpf;
    private String nomePerfil;
    private UsuarioAcessos usuario;
    private Unidade unidade;
    private List<SubunidadeDTO> subunidades;
    private String assinaturaUsuario;
}
