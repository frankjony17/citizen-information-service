package br.com.company.fks.repositorio.base;

import java.io.Serializable;

public abstract class RepositorioGenerico<T, I extends Serializable> extends RepositorioBase {

    protected abstract Class<T> getEntityClass();

}
