package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarro;
    @Column(name = "modeloCarro", nullable = false)
    private String modelo;
    @Column(name = "marcaCarro", nullable = false)
    private String marca;
    @Column(nullable = false, length = 4)
    private int anoFabricacao;
    @Column(nullable = false, length = 10)
    private String tipo;
    
    @OneToOne(mappedBy = "veiculo")
    private Entregador entregador;

    public Veiculo(int idCarro, String modelo, String marca, int anoFabricacao, String tipo) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
    }

    public Veiculo() {
    }

    public Veiculo(String modelo, String marca, int anoFabricacao, String tipo) {
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
    


}
