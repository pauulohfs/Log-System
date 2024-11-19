/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author phfde
 */
public class ClienteDAO extends GenericDAO {

    private List<Cliente> pesquisar(String pesq, int tipo) {

        return this.listar(Cliente.class);
    }

    public List<Cliente> pesquisarPorNome(String pesq) {
        return pesquisar(pesq, 1);
    }

}
