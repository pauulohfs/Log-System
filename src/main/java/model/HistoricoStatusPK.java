/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author phfde
 */
public class HistoricoStatusPK implements Serializable {

    @ManyToOne 
    @JoinColumn(name = "idPacote")
    private Pacote pacote;

    @ManyToOne 
    @JoinColumn(name = "idStatus")
    private Status status;

    public HistoricoStatusPK(Pacote pacote, Status status) {
        this.pacote = pacote;
        this.status = status;
    }

    public HistoricoStatusPK() {
    }
    

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

}
