package br.edu.utfpr.pb.ex01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.ex01.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	List<Genero> findByDescricaoContains(String descricao);
}
