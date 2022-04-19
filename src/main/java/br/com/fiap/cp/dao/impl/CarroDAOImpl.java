package br.com.fiap.cp.dao.impl;

import br.com.fiap.cp.dao.HibernateGenericDAO;
import br.com.fiap.cp.entity.Carro;

public class CarroDAOImpl extends HibernateGenericDAO<Carro, Long> {
    private static CarroDAOImpl instance = null;

    public CarroDAOImpl() {
        super(Carro.class);
    }

    public static CarroDAOImpl getInstance(){
        if(instance == null){
            instance = new CarroDAOImpl();
        }
        return instance;
    }
}
