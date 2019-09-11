
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.model.Genero;
import br.edu.utfpr.pb.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GeneroDao {
    @PersistenceContext(unitName = "ex01-PU")
    private EntityManager em;
    
    public GeneroDao() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    public void insert(Genero genero) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(genero);
        em.flush();
        t.commit();
    }

    public void update(Genero genero) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(genero);
        em.flush();
        t.commit();
    }

    public Genero getById(Integer id) {
        return em.find(Genero.class, id);
    }
    
    public List<Genero> getAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Genero> query = builder.createQuery(Genero.class);
        
        query.from(Genero.class);
        
        return em.createQuery(query).getResultList();
    }
    
    public void delete(Integer id){
        Genero g = getById(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(g);
        em.remove(g);
        em.flush();
        t.commit();
        
    }
    
    //select * from Genero where descricao like '%cat%'
    
    public List<Genero> findByGeneroLike(String genero){
        Query query = em.createQuery("select g from Genero g where g.genero like :genero");
        
        query.setParameter("genero", "%" + genero + "%");
        
        return query.getResultList();
    }
}
