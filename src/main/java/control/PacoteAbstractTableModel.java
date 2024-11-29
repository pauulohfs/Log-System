/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pacote;

/**
 *
 * @author phfde
 */
public class PacoteAbstractTableModel extends AbstractTableModel {
        // Lista de OBJETOS
    private List<Pacote> listaPacotes = new ArrayList();

    @Override
    public int getRowCount() {
        return listaPacotes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
        

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"ID", "Descricao", "Cliente" };        
        return nomesColunas[column];        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacote pacote = listaPacotes.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return pacote.getIdPacote();
            case 1: return pacote.getDescricao();
            case 2: return pacote.getCliente().getNome();
            default: return null;
        }
    }
    
    public void adicionar (Pacote pacote) {
        listaPacotes.add(pacote);
        fireTableRowsInserted(listaPacotes.size() - 1, listaPacotes.size() - 1 );        
    }
    
    public void remover (int indice) {        
        listaPacotes.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }

    public Pacote getCliente(int linha) {
        return listaPacotes.get(linha);
    }
    
    public void setLista(List<Pacote> novaLista) {
        
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaPacotes.isEmpty() ) {
                listaPacotes.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaPacotes = novaLista;
            fireTableRowsInserted(0, listaPacotes.size() - 1);
        }
                
    }
    
}
