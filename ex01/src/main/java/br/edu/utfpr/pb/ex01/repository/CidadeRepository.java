package br.edu.utfpr.pb.ex01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.ex01.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	List<Cidade> findByNomeContains(String nome);
}
