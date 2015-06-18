package user;

import java.util.List;
import produtos.Produto;

public class Pessoa {            
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String ID;
    private String senha;
    private List<Produto> produtos_comprados;

    public Pessoa(){
        this.nome = null;
        this.telefone = null;
        this.endereco = null;
        this.email = null;
        this.ID = null;
        this.senha = null;
        this.produtos_comprados.clear();
    }
    
    public Pessoa(String nome, String telefone, String endereco, String email, String ID, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.ID = ID;
        this.senha = senha;
        this.produtos_comprados.clear();
    }

    //incompleta. falta a List pra incluir (precisa?)
    public Pessoa(String csv) {
        String[] values = csv.split(",");
        this.nome = values[0];
        this.endereco = values[1];
        this.telefone = values[2];
        this.email = values[3];
        this.ID = values[4];
        this.senha = values[5];
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }
    
    public String getSenha()
    {
        return senha;
    }
    
    public String getID()
    {
        return ID;
    }
    
    public List getProdutosComprados()
    {
        return produtos_comprados;
    }
}
