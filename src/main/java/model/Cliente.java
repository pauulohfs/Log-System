/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Date;

/**
 *
 * @author phfde
 */
@Entity
@DiscriminatorValue("1")
public class Cliente extends Pessoa {

    @Column (nullable = false)
    private String plano;

    public Cliente(String plano, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(nome, cpf, dtNasc, estadoCivil);
        this.plano = plano;
    }

    public Cliente(int idCliente, String plano, int idPessoa, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(idPessoa, nome, cpf, dtNasc, estadoCivil);
        this.plano = plano;
    }

    public Cliente() {

    }



    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Cliente{" + "plano=" + plano + '}';
    }

  
    
    
    
}
