
package br.edu.utfpr.pb.dao;

import br.edu.utfpr.pb.model.Livro;
import br.edu.utfpr.pb.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class LivroDao {
    @PersistenceContext(unitName = "ex01-PU")
    private EntityManager em;
    
    public LivroDao() {
        this.em = EntityManagerUtil.getEntityManager();
    }

    public void insert(Livro livro) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(livro);
        em.flush();
        t.commit();
    }

    public void update(Livro livro) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(livro);
        em.flush();
        t.commit();
    }

    public Livro getById(Integer id) {
        return em.find(Livro.class, id);
    }
    
    public List<Livro> getAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> query = builder.createQuery(Livro.class);
        
        query.from(Livro.class);
        
        return em.createQuery(query).getResultList();
    }
    
    public void delete(Integer id){
        Livro l = getById(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(l);
        em.remove(l);
        em.flush();
        t.commit();
        
    }
    
    //select * from Livro where descricao like '%cat%'
    public List<Livro> findByTituloLike(String titulo){
        Query query = em.createQuery("select l from Livro l where l.titulo like :titulo");
        
        query.setParameter("titulo", "%" + titulo + "%");
        
        return query.getResultList();
    }
    
    //Retornar os Livros pesquisando por parte do nome do autor e ordenando por ano.
    public List<Livro> findByAutorLike(String autor){
        Query query = em.createQuery("select l from Livro l where l.autor.autor like :autor order by l.ano");
        
        query.setParameter("autor", "%" + autor + "%");
        
        return query.getResultList();
    }
    
    // Retornar os livros filtrando por ano.
    public List<Livro> findByAnoContains(Integer ano){
        Query query = em.createQuery("select l from Livro l where l.ano = :ano");
        
        query.setParameter("ano", ano);
        
        return query.getResultList();
    }
    
    // Retornar os livros filtrando pela descrição do gênero e ordenando por ano.
    public List<Livro> findByGeneroLikeAnoOrder(String descricao){
        Query query = em.createQuery("select l from Livro l where l.genero.descricao = :descricao order by l.ano asc");
        
        query.setParameter("descricao", "%" + descricao + "%");
        
        return query.getResultList();
    }
    
    // Retornar os livros filtrando a mesma string pelo ISBN ou Título e ordenar por ano
    public List<Livro> findByIsbnTituloLike(String isbn, String titulo){
        Query query = em.createQuery("select l from Livro l where l.isbn like :isbn or l.titulo like :titulo order by l.ano asc");
        
        query.setParameter("isbn", "%" + isbn + "%");
        query.setParameter("titulo", "%" + titulo + "%");
        
        return query.getResultList();
    }
    
    // Retornar os livros com valores maiores que...
    public List<Livro> findByValorMaior(Double valor){
        Query query = em.createQuery("select l from Livro l where l.valor > :valor");
        
        query.setParameter("valor", valor);
        
        return query.getResultList();
    }
    
    // Retornar os livros com valores entre A* e B* ordenados por ano
    public List<Livro> findByValorBetween(Double valor1, Double valor2){
        Query query = em.createQuery("select l from Livro l where l.valor between :valor1 and :valor2 order by l.ano asc");
        
        query.setParameter("valor1", "%" + valor1 + "%");
        query.setParameter("valor2", "%" + valor2 + "%");
        
        return query.getResultList();
    }
}
