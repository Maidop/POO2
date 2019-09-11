
package br.edu.utfpr.pb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "editora_id", referencedColumnName = "id")
    private Editora editora;
    
    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;
    
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Autor autor;
    
    @Column(name = "ano", nullable = false)
    private Integer ano;
    
    @Column(name = "isbn", length = 13, nullable = false)
    private String isbn;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private Cidade cidade;
    
    @Column(name = "valor", nullable = false)
    private Double valor;

    public Livro() {
    }

    public Livro(Long id, String titulo, Editora editora, Genero genero, Autor autor, Integer ano, String isbn, Cidade cidade, Double valor) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.genero = genero;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
        this.cidade = cidade;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", editora=" + editora + ", genero=" + genero + ", autor=" + autor + ", ano=" + ano + ", isbn=" + isbn + ", cidade=" + cidade + ", valor=" + valor + '}';
    }
    
    
    
}
