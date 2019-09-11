/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.model.Editora;
import br.edu.utfpr.pb.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Maikon
 */
public class EditoraDao {
    @PersistenceContext(unitName = "ex01-PU")
    private EntityManager em;
    
    public EditoraDao() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    public void insert(Editora editora) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(editora);
        em.flush();
        t.commit();
    }

    public void update(Editora editora) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(editora);
        em.flush();
        t.commit();
    }

    public Editora getById(Integer id) {
        return em.find(Editora.class, id);
    }
    
    public List<Editora> getAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Editora> query = builder.createQuery(Editora.class);
        
        query.from(Editora.class);
        
        return em.createQuery(query).getResultList();
    }
    
    public void delete(Integer id){
        Editora e = getById(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(e);
        em.remove(e);
        em.flush();
        t.commit();
        
    }
    
    //select * from Editora where descricao like '%cat%'
    
    public List<Editora> findByEditoraLike(String editora){
        Query query = em.createQuery("select e from Editora e where e.editora like :editora");
        
        query.setParameter("editora", "%" + editora + "%");
        
        return query.getResultList();
    }
}
