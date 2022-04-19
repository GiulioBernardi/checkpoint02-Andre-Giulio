package br.com.fiap.cp.dao.impl;


import br.com.fiap.cp.dao.HibernateGenericDAO;
import br.com.fiap.cp.entity.Proprietario;

public class ProprietarioDAOImpl extends HibernateGenericDAO<Proprietario, Long> {
    private static ProprietarioDAOImpl instance = null;


    public ProprietarioDAOImpl() {
        super(Proprietario.class);
    }

    public static ProprietarioDAOImpl getInstance(){
        if(instance == null){
            instance = new ProprietarioDAOImpl();

        }
        return instance;
    }


}
