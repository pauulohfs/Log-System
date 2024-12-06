/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import model.Entregador;
import model.HistoricoStatus;
import model.Pacote;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author phfde
 */
public class PacoteDAO extends GenericDAO {

    private List<Pacote> pesquisar(String pesq, int tipo) {

        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Pacote.class);
            Root tabela = consulta.from(Pacote.class);

            Predicate restricoes = null;

            switch (tipo) {
                case 1:
                    restricoes = builder.equal(tabela.get("idPacote"), pesq);
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

    public List<Pacote> pesquisaPorData(String flag, Date dataInicio, Date dataFim) {
        List<Pacote> lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Pacote> consulta = builder.createQuery(Pacote.class);
            Root<Pacote> tabela = consulta.from(Pacote.class);

            // Restrição por intervalo de datas
            Predicate restricao = null;
            if (flag.equals("entrada")) {
                restricao = builder.between(tabela.get("dtEntrada"), dataInicio, dataFim);
            } else {
                restricao = builder.between(tabela.get("dtSaida"), dataInicio, dataFim);

            }

            consulta.where(restricao);

            // EXECUTAR
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(ex);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return lista;
    }

    public List<Pacote> pesquisarID(String pesq) {
        return pesquisar(pesq, 1);
    }

    public void carregarStatus(Pacote pacote) throws HibernateException {
        Session sessao = null;

        try {

            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            if (!Hibernate.isInitialized(pacote.getHistoricoStatus())) {


                // Carrega o PROXY para outro objeto
                Pacote pacoteTemp = sessao.get(Pacote.class, pacote.getIdPacote());

                // Carrega a lista de PEDIDOS
                List<HistoricoStatus> lista = pacoteTemp.getHistoricoStatus();
                lista.size();

                // Atualiza a lista no OBJETO principal (parâmetro)
                pacote.setHistoricoStatus(lista);
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

    public List<Pacote> listarPacotePorEntregador(Entregador entregador) {
        List<Pacote> lista = null;
        Session sessao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Critérios para listar pacotes por entregador
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Pacote> consulta = builder.createQuery(Pacote.class);
            Root<Pacote> tabela = consulta.from(Pacote.class);

            // Adiciona a restrição de entregador
            Predicate restricao = builder.equal(tabela.get("entregador"), entregador);
            consulta.where(restricao);

            // Executa a consulta
            lista = sessao.createQuery(consulta).getResultList();
            sessao.getTransaction().commit();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException("Erro ao listar pacotes por entregador", ex);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return lista;
    }

}
