
package produtos;

import java.util.List;
import produtos.Produto;

import java.util.List;

public class Produto {
    
    private String nome;
    private float preco;
    private String validade;
    private String fornecedor;

    public Produto(){
        this.nome = null;
        this.preco = 0;
        this.validade = null;
        this.fornecedor = null;
    }
    
    public Produto(String nome, float preco, String validade, String fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.fornecedor = fornecedor;
    }

    public Produto(String csv) {
        String[] values = csv.split(",");
        this.nome = values[0];
        this.preco = Float.parseFloat(values[1]);
        this.validade = values[2];
        this.fornecedor = values[3];
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getValidade() {
        return validade;
    }

    public String getFornecedor() {
        return fornecedor;
    }
    
    public void setPreco(float preco)
    {
        this.preco = preco;
    }
}
