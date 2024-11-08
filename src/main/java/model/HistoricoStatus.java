/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author phfde
 */
public class HistoricoStatus implements Serializable{
     private int idHistorico;
     private Date dtModificacao;

    public HistoricoStatus(Date dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    public HistoricoStatus(int idHistorico, Date dtModificacao) {
        this.idHistorico = idHistorico;
        this.dtModificacao = dtModificacao;
    }

    public HistoricoStatus() {
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Date getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(Date dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    @Override
    public String toString() {
        return "HistoricoStatus{" + "idHistorico=" + idHistorico + ", dtModificacao=" + dtModificacao + '}';
    }
    
    
    
    
    
    
}
