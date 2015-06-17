package funcoes;

import supermercado.Data;
import java.util.List;
import java.util.Map;
import livros.Livro;
import pessoas.Pessoa;

public class Funcao {
    List<Livro> livrosEmprestados;
    List<Pessoa> pessoasEmprestaram;
    
    public Funcao(){
        this.livrosEmprestados = null;
        this.pessoasEmprestaram = null;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public List<Pessoa> getPessoasEmprestaram() {
        return pessoasEmprestaram;
    }
    
    public void emprestar(Livro l, Pessoa p){        
        this.livrosEmprestados.add(l);
        this.pessoasEmprestaram.add(p);
    }
    
    public void devolver(Livro l, Pessoa p){
        l.Devolver();
    }
}
