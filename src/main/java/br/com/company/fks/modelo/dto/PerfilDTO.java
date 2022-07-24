package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PerfilDTO {

    public PerfilDTO(){}
    public PerfilDTO(Long id, String nome, String descricao, Unidade unidade, boolean ativo){
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setUnidade(unidade);
        this.setAtivo(ativo);
    }
    private Long id;
    private String nome;
    private String descricao;
    private Unidade unidade;
    private List<Subunidade> subunidades;
    private Boolean excluido;
    private Boolean existeAcessos;
    private Boolean ativo;
}
