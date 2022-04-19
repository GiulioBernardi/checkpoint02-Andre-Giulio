package br.com.fiap.cp.main;

import br.com.fiap.cp.entity.Carro;
import br.com.fiap.cp.entity.Modelo;
import br.com.fiap.cp.entity.Proprietario;
import br.com.fiap.cp.service.impl.CarroServiceImp;
import br.com.fiap.cp.service.impl.ModeloServiceImpl;
import br.com.fiap.cp.service.impl.ProprietarioServiceImpl;

public class Main {
    public static void main(String[] args) {
        CarroServiceImp carroService = CarroServiceImp.getInstance();
        ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
        ProprietarioServiceImpl proprietarioService = ProprietarioServiceImpl.getInstance();



        Modelo m1 = new Modelo();
        m1.setDescricao("Gol");

        Modelo m2 = new Modelo();
        m2.setDescricao("Corsa");

        Proprietario p1 = new Proprietario("Giulio", "8848484");
        Proprietario p2 = new Proprietario("Andre", "52151425");

        Carro c1 = new Carro("ABC 6541", "Branco", "asidjaoisdj", m1, p1);
        Carro c2 = new Carro("ABC 6541", "Branco", "asidjaoisdj", m2, p2);


        proprietarioService.cadastrar(p1);
        proprietarioService.cadastrar(p2);

        modeloService.cadastrar(m1);
        modeloService.cadastrar(m2);



        carroService.cadastrar(c1);
        carroService.cadastrar(c2);



        carroService.listar().forEach(System.out::println);
    }
}
