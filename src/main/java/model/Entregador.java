/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author phfde
 */
@Entity
@DiscriminatorValue("2")
public class Entregador extends Pessoa {
    @Temporal ( value = TemporalType.DATE) 
    @Column ( nullable = false ,updatable = false)
    private Date dtAdmissao;
    
    @OneToOne
    @JoinColumn ( name = "idVeiculo")
    private Veiculo veiculo;
    
    @OneToMany(mappedBy = "entregador")
    private List<Pacote> pacotes;
    

    public Entregador(Date dtAdmissao, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(nome, cpf, dtNasc, estadoCivil);
        this.dtAdmissao = dtAdmissao;
    }

    public Entregador(int idEntregador, Date dtAdmissao, int idPessoa, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(idPessoa, nome, cpf, dtNasc, estadoCivil);
        this.dtAdmissao = dtAdmissao;
    }

    public Entregador(){

    }


    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    @Override
    public String toString() {
        return "Entregador{" + "dtAdmissao=" + dtAdmissao + '}';
    }

    
    
    
    
    
    
    
    

 
    
    

    
    
}
