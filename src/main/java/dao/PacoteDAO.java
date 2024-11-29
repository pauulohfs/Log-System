/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import model.Pacote;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author phfde
 */
public class PacoteDAO extends GenericDAO {
    private List<Pacote> pesquisar(String pesq, int tipo)  {
        
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta =  builder.createQuery(Pacote.class);
            Root tabela = consulta.from( Pacote.class );
            
            Predicate restricoes = null;
            
            switch (tipo) {
                case 1: 
                    restricoes = builder.equal( tabela.get("idPacote")  , pesq  );
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
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
        
    }
    
        public List<Pacote> pesquisarID(String pesq) {
        return pesquisar(pesq, 1);
    }
    
    
    
}
