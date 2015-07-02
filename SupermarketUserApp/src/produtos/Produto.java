
package produtos;

public class Produto {
    
    private String nome;
    private float preco;
    private String validade;
    private String fornecedor;
    private int quantidade;

    
    public Produto() {
        this.nome = null;
        this.preco = 0;
        this.validade = null;
        this.fornecedor = null;
        this.quantidade = 0;
    }
    
    public Produto(String nome, float preco, String validade, String fornecedor, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public Produto csv(String csv) {
        String[] values = csv.split(",");
        this.nome = values[0];
        this.preco = Float.parseFloat(values[1]);
        this.validade = values[2];
        this.fornecedor = values[3];
        this.quantidade = Integer.parseInt(values[4]);
        
        return this;
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
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void addQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
    
    public void confirmBuy(int quantidade) {
        this.quantidade -= quantidade; 
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    @Override
    public String toString() {
        return nome + "," + preco + "," + validade + "," + fornecedor + "," + quantidade;
    }
}