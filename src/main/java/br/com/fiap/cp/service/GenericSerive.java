package br.com.fiap.cp.service;

import br.com.fiap.cp.dao.PersistenceManager;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class GenericSerive <T extends Serializable, PK extends Serializable>{
    private EntityManager entityManager;

    public abstract void cadastrar(T entidade);

    public abstract void atualizar (T entidade);

    public abstract void remover(PK id);

    public abstract T obter(PK id);

    public abstract List<T> listar();

    public javax.persistence.EntityManager getEntityManager(){
        if(entityManager == null || !entityManager.isOpen()){
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
        }
        return entityManager;
    }

    public void closeEntityManager(){
        if(entityManager != null || entityManager.isOpen()){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().commit();
            }

            entityManager.close();
        }
    }
}

