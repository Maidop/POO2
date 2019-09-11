
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.model.Cidade;
import br.edu.utfpr.pb.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class CidadeDao {
    @PersistenceContext(unitName = "ex01-PU")
    private EntityManager em;
    
    public CidadeDao() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    public void insert(Cidade cidade) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(cidade);
        em.flush();
        t.commit();
    }

    public void update(Cidade cidade) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(cidade);
        em.flush();
        t.commit();
    }

    public Cidade getById(Integer id) {
        return em.find(Cidade.class, id);
    }
    
    public List<Cidade> getAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Cidade> query = builder.createQuery(Cidade.class);
        
        query.from(Cidade.class);
        
        return em.createQuery(query).getResultList();
    }
    
    public void delete(Integer id){
        Cidade c = getById(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(c);
        em.remove(c);
        em.flush();
        t.commit();
        
    }
    
    //select * from Cidade where descricao like '%cat%'
    
    public List<Cidade> findByCidadeLike(String cidade){
        Query query = em.createQuery("select c from Cidade c where c.cidade like :cidade");
        
        query.setParameter("cidade", "%" + cidade + "%");
        
        return query.getResultList();
    }
}
