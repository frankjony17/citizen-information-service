package br.com.company.fks.command;

import br.com.company.fks.modelo.TipoRecurso;

public interface IImportacaoRecursoServiceCommand {

    public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso);
}
