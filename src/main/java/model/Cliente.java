/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 *
 * @author phfde
 */
@Entity
@DiscriminatorValue("1")
public class Cliente extends Pessoa {

    @Column 
    private String plano;
    
    @OneToMany ( mappedBy = "cliente", fetch = FetchType.LAZY )
    private List<Pacote> pacotes;

    public Cliente(String plano, String nome, String cpf, Date dtNasc, String estadoCivil,String cep, String bairro, String cidade
                ,String logradouro, int numero) {
        super(nome,cpf,dtNasc,estadoCivil,cep, bairro, cidade, logradouro,numero);
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

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }




  
    
    
    
}
