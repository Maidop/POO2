
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.model.Autor;
import br.edu.utfpr.pb.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class AutorDao {
    
    @PersistenceContext(unitName = "ex01-PU")
    private EntityManager em;
    
    public AutorDao() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    public void insert(Autor autor) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(autor);
        em.flush();
        t.commit();
    }

    public void update(Autor autor) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(autor);
        em.flush();
        t.commit();
    }

    public Autor getById(Integer id) {
        return em.find(Autor.class, id);
    }
    
    public List<Autor> getAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Autor> query = builder.createQuery(Autor.class);
        
        query.from(Autor.class);
        
        return em.createQuery(query).getResultList();
    }
    
    public void delete(Integer id){
        Autor a = getById(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(a);
        em.remove(a);
        em.flush();
        t.commit();
        
    }
    
    //select * from Autor where descricao like '%cat%'
    
    public List<Autor> findByNomeLike(String nome){
        Query query = em.createQuery("select a from Autor a where a.nome like :nome");
        
        query.setParameter("nome", "%" + nome + "%");
        
        return query.getResultList();
    }
}
