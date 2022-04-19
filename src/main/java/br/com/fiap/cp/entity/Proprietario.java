package br.com.fiap.cp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_proprietario")
@SequenceGenerator(name = "proprietario", sequenceName = "sq_tb_proprietario", allocationSize = 1)
public class Proprietario implements Serializable {


    private static final long serialVersionUID = 371509163793676344L;

    public Proprietario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Id
    @GeneratedValue(generator="proprietario", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_proprietario")
    private Long id;

    @Column(name = "nm_proprietario", length = 55, nullable = false)
    private String nome;

    @Column(name = "ds_cpf", length = 15, nullable = false)
    private String cpf;

    @OneToOne(mappedBy = "proprietario", cascade = CascadeType.PERSIST)
    private Carro carro;



    public Proprietario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
