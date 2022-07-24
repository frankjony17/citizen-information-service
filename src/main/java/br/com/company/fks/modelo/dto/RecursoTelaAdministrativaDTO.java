package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecursoTelaAdministrativaDTO {
    private Long idRecurso;
    private StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO;
    private StatusTramitacaoRecursoDTO statusTramitacaoRecursoDTO;
    private UnidadeDTO unidadeDTO;
    private SubunidadeTelaAdministrativaDTO subunidadeTelaAdministrativaDTO;
    private String nomeUsuario;
}
