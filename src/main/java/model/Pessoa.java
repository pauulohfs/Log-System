/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author phfde
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int idPessoa;
    @Column (name = "nomePessoa", nullable = false )
    private String nome;
    @Column (unique = true, nullable = false, length = 14, updatable = false )
    private String cpf;
    @Temporal ( value = TemporalType.DATE) 
    @Column (updatable = false)
    private Date dtNasc;
    @Column (nullable = false, length = 10)
    private String estadoCivil;
    
    @ManyToMany ( cascade = CascadeType.ALL)
    @JoinTable ( name="Pessoa_Endereco", 
           	 joinColumns = { @JoinColumn (name="idPessoa") },
                 inverseJoinColumns = { @JoinColumn(name="idEndereco") }
             	)
    private List<Endereco> endereco;
        

    public Pessoa(String nome, String cpf, Date dtNasc, String estadoCivil,String cep, String bairro, String cidade, String logradouro, int numero) {
        this.nome = nome;
        Endereco end = new Endereco(cep,bairro,cidade, logradouro, numero);
        this.endereco = new ArrayList<>();
        this.endereco.add(end);
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.estadoCivil = estadoCivil;
    }

    public Pessoa(int idPessoa, String nome, String cpf, Date dtNasc, String estadoCivil) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.estadoCivil = estadoCivil;
    }

    public Pessoa() {
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    

}
