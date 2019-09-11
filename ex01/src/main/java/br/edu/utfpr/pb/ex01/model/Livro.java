package br.edu.utfpr.pb.ex01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String titulo;
	
	@Column(name = "editora_id", length = 100, nullable = false)
	private String editora;
	
	@Column(name = "genero_id", length = 100, nullable = false)
	private String genero;
	
	@Column(name = "autor_id", length = 100, nullable = false)
	private String autor;
	
	@Column(nullable = false)
	private Integer ano;
	
	@Column(nullable = false)
	private Integer isbn;
	
	@Column(name = "cidade_id", length = 100, nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private Double valor;

}
