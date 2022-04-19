package br.com.fiap.cp.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static PersistenceManager instance = null;

    private EntityManagerFactory entityManagerFactory;

    public PersistenceManager () {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("FIAP_CP02");
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public static PersistenceManager getInstance(){
        if(instance==null){
            instance=new PersistenceManager();
        }
        return instance;
    }
}
