
package pessoas;

import static pessoas.TipoPessoa.*;

public class Professores extends Pessoa{

    private final int max_emprestimos = 6;
    private int num_emprestimos;
    private final int max_dias = 60;
    private final TipoPessoa tipo = Professor;
    
    public Professores(String nome, int idade, String cidade, String estado) {
        super(nome, idade, cidade, estado);
    }
    
    public Professores(String csv) {
        super(csv);
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
    
    public int getMax_dias() {
        return max_dias;
    }
    
    public TipoPessoa getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return getNome() + "|" + getIdade() + "|" + getCidade() + "|" + getEstado() + "|" + 
                tipo + "|" + getNumeroEmprestimos() + " livros";
    }
    
    public boolean permicaoEmprestar(){
        if(this.num_emprestimos<this.max_emprestimos){
            this.num_emprestimos++;
            return true;
        }
        return false;
    }

}
