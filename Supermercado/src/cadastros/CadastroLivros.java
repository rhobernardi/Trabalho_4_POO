
package cadastros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import livros.Livro;

public class CadastroLivros  {
	
    List<Livro> livros;

    public CadastroLivros() {
        livros = new ArrayList<Livro>();
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public Livro getLivroEspecifico(String codigo){
        return new Livro();
    }
}
