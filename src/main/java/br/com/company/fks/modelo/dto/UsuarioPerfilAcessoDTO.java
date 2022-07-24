package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioPerfilAcessoDTO {
    private Long id;
    private String nome;
    private String perfil;
    private String cpf;
    private String email;
    private String cargo;
    private String funcao;
    private String telefone;
    private String assinatura;
    private OrgaoSiorgDTO orgao;
    private List<br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO> subunidades;
    private List<SubunidadeDTO> unidadeSubunidades;
    private UnidadeDTO unidade;
    private String autoridadeHier;
    private String autoridadeMaxi;
    private String responsavelRecurso3;
    private String responsavelRecurso4;
}
