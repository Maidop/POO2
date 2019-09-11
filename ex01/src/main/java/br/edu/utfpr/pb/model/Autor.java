
package br.edu.utfpr.pb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "autor", length = 100, nullable = false)
    private String autor;
    
    @Column(name = "email", length = 200, nullable = false)
    private String email;

    public Autor() {
    }

    public Autor(Integer id, String autor, String email) {
        this.id = id;
        this.autor = autor;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", autor=" + autor + ", email=" + email + '}';
    }
    
    
    
}
