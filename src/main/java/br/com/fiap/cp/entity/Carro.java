package br.com.fiap.cp.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "sq_tb_carro", allocationSize = 1)
public class Carro implements Serializable {


    private static final long serialVersionUID = -4559465145563315101L;

    public Carro(String placa, String cor, String chassi, Modelo modelo, Proprietario proprietario) {
        this.placa = placa;
        this.cor = cor;
        this.chassi = chassi;
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    @Id
    @GeneratedValue(generator="livro", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_carro")
    private Long id;

    @Column(name = "ds_placa", length = 7, nullable = false)
    private String placa;

    @Column(name = "ds_cor", length = 20, nullable = false)
    private String cor;

    @Column(name = "ds_chassi", length = 20, nullable = false)
    private String chassi;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Proprietario proprietario;

        @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    public Carro() {

    }


    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Override
    public String toString() {
        return "Carro: " +
                "\nid=" + id +
                "\nplaca=" + this.placa +
                "\ncor=" + this.cor + '\'' +
                "\nchassi=" + this.chassi + '\'' +
                "\nmodelo=" + this.modelo.getDescricao() +
                "\nproprietario=" + this.proprietario.getNome() ;
    }
}
