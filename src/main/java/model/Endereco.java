package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;



/**
 *
 * @author 1547816
 */
@Entity
public class Endereco implements Serializable {    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idEndereco;
    @Column (nullable = false, length = 9)
    private String cep;   
    @Column (nullable = false)
    private String bairro;
    @Column(nullable = false )
    private String logradouro;
    @Column (nullable = false )
    private int numero;
    @Column
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false , length = 2)
    private String uf;
    
    @ManyToMany
    @JoinTable ( name="Pessoa_Endereco", 
           	 joinColumns = { @JoinColumn (name="idEndereco") },
                 inverseJoinColumns = { @JoinColumn(name="idPessoa") }
             	)
    
    private List<Pessoa> pessoas;
    
    
    public Endereco() {
    }

    
    public Endereco(String cep, String uf, String bairro, String cidade, String logradouro, String complemento) {
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    // Para ser UTILIZADO pela classe CLIENTE
    // Sem ID
    public Endereco(String cep, String bairro, String logradouro, int num, String complemento) {
        this.cep = cep;
        this.uf = "";
        this.bairro = bairro;
        this.cidade = "";
        this.logradouro = logradouro;
        this.numero = num;
        this.complemento = complemento;
    }

    // Para ser UTILIZADO pela classe CLIENTE
    // Com ID
    public Endereco(int idEnder, String cep, String bairro, String logradouro, int num, String complemento) {
        this.idEndereco = idEnder;
        this.cep = cep;
        this.uf = "";
        this.bairro = bairro;
        this.cidade = "";
        this.logradouro = logradouro;
        this.numero = num;
        this.complemento = complemento;
    }
    
    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }



    
}
