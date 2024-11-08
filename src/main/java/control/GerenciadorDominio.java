/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.CarroDAO;
import dao.ConexaoHibernate;
import java.util.List;
import model.Veiculo;

/**
 *
 * @author phfde
 */
public class GerenciadorDominio {
    private CarroDAO carroDAO;
    

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();
        carroDAO = new CarroDAO();
    }
    
    public List<Veiculo> listarCarros() {
        return carroDAO.listar();
    
    }    
    
}
