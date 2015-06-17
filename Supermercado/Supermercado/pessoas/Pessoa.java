
package pessoas;

import java.util.List;
import livros.Livro;

public class Pessoa {            
    private String nome;
    private int idade;
    private String cidade;
    private String estado;
    private List<Livro> livros;

    public Pessoa(){
        this.nome = null;
        this.idade = 0;
        this.cidade = null;
        this.estado = null;
        this.livros = null;
    }
    
    public Pessoa(String nome, int idade, String cidade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.livros = null;
    }

    public Pessoa(String csv) {
        String[] values = csv.split("|");
        this.nome = values[0];
        this.idade = Integer.parseInt(values[2]);
        this.cidade = values[3];
        this.estado = values[4];
        this.livros = null;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }               
    
    public void emprestaLivro(Livro l){
        this.livros.add(l);
    }
    
}
