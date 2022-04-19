package br.com.fiap.cp.dao.impl;

import br.com.fiap.cp.dao.HibernateGenericDAO;
import br.com.fiap.cp.entity.Modelo;

public class ModeloDAOImpl extends HibernateGenericDAO<Modelo, Long> {

    private static ModeloDAOImpl instance = null;
    public ModeloDAOImpl() {
        super(Modelo.class);
    }

    public static ModeloDAOImpl getInstance(){
        if(instance==null){
            instance=new ModeloDAOImpl();
        }
        return  instance;
    }


}
