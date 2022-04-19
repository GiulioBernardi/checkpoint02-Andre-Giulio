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

        Proprietario p1 = new Proprietario("Giulio", "123.654.125-41");
        Proprietario p2 = new Proprietario("Andre", "965.965.848-95");

        Carro c1 = new Carro("ABC4595", "Branco", "4gh58iut3f2g1hj4", m1, p1);
        Carro c2 = new Carro("POB9201", "Vermelho", "5g4j12l5g84df69", m2, p2);


        proprietarioService.cadastrar(p1);
        proprietarioService.cadastrar(p2);

        modeloService.cadastrar(m1);
        modeloService.cadastrar(m2);

        carroService.cadastrar(c1);
        carroService.cadastrar(c2);

        carroService.listar().forEach(System.out::println);
    }
}
