package br.com.company.fks.command;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.DevolveRecursoDTO;

public interface IDevolveConsultaStausRecursoCommand {
    public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO);
}
