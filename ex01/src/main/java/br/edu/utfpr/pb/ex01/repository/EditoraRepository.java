package br.edu.utfpr.pb.ex01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.ex01.model.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {

	List<Editora> findByNomeContains(String nome);
}
