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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Entregador;
import model.HistoricoStatus;
import model.Pacote;
import model.Status;
import org.hibernate.HibernateException;

/**
 *
 * @author phfde
 */
public class DlgSaida extends javax.swing.JDialog {

    private Pacote pacoteSelecionado;

    /**
     * Creates new form DlgEntradas
     */
    public DlgSaida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ImageIcon logoIcon = new ImageIcon("saida.png");

        // Cria um JLabel para armazenar a imagem
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER); // Centraliza a imagem

        // Se você quiser adicionar a imagem a um JPanel já existente no formulário (por exemplo, jPanelLogo)
        txtLogo.setLayout(new BorderLayout()); // Certifique-se de usar o layout correto
        txtLogo.add(logoLabel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        cmbEntregador.setSelectedItem(null);
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

        grpSaida = new javax.swing.ButtonGroup();
        txtNome = new javax.swing.JLabel();
        cxtEcommerce = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtEcommerce = new javax.swing.JLabel();
        cxtNome = new javax.swing.JTextField();
        txtLogo = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        cxtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdbRetirada = new javax.swing.JRadioButton();
        rdbSaida = new javax.swing.JRadioButton();
        cmbEntregador = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        txtEntregador = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Saída");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        txtNome.setText("Cliente:");

        cxtEcommerce.setEditable(false);

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/accept.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/remove.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtEcommerce.setText("Loja");

        cxtNome.setEditable(false);

        txtLogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLogo.setForeground(new java.awt.Color(204, 204, 204));

        txtID.setText("ID");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N

        grpSaida.add(rdbRetirada);
        rdbRetirada.setSelected(true);
        rdbRetirada.setText("Retirada");
        rdbRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbRetiradaActionPerformed(evt);
            }
        });

        grpSaida.add(rdbSaida);
        rdbSaida.setText("Entrega");
        rdbSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSaidaActionPerformed(evt);
            }
        });

        cmbEntregador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEntregador.setEnabled(false);

        txtEntregador.setText("Entregador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbEntregador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(rdbRetirada)
                                .addGap(31, 31, 31)
                                .addComponent(rdbSaida))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(txtEntregador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbRetirada)
                    .addComponent(rdbSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEntregador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png/16x16/search.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNome)
                                .addComponent(txtID))
                            .addComponent(txtEcommerce))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cxtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(cxtEcommerce))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtID)
                        .addComponent(cxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome)
                    .addComponent(cxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEcommerce)
                    .addComponent(cxtEcommerce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:

        if (validarCampos()) {
            if (rdbSaida.isSelected()) {
                if (pacoteSelecionado.getHistoricoStatus().size() == 1) {
                    HistoricoStatus historico = new HistoricoStatus(pacoteSelecionado, new Status(2, "saiu para entrega"), new Date());
                    pacoteSelecionado.getHistoricoStatus().add(historico);
                    pacoteSelecionado.setEntregador((Entregador) cmbEntregador.getSelectedItem());
                    GerenciadorInterface.getMyInstance().getGerDom().atualizarPacote(pacoteSelecionado);
                    JOptionPane.showMessageDialog(this, "Alteração de status do pacote de id : " + pacoteSelecionado.getIdPacote());
                } else if (pacoteSelecionado.getHistoricoStatus().get(1).getStatus().getNomeStatus().equals("saiu para entrega")) {
                    if(pacoteSelecionado.getHistoricoStatus().size() == 3){
                        JOptionPane.showMessageDialog(this, "Pacote Entregue ao Destinatario");
                    }else{
                        JOptionPane.showMessageDialog(this, "Pacote em rota de Entrega");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Pacote já retirado");
                }

            } else {
                if (pacoteSelecionado.getHistoricoStatus().size() == 1) {
                    HistoricoStatus historico = new HistoricoStatus(pacoteSelecionado, new Status(4, "retirada"), new Date());
                    pacoteSelecionado.getHistoricoStatus().add(historico);
                    GerenciadorInterface.getMyInstance().getGerDom().atualizarPacote(pacoteSelecionado);
                    JOptionPane.showMessageDialog(this, "Alteração de status do pacote de id : " + pacoteSelecionado.getIdPacote());
                } else if (pacoteSelecionado.getHistoricoStatus().get(1).getStatus().getNomeStatus().equals("retirada")) {
                    JOptionPane.showMessageDialog(this, "Status já definido no pacote");
                } else {
                    JOptionPane.showMessageDialog(this, "Pacote já saiu para entrega ");
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pacote", "Erro na Saída de Pacote", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnConfirmarActionPerformed
    private boolean validarCampos() {
        //String msgErro = "";
        int invalidos = 0;
        txtNome.setForeground(Color.lightGray);
        txtEcommerce.setForeground(Color.lightGray);
        txtID.setForeground(Color.lightGray);
        txtEntregador.setForeground(Color.lightGray);

        if (cxtNome.getText().isEmpty()) {
            //msgErro = msgErro + "Digite seu nome.\n";
            invalidos++;
            txtNome.setForeground(Color.red);

        }
        if (cxtEcommerce.getText().isEmpty()) {
            //msgErro = msgErro + "Digite seu nome.\n";
            invalidos++;
            txtEcommerce.setForeground(Color.red);

        }

        if (cxtID.getText().isEmpty()) {
            invalidos++;
            txtID.setForeground(Color.red);
        }
        if (rdbSaida.isSelected()) {
            if (cmbEntregador.getSelectedItem() == null) {
                invalidos++;
                txtEntregador.setForeground(Color.red);

            }
        }

        if (invalidos == 0) {
            return true;
        } else {
            return false;
        }
    }
    private void rdbSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSaidaActionPerformed
        // TODO add your handling code here:
        if (rdbSaida.isSelected()) {
            cmbEntregador.setEnabled(true);
        } else if (rdbRetirada.isSelected()) {
            cmbEntregador.setEnabled(false);

        }
    }//GEN-LAST:event_rdbSaidaActionPerformed

    private void rdbRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbRetiradaActionPerformed
        // TODO add your handling code here:
        if (rdbRetirada.isSelected()) {
            cmbEntregador.setEnabled(false);
        } else if (rdbSaida.isSelected()) {
            cmbEntregador.setEnabled(true);

        }

    }//GEN-LAST:event_rdbRetiradaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        GerenciadorInterface.getMyInstance().carregarCombo(cmbEntregador, Entregador.class
        );
    }//GEN-LAST:event_formComponentShown

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        List<Pacote> lista;
        try {
            lista = GerenciadorInterface.getMyInstance().getGerDom().pesquisarPacote(1, cxtID.getText());
            String nomeCliente = "", nomeLoja = "";

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pacote não encontrado.", "Pesquisa de Pacote", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (Pacote pacote : lista) {
                    pacoteSelecionado = pacote;
                    nomeCliente = pacote.getCliente().getNome();
                    nomeLoja = pacote.getLoja();
                }
                cxtNome.setText(nomeCliente);
                cxtEcommerce.setText(nomeLoja);
            }

        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar pacote.");

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbEntregador;
    private javax.swing.JTextField cxtEcommerce;
    private javax.swing.JTextField cxtID;
    private javax.swing.JTextField cxtNome;
    private javax.swing.ButtonGroup grpSaida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdbRetirada;
    private javax.swing.JRadioButton rdbSaida;
    private javax.swing.JLabel txtEcommerce;
    private javax.swing.JLabel txtEntregador;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
