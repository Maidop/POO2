package br.edu.utfpr.pb.ex01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.ex01.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	// Retornar os Livros pesquisando por parte do nome do autor e ordenando por ano.
	List<Livro> findByAutorGreaterThanOrderByAno(String nome, Integer ano);
	
	//Retornar os livros filtrando por ano.
	List<Livro> findByAno(Integer ano);
}
