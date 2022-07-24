package br.com.company.fks.command;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;

public interface IDevolveRecursoCommand {
    public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso);
}
