/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.CascadeType;
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

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date dtAdmissao;

    @OneToOne ( mappedBy = "entregador", cascade = CascadeType.ALL)
    @JoinColumn(name = "idVeiculo")
    private Veiculo veiculo;

    @OneToMany(mappedBy = "entregador")
    private List<Pacote> pacotes;

    public Entregador(Date dtAdmissao,String modelo, String marca,
            int anoFabricacao, String tipo, String nome, String cpf, Date dtNasc, String estadoCivil, String cep, String bairro, String cidade
                ,String logradouro, int numero) {
        super( nome,  cpf,  dtNasc,  estadoCivil, cep,  bairro,  cidade,  logradouro,  numero);
        this.veiculo = new Veiculo(modelo, marca, anoFabricacao, tipo);
        this.veiculo.setEntregador(this);
        this.dtAdmissao = dtAdmissao;
        this.veiculo = veiculo;
    }

    public Entregador(Date dtAdmissao, Veiculo veiculo, int idPessoa, String nome, String cpf, Date dtNasc, String estadoCivil) {
        super(idPessoa, nome, cpf, dtNasc, estadoCivil);
        this.dtAdmissao = dtAdmissao;
        this.veiculo = veiculo;

    }
   public Entregador() {

    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

 

}
