package br.com.fiap.cp.service.impl;

import br.com.fiap.cp.dao.impl.CarroDAOImpl;
import br.com.fiap.cp.entity.Carro;
import br.com.fiap.cp.service.GenericSerive;

import java.util.List;

public class CarroServiceImp extends GenericSerive<Carro, Long> {

    private static CarroServiceImp instance = null;

    private CarroDAOImpl carroDAO;

    private CarroServiceImp(){
        this.carroDAO = CarroDAOImpl.getInstance();
    }

    public static CarroServiceImp getInstance(){
        if(instance == null){
            instance = new CarroServiceImp();
        }
        return instance;
    }


    @Override
    public void cadastrar(Carro entidade) {
        try{
            carroDAO.salvar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Carro entidade) {
        try{
            carroDAO.atualizar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em atualizar carro");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            carroDAO.remover(id, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em remover carro");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Carro obter(Long id) {
        Carro carro = null;
        try{
            carroDAO.obterPorId(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
        return carro;
    }

    @Override
    public List<Carro> listar() {
        List<Carro> carros = null;
        try{
            carros = carroDAO.listar(getEntityManager());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return carros;
    }
}
