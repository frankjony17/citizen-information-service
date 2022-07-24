package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiorgAcessoDTO {
    private String id;
    private String nome;
    private String sigla;
    private String siglaCompleta;
    private String cnpj;
    private Boolean ativo;
    private String tipoOrganizacao;
    private String administradores;
    private String codigoUg;
    private String tipoAdministracao;
    private Object endereco;
    private String ldapOu;
    private Boolean excluido;
    private Object origem;
    private Long tipoAdministracaoId;
    private Long poderId;
    private Long esferaId;
    private String strAtivo;
    private String textoPesquisa;
    private SiorgAcessoDTO organizacaoSuperior;
    private String jurisdicoes;
    private Long idOrganizacaoSuperior;
    private Long idGrupoUnidade;
    private Boolean semGrupoUnidade;
}
