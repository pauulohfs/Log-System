/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.GerenciadorInterface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.HistoricoStatus;
import model.Pacote;
import model.Status;
import org.hibernate.HibernateException;

/**
 *
 * @author phfde
 */
public class DlgStatusSaida extends javax.swing.JDialog {

    private Pacote pacoteSelecionado;

    public DlgStatusSaida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ImageIcon logoIcon = new ImageIcon("statusEntrega.png");

        // Cria um JLabel para armazenar a imagem
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza a imagem

        // Se você quiser adicionar a imagem a um JPanel já existente no formulário (por exemplo, jPanelLogo)
        txtLogo.setLayout(new BorderLayout()); // Certifique-se de usar o layout correto
        txtLogo.add(logoLabel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        pacoteSelecionado = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpStatus = new javax.swing.ButtonGroup();
        txtLogo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtID = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtEntregador = new javax.swing.JLabel();
        cxtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdbCaminho = new javax.swing.JRadioButton();
        rdbEntregue = new javax.swing.JRadioButton();
        txtStatus = new javax.swing.JLabel();
        cxtEntregador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Status de Pacote");

        txtLogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLogo.setForeground(new java.awt.Color(204, 204, 204));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/remove.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/accept.png"))); // NOI18N
        btnSalvar.setText("Confirmar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtID.setText("ID");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtEntregador.setText("Entregador");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        grpStatus.add(rdbCaminho);
        rdbCaminho.setText("Saiu para Entrega");
        rdbCaminho.setEnabled(false);

        grpStatus.add(rdbEntregue);
        rdbEntregue.setText("Entregue ao Destinatario");
        rdbEntregue.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbCaminho)
                    .addComponent(rdbEntregue))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(rdbCaminho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbEntregue)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        txtStatus.setText("Status");

        cxtEntregador.setEditable(false);
        cxtEntregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxtEntregadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jSeparator1)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntregador)
                    .addComponent(txtID))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cxtEntregador))
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(txtStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID)
                    .addComponent(cxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntregador)
                    .addComponent(cxtEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtStatus)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnSalvar))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (validarCampos()) {
            GerenciadorInterface.getMyInstance().getGerDom().getHistoricoPacote(pacoteSelecionado);
            try {

                if (pacoteSelecionado.getHistoricoStatus().size() > 1) {
                    if (rdbEntregue.isSelected()) {
                        HistoricoStatus historico = new HistoricoStatus(pacoteSelecionado, new Status(3, "entregue ao destinatario"), new Date());
                        pacoteSelecionado.getHistoricoStatus().add(historico);
                        GerenciadorInterface.getMyInstance().getGerDom().atualizarPacote(pacoteSelecionado);
                        JOptionPane.showMessageDialog(this, "Status Alterado com Sucesso!", "Alteração de Status", JOptionPane.INFORMATION_MESSAGE);
                        limparCampos();
                    } else if (pacoteSelecionado.getHistoricoStatus().size() == 3) {
                        JOptionPane.showMessageDialog(this, "Pacote já entregue ao Destinatario!", "Alteração de Status", JOptionPane.INFORMATION_MESSAGE);
                        rdbEntregue.setSelected(true);

                    }

                }
            } catch (IllegalStateException erro) {

                JOptionPane.showMessageDialog(this, "Pacote com Status já adicionado", "Alteração de Status", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pacote de algum entregador.", "Alteração de Status", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed
    private void limparCampos() {
        grpStatus.clearSelection();
        rdbCaminho.setEnabled(false);
        rdbEntregue.setEnabled(false);
        cxtID.setText("");
        cxtEntregador.setText("");

    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (validarID()) {

            rdbCaminho.setEnabled(true);
            rdbEntregue.setEnabled(true);

            List<Pacote> lista;
            try {
                lista = GerenciadorInterface.getMyInstance().getGerDom().pesquisarPacote(1, cxtID.getText());
                if (lista.isEmpty()) {
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Pacote não encontrado.", "Pesquisa de Pacote", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    for (Pacote pacote : lista) {
                        pacoteSelecionado = pacote;
                        GerenciadorInterface.getMyInstance().getGerDom().getHistoricoPacote(pacoteSelecionado);
                        if (pacoteSelecionado.getHistoricoStatus().get(1).getStatus().getNomeStatus().equals("saiu para entrega")) {
                            cxtEntregador.setText(pacoteSelecionado.getEntregador().getNome());
                        }
                    }
                    if (pacoteSelecionado.getHistoricoStatus().size() == 2
                            && pacoteSelecionado.getHistoricoStatus().get(1).getStatus().getNomeStatus().equals("saiu para entrega")) {
                        rdbCaminho.setSelected(true);
                    } else if (pacoteSelecionado.getHistoricoStatus().size() == 3) {
                        rdbEntregue.setSelected(true);
                    } else if ((pacoteSelecionado.getHistoricoStatus().size() == 2
                            && pacoteSelecionado.getHistoricoStatus().get(1).getStatus().getNomeStatus().equals("retirada"))) {
                        JOptionPane.showMessageDialog(this, "Pacote Retirado", "Pesquisa de Pacote", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            } catch (HibernateException e) {
                limparCampos();
                JOptionPane.showMessageDialog(this, "Erro na pesquisa", "Pesquisa de Pacote", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception erroDuplicada) {
            JOptionPane.showMessageDialog(this, "Faça a saida deste Pacote antes de finalizar a Entrega", "Pacote em Estoque", JOptionPane.INFORMATION_MESSAGE);
             rdbCaminho.setEnabled(false);
             rdbEntregue.setEnabled(false);
             }
        } else {
            limparCampos();
            JOptionPane.showMessageDialog(this, "Digite o ID do pacote ", "Erro na Busca", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cxtEntregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxtEntregadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxtEntregadorActionPerformed

    private boolean validarID() {
        txtID.setForeground(Color.lightGray);

        int invalidos = 0;
        if (cxtID.getText().isEmpty()) {
            txtID.setForeground(Color.red);
            invalidos++;
        }

        if (invalidos == 0) {
            return true;
        } else {
            return false;
        }

    }

    private boolean validarCampos() {
        txtEntregador.setForeground(Color.lightGray);
        txtID.setForeground(Color.lightGray);
        int invalidos = 0;

        if (cxtEntregador.getText().isEmpty()) {
            txtEntregador.setForeground(Color.red);
            invalidos++;
        }
        if (cxtID.getText().isEmpty()) {
            txtID.setForeground(Color.red);
            invalidos++;
        }

        if (invalidos == 0) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cxtEntregador;
    private javax.swing.JTextField cxtID;
    private javax.swing.ButtonGroup grpStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdbCaminho;
    private javax.swing.JRadioButton rdbEntregue;
    private javax.swing.JLabel txtEntregador;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
}
