/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author phfde
 */
public class Status implements Serializable {
     private int idStatus;
     private String nomeStatus;

    public Status(int idStatus, String nomeStatus) {
        this.idStatus = idStatus;
        this.nomeStatus = nomeStatus;
    }

    public Status(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    public Status() {
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    @Override
    public String toString() {
        return "Status{" + "idStatus=" + idStatus + ", nomeStatus=" + nomeStatus + '}';
    }
    
    
    
    
     
    
    
}
