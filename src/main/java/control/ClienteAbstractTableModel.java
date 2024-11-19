package control;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Cliente;





public class ClienteAbstractTableModel extends AbstractTableModel {

    // Lista de OBJETOS
    private List<Cliente> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
        

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Nome", "CPF", "Plano" };        
        return nomesColunas[column];        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente item = listaItens.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return item.getNome();
            case 1: return item.getCpf();
            case 2: return item.getPlano();
            default: return null;
        }
    }
    
    public void adicionar (Cliente item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );        
    }
    
    public void remover (int indice) {        
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }

    public Cliente getCliente(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<Cliente> novaLista) {
        
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaItens.isEmpty() ) {
                listaItens.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted( 0, listaItens.size() - 1);
        }
                
    }
        
}
