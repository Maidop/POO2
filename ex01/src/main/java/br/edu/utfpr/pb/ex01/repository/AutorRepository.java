package br.edu.utfpr.pb.ex01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.ex01.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	List<Autor> findByNomeContains(String nome);
}
