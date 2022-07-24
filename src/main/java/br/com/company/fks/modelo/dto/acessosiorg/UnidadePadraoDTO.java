package br.com.company.fks.modelo.dto.acessosiorg;

import br.com.company.fks.modelo.dto.SalvarPerfilDTO;
import br.com.company.fks.modelo.dto.SalvarUsuarioDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UnidadePadraoDTO {
    private OrgaoSiorgDTO orgao;
    private UnidadeDTO unidade;
    private UsuarioSiapeAcessoDTO substitutoAutoridadeHierarquica;
    private UsuarioSiapeAcessoDTO substitutoAutoridadeMaxima;
    private UsuarioSiapeAcessoDTO usuarioAutoridadeHierarquica;
    private UsuarioSiapeAcessoDTO usuarioAutoridadeMaxima;
    private List<UsuarioSiapeAcessoDTO> usuarioAutoridadeHierarquicaList;
    private List<UsuarioSiapeAcessoDTO> usuarioAutoridadeMaximaList;
    private ResponsaveisDTO responsavelRecurso;
    private List<UnidadeSiorgDTO> subunidadeList;
    private SalvarUsuarioDTO salvarUsuarioDTO;
    private SalvarPerfilDTO salvarPerfilDTO;
    private Boolean usuarioAtivo;
}
