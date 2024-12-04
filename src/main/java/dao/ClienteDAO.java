/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import model.Cliente;
import model.HistoricoStatus;
import model.Pacote;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author phfde
 */
public class ClienteDAO extends GenericDAO {

    private List<Cliente> pesquisar(String pesq, int tipo) {

        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Cliente.class);
            Root tabela = consulta.from(Cliente.class);

            Predicate restricoes = null;

            switch (tipo) {
                case 1:
                    restricoes = builder.like(tabela.get("nome"), pesq + "%");
                    break;
                case 2:
                //restricoes = builder.like(tabela.get("endereco").get("bairro")  , pesq + "%");
                // break;

                case 3:
                //Expression mes = builder.function("month", Integer.class, tabela.get("dtNasc") );                    
                //restricoes = builder.equal(mes, pesq);

            }

            consulta.where(restricoes);

            // EXECUTAR
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;

    }

    public List<Cliente> pesquisarPorNome(String pesq) {
        return pesquisar(pesq, 1);
    }

    public void carregarPacotes(Cliente cliente) {
        Session sessao = null;

        try {

            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Verifica se a lista JÁ FOI CARREGADA
            if (!Hibernate.isInitialized(cliente.getPacotes())) {

                //System.out.println("Carregar Pedido " + ped.getIdPedido() );
                // Carrega o PROXY para outro objeto
                Cliente clienteTemp = sessao.get(Cliente.class, cliente.getIdPessoa());

                // Carrega a lista de PEDIDOS
                List<Pacote> lista = clienteTemp.getPacotes();
                lista.size();

                // Atualiza a lista no OBJETO principal (parâmetro)
                cliente.setPacotes(lista);
            }

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }

    }

}
