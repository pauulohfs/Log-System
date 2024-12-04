package view;

import control.ClienteAbstractTableModel;
import control.GerenciadorInterface;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import model.Cliente;
import org.hibernate.HibernateException;

/**
 *
 * @author phfdesouza
 */
public class DlgPesqCliente extends javax.swing.JDialog {

    private Cliente cliSelecionado;
    private ClienteAbstractTableModel tableClienteModel;

    public DlgPesqCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        cliSelecionado = null;

        // Associar o JTable ao ClienteTableModel
        tableClienteModel = new ClienteAbstractTableModel();
        tblClientes.setModel(tableClienteModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNome = new javax.swing.JLabel();
        btnPacotes = new javax.swing.JButton();

        setTitle("Pesquisar Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/accept.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/remove.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNome.setText("Nome:");

        btnPacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/shopping_cart.png"))); // NOI18N
        btnPacotes.setText("Pacotes");
        btnPacotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtNome)
                        .addGap(27, 27, 27)
                        .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(47, 47, 47)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(txtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSelecionar)
                    .addComponent(btnPacotes))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cliente getCliSelecionado() {
        return cliSelecionado;
    }

    public void resetaJanela() {
        txtPesq.setText("");
        tableClienteModel.setLista(new ArrayList<>());

    }

    public void clickButton() {
        btnPesquisar.doClick();
    }

    public void setTexto(String nome) {
        txtPesq.setText(nome);
    }


    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            String pesq = txtPesq.getText();

            List<Cliente> lista = GerenciadorInterface.getMyInstance().getGerDom().pesquisarCliente(pesq, 0);

            // Atualizar o JTable
            tableClienteModel.setLista(lista);

        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar. " + ex, "Pesquisar Cliente", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed

        int linha = tblClientes.getSelectedRow();

        if (linha >= 0) {
            cliSelecionado = tableClienteModel.getCliente(linha);

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente", "Pesquisar Cliente", JOptionPane.ERROR_MESSAGE);
        }

        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cliSelecionado = null;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPacotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacotesActionPerformed
        // TODO add your handling code here:
        int linha = tblClientes.getSelectedRow();
        try {
            if (tableClienteModel.getCliente(linha) != null) {
                String nome = tableClienteModel.getCliente(linha).getNome();
                GerenciadorInterface.getMyInstance().abrirListarEncomendas(nome);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para listagem de Pacotes", "Listagem de Pacotes", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnPacotesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPacotes;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JLabel txtNome;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables

}
