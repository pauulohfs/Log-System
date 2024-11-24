/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.formdev.flatlaf.FlatDarkLaf;
import dao.ConexaoHibernate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.lang.reflect.InvocationTargetException;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Cliente;
import org.hibernate.HibernateException;
import view.DlgBuscarEncomenda;
import view.DlgCadClientes;
import view.DlgCadEntregadores;
import view.DlgEntrada;
import view.DlgPesqCliente;
import view.DlgRelatorioEntradas;
import view.DlgRelatorioEntregas;
import view.DlgRelatorioSaidas;
import view.DlgSaida;
import view.DlgStatusSaida;
import view.FrmPrincipal;

/**
 *
 * @author phfde
 */
public class GerenciadorInterface {

    private FrmPrincipal programa = null;
    private  DlgCadClientes cadCli = null;
    private  DlgCadEntregadores cadEntregadores = null;
    private  DlgSaida saidas = null;
    private  DlgEntrada entradas = null;
    private  DlgBuscarEncomenda buscarEncomenda = null;
    private  DlgRelatorioEntregas entregas = null;
    private  DlgRelatorioEntradas relatorioEntradas = null;
    private  DlgRelatorioSaidas relatorioSaidas = null;
    private  DlgStatusSaida status = null;
    private  DlgPesqCliente pesqCli = null;
    

    GerenciadorDominio gerDom;
    boolean banco = false;

    // SINGLETON
    private static final GerenciadorInterface myInstance = new GerenciadorInterface();

    private GerenciadorInterface() {
        try {
            gerDom = new GerenciadorDominio();
            banco = true;

        } catch (ExceptionInInitializerError | HibernateException ex) {
            JOptionPane.showMessageDialog(programa, "Programa Rodando no Modo Offline\nPara ativar todas as funções do programa\nConecte-se a um Banco de Dados Válido", "Banco de Dados Offline", JOptionPane.ERROR_MESSAGE);
            banco = false;

            //System.exit(0);
        }
    }

    public static GerenciadorInterface getMyInstance() {
        return myInstance;
    }

    public GerenciadorDominio getGerDom() {
        return gerDom;
    }

    // ABRIR JDIALOG
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent, true);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage());
            }
        }
        dlg.setVisible(true);

        return dlg;
    }

    private void statusBanco() {
        programa.getBtnRelatorioEntrada().setEnabled(banco);
        programa.getBtnRelatorioSaida().setEnabled(banco);
        programa.getBtnRelatorioEntrega().setEnabled(banco);
        programa.getMnuBuscar().setEnabled(banco);
        programa.getMnuCadastrar().setEnabled(banco);
        programa.getMnuEntrada().setEnabled(banco);
        programa.getMnuRelatorios().setEnabled(banco);
        programa.getMnuSaida().setEnabled(banco);
        programa.getBtnBuscar().setEnabled(banco);
        programa.getBtnCliente().setEnabled(banco);
        programa.getBtnEntrada().setEnabled(banco);
        programa.getBtnEntregador().setEnabled(banco);
        programa.getBtnStatus().setEnabled(banco);
        programa.getBtnSaida().setEnabled(banco);
        if (isBanco() == true) {
            programa.getTxtBD().setText("Banco de Dados Online");
            programa.getTxtBD().setForeground(Color.green);

        } else {
            programa.getTxtBD().setText("Banco de Dados Offline");
            programa.getTxtBD().setForeground(Color.red);

        }

    }

    public boolean isBanco() {
        return banco;
    }

    public void abrirPrincipal() {
        programa = new FrmPrincipal();
        programa.setVisible(true);
        statusBanco();
    }

    public void abrirCadastroCliente() {
        abrirJanela(programa, cadCli, DlgCadClientes.class);
    }

    public Cliente abrirPesqCliente() {
        pesqCli = (DlgPesqCliente) abrirJanela(programa, pesqCli, DlgPesqCliente.class);
        return pesqCli.getCliSelecionado();
        
    }

    public void abrirCadastroEntregadores() {
        abrirJanela(programa, cadEntregadores, DlgCadEntregadores.class);
    }

    public void abrirBuscarEncomenda() {

        abrirJanela(programa, buscarEncomenda, DlgBuscarEncomenda.class);

    }

    public void abrirNovaEntrada() {
        abrirJanela(programa, entradas, DlgEntrada.class);
    }

    public void abrirNovaSaida() {
        abrirJanela(programa, saidas, DlgSaida.class);

    }

    public void abrirRelatorioEntregas() {
        abrirJanela(programa, entregas, DlgRelatorioEntregas.class);
    }

    public void abrirRelatorioEntradas() {
        abrirJanela(programa, relatorioEntradas, DlgRelatorioEntradas.class);
    }

    public void abrirRelatorioSaidas() {
        abrirJanela(programa, relatorioSaidas, DlgRelatorioSaidas.class);
    }


    public void abrirStatus() {
        abrirJanela(programa, status, DlgStatusSaida.class);
    }
    
        public void carregarCombo( JComboBox combo, Class classe) {
        
        try {
            List lista = gerDom.listar(classe);
            combo.setModel(  new DefaultComboBoxModel( lista.toArray()  ) ); 
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(programa, ex, "ERRO ao carregar Combobox.", JOptionPane.ERROR_MESSAGE  );
        } 
        
    }

    //private final Dlg config = null;
    public static void main(String args[]) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new FlatDarkLaf());


        // TRADUÇÃO
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");

        GerenciadorInterface.getMyInstance().abrirPrincipal();
    }
}
