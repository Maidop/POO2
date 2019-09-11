package br.edu.utfpr.pb.aula2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.aula2.model.Categoria;

public interface CategoriaRepository 
					extends JpaRepository<Categoria, Long>{

	List<Categoria> findByDescricaoLike(String descricao);
	
}

