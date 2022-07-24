package br.com.company.fks.repositorio.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositorioBase {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
