/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author phfde
 */
@Entity
public class Pacote implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idPacote;
    @Temporal ( value = TemporalType.DATE) 
    @Column (updatable = false, nullable = false)
    private Date dtEntrada;
    @Temporal ( value = TemporalType.DATE) 
    @Column ()
    private Date dtSaida;
    
    private String loja;
    
    private String descricao;

    public Pacote() {
    }

    public Pacote(int idPacote, Date dtEntrada, Date dtSaida, String loja, String descricao) {
        this.idPacote = idPacote;
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        this.loja = loja;
        this.descricao = descricao;
    }

    public Pacote(Date dtEntrada, Date dtSaida, String loja, String descricao) {
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        this.loja = loja;
        this.descricao = descricao;
    }
    
    

    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
