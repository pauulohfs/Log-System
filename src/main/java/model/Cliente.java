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
import java.util.Date;

/**
 *
 * @author phfde
 */
@Entity
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCliente;
    @Column (nullable = false , length = 10)
    private String plano;

    public Cliente(String plano, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(nome, cpf, dtNasc, estadoCivil);
        this.plano = plano;
    }

    public Cliente(int idCliente, String plano, int idPessoa, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(idPessoa, nome, cpf, dtNasc, estadoCivil);
        this.idCliente = idCliente;
        this.plano = plano;
    }

    public Cliente() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", plano=" + plano + '}';
    }
    
    
    
}
