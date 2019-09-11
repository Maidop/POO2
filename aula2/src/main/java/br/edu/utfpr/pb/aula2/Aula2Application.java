package br.edu.utfpr.pb.aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.utfpr.pb.aula2.model.Categoria;
import br.edu.utfpr.pb.aula2.model.Produto;
import br.edu.utfpr.pb.aula2.repository.CategoriaRepository;
import br.edu.utfpr.pb.aula2.repository.ProdutoRepository;

@SpringBootApplication
public class Aula2Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Aula2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		inserirCategoria();
		
		listarCategorias();
		
		removerCategoria();
		
		inserirProduto();
		
		listarCategoriasDescricaoLike();
	}

	private void inserirCategoria() {
		// Inserindo a categoria 1 = informática
		Categoria categoria1 = new Categoria();
		categoria1.setDescricao("Informática");
		
		this.categoriaRepository.save(categoria1);
		System.out.println("Categoria " + categoria1.getId() + 
				" inserida com sucesso!");
		
		// Inserindo a categoria2 = Eletrônico
		Categoria categoria2 = new Categoria();
		categoria2.setDescricao("Eletrônico");
		
		this.categoriaRepository.save(categoria2);
		System.out.println("Categoria " + categoria2.getId() + 
				" inserida com sucesso!");
		
	}

	private void listarCategorias() {
		// Listando as categorias
		System.out.println("***** Lista das categorias *****");
		this.categoriaRepository.findAll().forEach(
				c -> System.out.println(c) );
	}

	private void removerCategoria() {
		// remover categoria
		this.categoriaRepository.deleteById(1L);
	}

	private void inserirProduto() {
		Produto produto1 = new Produto();
		produto1.setNome("Notebook");
		produto1.setDescricao("descrição do notebook cadastrado...");
		produto1.setValor(9999.99D);
		produto1.setCategoria( 
				categoriaRepository.findById(2L).orElse(null) );
		this.produtoRepository.save(produto1);
		System.out.println("Produto: " + produto1.getId() + 
				" salvo com sucesso!");
		
		produto1.setValor(555D);
		this.produtoRepository.save(produto1);
	}

	// listarCategorias com descrição Like
	// Select * From Categoria Where descricao Like '%elet%';
	private void listarCategoriasDescricaoLike() {
		System.out.println("***** listarCategoriasDescricaoLike() *****");
		this.categoriaRepository.findByDescricaoLike("%Elet%").forEach(
				c -> System.out.println(c) );
	}
}




