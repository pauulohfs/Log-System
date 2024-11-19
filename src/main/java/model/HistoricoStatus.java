/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author phfde
 */
@Entity
public class HistoricoStatus implements Serializable {

    @EmbeddedId
    private HistoricoStatusPK chaveComposta;

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date dtModificacao;

    public HistoricoStatus(Pacote pacote, Status status, Date dtModificacao) {
        this.dtModificacao = dtModificacao;
        this.chaveComposta = new HistoricoStatusPK(pacote,status);
    }

    public HistoricoStatus() {
    }
    
    

    public HistoricoStatusPK getChaveComposta() {
        return chaveComposta;
    }

    public void setPacote(Pacote pacote) {
        this.chaveComposta.setPacote(pacote);
    }

    public void setStatus(Status status) {
        this.chaveComposta.setStatus(status);
    }

    public Pacote getPacote() {
        return this.chaveComposta.getPacote();
    }

    public Status getStatus() {
        return this.chaveComposta.getStatus();
        
    }

    public Date getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(Date dtModificacao) {
        this.dtModificacao = dtModificacao;
    }
    

}
