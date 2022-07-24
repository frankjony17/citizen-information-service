package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AtribuirUnidadeDTO {
    private OrgaoSiorgDTO orgao;
    private UnidadeDTO unidade;
    private UsuarioSiapeAcessoDTO usuario;
    private List<UnidadeSiorgDTO> subunidadeList;
}
