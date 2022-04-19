package br.com.fiap.cp.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tb_modelo")
@SequenceGenerator(name = "modelo", sequenceName = "sq_tb_modelo", allocationSize = 1)
public class Modelo implements Serializable {

    private static final long serialVersionUID = 2247019973143461512L;

    public Modelo(){};

    public Modelo(String descricao, List<Carro> carros) {
        this.descricao = descricao;
        Carros = carros;
    }

    @Id
    @GeneratedValue(generator="modelo", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_modelo")
    private Long id;

    @Column(name = "ds_modelo", length = 55, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "modelo", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Carro> Carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Carro> getCarros() {
        return Carros;
    }

    public void setCarros(List<Carro> carros) {
        Carros = carros;
    }
}
