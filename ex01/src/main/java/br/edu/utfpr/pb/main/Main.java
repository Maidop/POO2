
package br.edu.utfpr.pb.main;

import br.edu.utfpr.pb.dao.LivroDao;

public class Main {
    public static void main(String[] args) {
        new Main();
        System.exit(0);
    }
    
    public Main(){
        listas();
    }
    
    private void listas(){
        LivroDao livros = new LivroDao();
        
        livros.findByAutorLike("mark");
        
        livros.findByAnoContains(2013);
        
        livros.findByGeneroLikeAnoOrder("ficção");
        
        livros.findByIsbnTituloLike("", "prince");
        
        livros.findByValorMaior(50.00);
        
        livros.findByValorBetween(50.00, 60.00);
    }
}
