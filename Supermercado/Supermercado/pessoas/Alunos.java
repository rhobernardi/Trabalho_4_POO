
package pessoas;

import static pessoas.TipoPessoa.*;

public class Alunos extends Pessoa{
    
    private final int max_emprestimos = 4;
    private int num_emprestimos;
    private final int max_dias = 15;
    private final TipoPessoa tipo = Aluno;

    public Alunos(String nome, int idade, String cidade, String estado) {
        super(nome, idade, cidade, estado);
    }
    
    public Alunos(String csv) {
        super(csv);
    }

    public int getMax_dias() {
        return max_dias;
    }
    
    public void setNumEmprestimos(){
        this.num_emprestimos = 0;
    }
    
    public int getMaxNumeroEmprestimos()
    {
        return max_emprestimos;
    }
    
    public int getNumeroEmprestimos()
    {
        return num_emprestimos;
    }
    
    public void setNumeroEmprestimos(int num)
    {
        this.num_emprestimos = num;
    }
    
    public TipoPessoa getTipo() {
        return tipo;
    }

    public String toString() {
        return getNome() + "|" + getIdade() + "|" + getCidade() + "|" + getEstado() + 
                "|" + tipo + "|" + getNumeroEmprestimos() + " livros";
    }
    
    public boolean permicaoEmprestar(){
        if(this.num_emprestimos<this.max_emprestimos){
            this.num_emprestimos++;
            return true;
        }
        return false;
    }
    
}
