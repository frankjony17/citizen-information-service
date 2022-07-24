package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.UsuarioAcessos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PropostaRespostaRecursoDTO {
    private Long idRecurso;
    private String observacao;
    private Long idStatusSolicitacaoRecurso;
    private Long idUnidade;
    private String propostaResposta;
    private List<UsuarioAcessos> usuarioAcessosList;
}
