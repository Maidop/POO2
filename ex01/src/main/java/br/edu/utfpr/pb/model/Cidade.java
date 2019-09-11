
package br.edu.utfpr.pb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;
    
    @Column(name = "ibge", nullable = false)
    private String ibge;

    public Cidade() {
    }
   
    public Cidade(Long id, String cidade, String ibge) {
        this.id = id;
        this.cidade = cidade;
        this.ibge = ibge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", cidade=" + cidade + ", ibge=" + ibge + '}';
    }
    
    
    
}
