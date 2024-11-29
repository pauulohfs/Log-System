package control;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Cliente;





public class ClienteAbstractTableModel extends AbstractTableModel {

    // Lista de OBJETOS
    private List<Cliente> listaClientes = new ArrayList();

    @Override
    public int getRowCount() {
        return listaClientes.size();
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
        Cliente item = listaClientes.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return item.getNome();
            case 1: return item.getCpf();
            case 2: return item.getPlano();
            default: return null;
        }
    }
    
    public void adicionar (Cliente item) {
        listaClientes.add(item);
        fireTableRowsInserted(listaClientes.size() - 1, listaClientes.size() - 1 );        
    }
    
    public void remover (int indice) {        
        listaClientes.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }

    public Cliente getCliente(int linha) {
        return listaClientes.get(linha);
    }
    
    public void setLista(List<Cliente> novaLista) {
        
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !listaClientes.isEmpty() ) {
                listaClientes.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaClientes = novaLista;
            fireTableRowsInserted(0, listaClientes.size() - 1);
        }
                
    }
        
}
