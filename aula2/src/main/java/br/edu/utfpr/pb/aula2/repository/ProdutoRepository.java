package br.edu.utfpr.pb.aula2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.utfpr.pb.aula2.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	// Select * from Produto where Nome like '%:nome%'
	List<Produto> findByNomeContains(String nome);
	
	// Select * from Produto where nome like '%:nome%' OR descricao like '%:descricao%'	
	List<Produto> findByNomeContainsOrDescricaoContains(
			String nome, String descricao);
	
	// Select * from Produto where valor > :valor Order By nome Desc
	List<Produto> findByValorGreaterThanOrderByNomeDesc(Double valor);
	
	List<Produto> findByCategoriaDescricaoContains(String descricao);
	
	@Query("Select p From Produto p Where p.nome like :nome")
	List<Produto> findByAlgumaCoisa(@Param("nome") String nome);
	
	@Query(value = "Select p.* From Produto p Where p.nome like :nome",
			nativeQuery = true)
	List<Object[]> findByAlgumaOutraCoisa(@Param("nome") String nome);
	
}
