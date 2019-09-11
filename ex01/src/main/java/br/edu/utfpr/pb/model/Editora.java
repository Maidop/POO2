
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
@Table(name = "editora")
public class Editora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "editora", length = 200, nullable = false)
    private String editora;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private Cidade cidade;
    
    @Column(name = "rua", length = 100, nullable = false)
    private String rua;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "complemento", length = 200)
    private String complemento;
    
    @Column(name = "cnpj", length = 11, nullable = false)
    private String cnpj;
    
    @Column(name = "telefone", length = 11)
    private String telefone;

    public Editora() {
    }

    public Editora(Long id, String editora, Cidade cidade, String rua, Integer numero, String complemento, String cnpj, String telefone) {
        this.id = id;
        this.editora = editora;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Editora{" + "id=" + id + ", editora=" + editora + ", cidade=" + cidade + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cnpj=" + cnpj + ", telefone=" + telefone + '}';
    }
    
    
}
