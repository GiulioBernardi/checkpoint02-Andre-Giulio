package br.com.fiap.cp.service.impl;

import br.com.fiap.cp.dao.impl.ModeloDAOImpl;
import br.com.fiap.cp.entity.Modelo;
import br.com.fiap.cp.service.GenericSerive;

import java.util.List;

public class ModeloServiceImpl extends GenericSerive<Modelo, Long> {

    private static ModeloServiceImpl instance = null;
    private ModeloDAOImpl modeloDAO;

    private ModeloServiceImpl(){
        this.modeloDAO = ModeloDAOImpl.getInstance();
    }

    public static ModeloServiceImpl getInstance(){
        if(instance == null){
            instance= new ModeloServiceImpl();
        }
        return instance;
    }

    @Override
    public void cadastrar(Modelo entidade) {
        try{
            modeloDAO.salvar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em salvar modelo");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Modelo entidade) {
        try{
            modeloDAO.atualizar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em atualizar modelo");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            modeloDAO.remover(id, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em remover modelo");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Modelo obter(Long id) {
        Modelo modelo = null;
        try{
            modeloDAO.obterPorId(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
        return modelo;
    }

    @Override
    public List<Modelo> listar() {
        List<Modelo> modelos = null;
        try{
            modelos = modeloDAO.listar(getEntityManager());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return modelos;
    }
}
