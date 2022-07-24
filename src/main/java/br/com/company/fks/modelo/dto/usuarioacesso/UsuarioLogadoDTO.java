package br.com.company.fks.modelo.dto.usuarioacesso;


import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UsuarioLogadoDTO {
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private String funcao;
    private String assinatura;
    private String autoridadeHierarquica;
    private String autoridadeMaxima;
    private String responsavelTercera;
    private String responsavelQuarta;
    private UnidadeDTO unidade;
    private List<SubunidadeDTO> subunidade;
    private List<PerfilAcessoDTO> perfis;
}
