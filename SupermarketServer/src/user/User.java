package user;

import java.util.ArrayList;
import produtos.Produto;

public class User {      
    
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String ID;
    private String senha;
    private ArrayList<String> produtos_comprados;


    public User() {
        this.nome = null;
        this.telefone = null;
        this.endereco = null;
        this.email = null;
        this.ID = null;
        this.senha = null;
        this.produtos_comprados = new ArrayList<>();
        produtos_comprados.clear();
    }
    
    public User(String nome, String telefone, String endereco, String email, String ID, String senha, ArrayList<String> produtos_comprados) {
        this.nome = nome;
        this.endereco = telefone;
        this.telefone = endereco;
        this.email = email;
        this.ID = ID;
        this.senha = senha;
        if(produtos_comprados == null)
            this.produtos_comprados = new ArrayList<>();
        else this.produtos_comprados = produtos_comprados;
    }
    
    public User csv(String csv) {
        String[] values = csv.split(",");
        this.nome = values[0];
        this.endereco = values[1];
        this.telefone = values[2];
        this.email = values[3];
        this.ID = values[4];
        this.senha = values[5];
        for(int i = 6; i < values.length; i++)
            this.produtos_comprados.add(values[i]);
        
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<String> getProdutos_comprados() {
        return produtos_comprados;
    }

    public void setProdutos_comprados(ArrayList<String> produtos_comprados) {
        this.produtos_comprados = produtos_comprados;
    }
    
    public void addToBuyList(Produto prod, int quantidade) {
        ArrayList<String> list = getProdutos_comprados();
        
        if(!list.isEmpty()) {
            list.add(",");
        }
        
        list.add(prod.getNome());
        setProdutos_comprados(list);
        
        prod.confirmBuy(quantidade);
    }
    
    @Override
    public String toString() {
        return nome + "," + telefone + "," + endereco + "," + email + "," + ID + "," + senha + "," + produtos_comprados;
    }
}