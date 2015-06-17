
package livros;

import static livros.TipoLivro.*;

public class Livro {
    
    private final String titulo;
    private final String autor;
    private final int ano;
    private final String edicao;
    private String codigo;
    private static int quantidade = 0;
    private TipoLivro tipo;
    private String dataEmprestado;
    private String dataDevolucao;
    private boolean emprestado;
    
    public Livro(){
        this.titulo = null;
        this.autor = null;
        this.ano = 0;
        this.edicao = null;
        this.codigo = null;
        this.quantidade = 0;
        this.tipo = null;
        this.dataEmprestado = null;
        this.dataDevolucao = null;
        this.emprestado = false;
    }    

    public Livro(String titulo, String autor, int ano, String edicao, String codigo, TipoLivro tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
        this.codigo = codigo;
        this.quantidade = 0;
        this.tipo = tipo;
        this.dataEmprestado = null;
        this.dataDevolucao = null;
        this.emprestado = false;
    }

    public Livro(String csv) {

        String[] values = csv.split("|");

        this.titulo = values[0];
        this.autor = values[1];
        this.ano = Integer.parseInt(values[2]);
        this.edicao = values[3];
        this.codigo = values[4];
        this.quantidade = Integer.parseInt(values[5]);
        this.tipo = Livro.parseTipoLivro(values[6]);
        this.dataEmprestado = null; 
        this.dataDevolucao = null;
        this.emprestado = false;
    }
    
    public boolean isEmprestado() {
        return emprestado;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void addBook(int quantidade)
    {
        this.quantidade += quantidade;
    }

    public static TipoLivro parseTipoLivro(String tipo)
    {
        if(tipo.compareToIgnoreCase("Texto") == 0)
        {
            return Texto;
        }

        if(tipo.compareToIgnoreCase("Geral") == 0)
        {
            return Geral;
        }

        return null;
    }

    @Override
    public String toString() {
            return this.titulo + "|" + this.autor + "|" + this.ano + "|" + this.edicao + "|" + 
                    this.codigo + "|" + this.quantidade + "|" + this.tipo + "|" + this.dataDevolucao;
    }
    
    public void Emprestar(String dataEmprestada, String dataDevolucao){
        this.dataEmprestado = dataEmprestada;
        this.dataDevolucao = dataDevolucao;
        this.emprestado = true;
    }
    
    public void Devolver(){
        this.emprestado = false;
    }
}

