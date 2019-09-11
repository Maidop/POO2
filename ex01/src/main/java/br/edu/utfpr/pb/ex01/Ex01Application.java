package br.edu.utfpr.pb.ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.utfpr.pb.ex01.model.Autor;
import br.edu.utfpr.pb.ex01.model.Cidade;
import br.edu.utfpr.pb.ex01.model.Editora;
import br.edu.utfpr.pb.ex01.model.Genero;
import br.edu.utfpr.pb.ex01.model.Livro;
import br.edu.utfpr.pb.ex01.repository.AutorRepository;
import br.edu.utfpr.pb.ex01.repository.CidadeRepository;
import br.edu.utfpr.pb.ex01.repository.EditoraRepository;
import br.edu.utfpr.pb.ex01.repository.GeneroRepository;
import br.edu.utfpr.pb.ex01.repository.LivroRepository;

@SpringBootApplication
public class Ex01Application implements CommandLineRunner{
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}

	public void run(String... args) throws Exception {
		inserirAutor();
		
		inserirCidade();
		
		inserirEditora();
		
		inserirGenero();
		
		inserirLivro();
	}
	
	private void inserirAutor() {
		Autor autor1 = new Autor();
		autor1.setNome("Mark Lawrence");
		this.autorRepository.save(autor1);
		System.out.println("Autor " + autor1.getId() + 
				" inserido com sucesso!");
		
		Autor autor2 = new Autor();
		autor2.setNome("Oliver Bowden");
		this.autorRepository.save(autor2);
		System.out.println("Autor " + autor2.getId() + 
				" inserido com sucesso!");
	}
	
	private void inserirCidade() {
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Pato Branco");
		this.cidadeRepository.save(cidade1);
		System.out.println("Cidade " + cidade1.getId() + 
				" inserida com sucesso!");
	}
	
	private void inserirEditora() {
		Editora editora1 = new Editora();
		editora1.setNome("Darkside");
		this.editoraRepository.save(editora1);
		System.out.println("Editora " + editora1.getId() + 
				" inserida com sucesso!");
		
		Editora editora2 = new Editora();
		editora2.setNome("Editora Record");
		this.editoraRepository.save(editora2);
		System.out.println("Editora " + editora2.getId() + 
				" inserida com sucesso!");
	}
	
	private void inserirGenero() {
		Genero genero1 = new Genero();
		genero1.setDescricao("Ficção");
		this.generoRepository.save(genero1);
		System.out.println("Genero " + genero1.getId() + 
				" inserido com sucesso!");
		
		Genero genero2 = new Genero();
		genero2.setDescricao("Fantasia");
		this.generoRepository.save(genero2);
		System.out.println("Genero " + genero2.getId() + 
				" inserido com sucesso!");
	}
	
	private void inserirLivro() {
		Livro livro1 = new Livro();
		
	}
	
}


















