
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Carro implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCarro;
    @Column (name = "modeloCarro", nullable = false )
    private String modelo;
    @Column (nullable = false, length = 4)
    private int anoFabricacao;
    @Column (nullable = false, length = 10)
    private String tipo;
    
    //CONSTRUTOR COM ID
    public Carro(int idCarro, String modelo, int anoFabricacao, String tipo) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
    }
    //CONSTRUTOR SEM ID
    public Carro(String modelo, int anoFabricacao, String tipo) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
    }
    //HIBERNATE
    public Carro(){}
    
    

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


    
    
    
}
