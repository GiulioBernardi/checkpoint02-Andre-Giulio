package br.com.fiap.cp.service.impl;

import br.com.fiap.cp.dao.impl.ModeloDAOImpl;
import br.com.fiap.cp.dao.impl.ProprietarioDAOImpl;
import br.com.fiap.cp.entity.Proprietario;
import br.com.fiap.cp.service.GenericSerive;

import java.util.List;

public class ProprietarioServiceImpl extends GenericSerive<Proprietario, Long> {

    private static ProprietarioServiceImpl instance = null;
    private ProprietarioDAOImpl proprietarioDAO;

    private ProprietarioServiceImpl(){
        this.proprietarioDAO = ProprietarioDAOImpl.getInstance();
    }

    public static ProprietarioServiceImpl getInstance(){
        if(instance == null){
            instance= new ProprietarioServiceImpl();
        }
        return instance;
    }

    @Override
    public void cadastrar(Proprietario entidade) {
        try{
            proprietarioDAO.salvar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em salvar proprietario");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Proprietario entidade) {
        try{
            proprietarioDAO.atualizar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em atualizar proprietario");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            proprietarioDAO.remover(id, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em remover proprietario");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Proprietario obter(Long id) {
        Proprietario proprietario = null;
        try{
            proprietarioDAO.obterPorId(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
        return proprietario;
    }

    @Override
    public List<Proprietario> listar() {
        List<Proprietario> proprietarios = null;
        try{
            proprietarios = proprietarioDAO.listar(getEntityManager());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return proprietarios;
    }
}
