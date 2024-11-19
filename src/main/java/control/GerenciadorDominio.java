/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import model.Cliente;
import model.Entregador;
import model.Pacote;
import model.Veiculo;
import org.hibernate.HibernateException;

/**
 *
 * @author phfde
 */
public class GerenciadorDominio {

    private GenericDAO genDAO;
    private ClienteDAO cliDAO;

    public GerenciadorDominio() {
        ConexaoHibernate.getSessionFactory();
        genDAO = new GenericDAO();
        cliDAO = new ClienteDAO();

    }

    public List listar(Class classe) throws HibernateException {
        return cliDAO.listar(classe);
    }

    public void excluir(Object obj) throws HibernateException {
        cliDAO.excluir(obj);
    }

    public int inserirEntregador(Date dtAdmissao, String modelo, String marca,
            int anoFabricacao, String tipo, String nome, String cpf, Date dtNasc, String estadoCivil, String cep, String bairro, String cidade,
            String logradouro, int numero) throws HibernateException {

        Entregador entregador = new Entregador(dtAdmissao, modelo, marca,
                anoFabricacao, tipo, nome, cpf, dtNasc, estadoCivil, cep, bairro, cidade,
                logradouro, numero);

        genDAO.inserir(entregador);
        return entregador.getIdPessoa();
    }

    public int inserirCliente(String plano, String nome, String cpf, Date dtNasc, String estadoCivil, String cep, String bairro, String cidade,
            String logradouro, int numero) throws HibernateException {

        Cliente cliente = new Cliente(plano, nome, cpf, dtNasc, estadoCivil, cep, bairro, cidade,
                logradouro, numero);
        genDAO.inserir(cliente);

        return cliente.getIdPessoa();
    }

    public List<Cliente> pesquisarCliente(String pesq, int tipo) throws HibernateException {

        switch (tipo) {
            case 0:
                return cliDAO.pesquisarPorNome(pesq);
            default:
                return null;
        }

    }

    public int inserirPacote(Date dtEntrada, String loja, String descricao, Cliente cliente) throws HibernateException {

        Pacote pacote = new Pacote(dtEntrada, loja, descricao, cliente);
        genDAO.inserir(pacote);

        return pacote.getIdPacote();

    }

}
