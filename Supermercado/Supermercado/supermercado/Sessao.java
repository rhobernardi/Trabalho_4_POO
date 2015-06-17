
package biblioteca;

import static biblioteca.Data.getDate;
import cadastros.CadastroLivros;
import cadastros.CadastroPessoas;
import funcoes.Funcao;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import livros.Livro;
import livros.TipoLivro;
import pessoas.*;


public class Sessao {
    CadastroPessoas cp;
    CadastroLivros cl;
    Funcao f;
    
    String filePathPessoas;
    String filePathLivros;
    String filePathEmprestimos;
      
    public Sessao(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
          {
            System.out.println("Caminho do pessoasfile.csv: ");
            this.filePathPessoas = br.readLine();
            System.out.println("Caminho do livrosfile.csv: ");
            this.filePathLivros = br.readLine();
            System.out.println("Caminho do emprestimosfile.csv: ");
            this.filePathEmprestimos = br.readLine(); 
          } catch (IOException ex)
          {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        
    }
    
    
    void cadastrarPessoa() {
        int option = 0;
        String nome=null, cidade=null, estado=null;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idade;
        String[] Campos = new String[4];
        
        printInterfaceCadastroPessoas();
        
        option = sc.nextInt();
        
        if(option > 0 && option <= 3)            
            
            System.out.println("Nome: ");
            try {
                nome = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Cidade: ");
            try {
                cidade = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Idade: ");
            idade = sc.nextInt();
            System.out.println("Estado: ");
            try {
                estado = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(option)
            {
                case 1:{
                    
                    Alunos p = new Alunos(nome, idade, cidade, estado);
                    cp = new CadastroPessoas(p.toString(), filePathPessoas);
                    break;
                }
                case 2:{
                    Professores p = new Professores(nome, idade, cidade, estado);
                    cp = new CadastroPessoas(p.toString(), filePathPessoas);
                    break;
                }
                case 3:{
                    Comunidade p = new Comunidade(nome, idade, cidade, estado);
                    cp = new CadastroPessoas(p.toString(), filePathPessoas);
                    break;
                }
                
        }
            
            Campos[0] = nome;
            Campos[1] = Integer.toString(idade);
            Campos[2] = cidade;
            Campos[3] = estado;
            cp.ativarWriteMode();
            cp.writeRegistro(Campos);
            cp.closeCSV();

    }

    void cadastrarLivros() {
        int option = 0;
        String[] Campos = new String[4];
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        clearConsole();
        printTitle();
        printInterfaceCadastroLivros();
        
        option = sc.nextInt();

        
        if(option > 0 && option <= 2){
            String titulo=null, autor=null, edicao=null, codigo=null;
            int ano;
            
            System.out.println("Titulo: ");
            try {
                titulo = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Autor: ");
            try {
                autor = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Ano: ");
            ano = sc.nextInt();
            System.out.println("Edicao: ");
            try {
                edicao = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Codigo: ");
            try {
                codigo = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            switch(option)
            {
                case 1:{
                    Livro l = new Livro(titulo, autor, ano, edicao, codigo, TipoLivro.Texto);
                    cl = new CadastroLivros(l.toString(), filePathLivros);
                    break;
                }
                case 2:{
                    Livro l = new Livro(titulo, autor, ano, edicao, codigo, TipoLivro.Geral);
                    cl = new CadastroLivros(l.toString(), filePathLivros);
                    break;
                }
            }
            
            Campos[0] = titulo;
            Campos[1] = Integer.toString(ano);
            Campos[2] = edicao;
            Campos[3] = codigo;
            cl.ativarWriteMode();
            cl.writeRegistro(Campos);
            cl.closeCSV();
        }
    }
    
    void emprestimo() {
        int optionLivro = 0, optionPessoa = 0;;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String codigo, nomeUsuario;
        Livro livro = new Livro();
        Pessoa pessoa = new Pessoa();
        
        System.out.println("Tipo do livro:");
        optionLivro = sc.nextInt();
        
        System.out.println("Tipo do usuario:");
        optionPessoa = sc.nextInt();
        
        System.out.println("Codigo do livro: ");
        try {
            codigo = br.readLine();
            livro = cl.getLivroEspecifico(codigo);
        } catch (IOException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }                
       
        System.out.println("Nome do usuario: ");
        try {
            nomeUsuario = br.readLine();
            pessoa = cp.getUsuarioEspecifico(nomeUsuario);
        } catch (IOException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        if(optionLivro>0 && optionLivro<=2){
            switch(optionLivro)
            {
                case 1:{                                                            
                    
                    if(optionPessoa>0 && optionPessoa<=3){
                        switch(optionPessoa){
                            case 1:{
                                Alunos a = (Alunos) pessoa;
                                if(a.permicaoEmprestar()){
                                    livro.Emprestar(Data.getDate(), Data.getDateDevolucao(a.getMax_dias()));
                                    a.emprestaLivro(livro);             
                                    f.emprestar(livro, pessoa);
                                }
                            }
                            case 2:{
                                Professores p = (Professores) pessoa;
                                if(p.permicaoEmprestar()){
                                    livro.Emprestar(Data.getDate(), Data.getDateDevolucao(p.getMax_dias()));
                                    p.emprestaLivro(livro);        
                                    f.emprestar(livro, pessoa);
                                }
                            }
                        }
                    }
                }
                case 2:{
                    if(optionPessoa>0 && optionPessoa<=3){
                        switch(optionPessoa){
                            case 1:{
                                Alunos a = (Alunos) pessoa;
                                if(a.permicaoEmprestar()){
                                    livro.Emprestar(Data.getDate(), Data.getDateDevolucao(a.getMax_dias()));
                                    a.emprestaLivro(livro);       
                                    f.emprestar(livro, pessoa);
                                }
                            }
                            case 2:{
                                Professores p = (Professores) pessoa;
                                if(p.permicaoEmprestar()){
                                    livro.Emprestar(Data.getDate(), Data.getDateDevolucao(p.getMax_dias()));
                                    p.emprestaLivro(livro);       
                                    f.emprestar(livro, pessoa);
                                }
                            }
                            case 3:{
                                Comunidade c = (Comunidade) pessoa;
                                if(c.permicaoEmprestar()){
                                    livro.Emprestar(Data.getDate(), Data.getDateDevolucao(c.getMax_dias()));
                                    c.emprestaLivro(livro);   
                                    f.emprestar(livro, pessoa);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void devolucao() {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nomeUsuario, codigo;
        Pessoa pessoa = new Pessoa();
        Livro livro = new Livro();
        
        System.out.println("Nome do usuario: ");
        try {
            nomeUsuario = br.readLine();
            pessoa = cp.getUsuarioEspecifico(nomeUsuario);
        } catch (IOException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("NomeCodigo do livro: ");
        try {
            codigo = br.readLine();
            livro = cl.getLivroEspecifico(codigo);
        } catch (IOException ex) {
            Logger.getLogger(Sessao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    void listarPessoas() {
        cp.getPessoas().stream().forEach((p) -> {
            p.toString();
        });
    }

    void listarLivros() {
        cl.getLivros().stream().forEach((l)->{
            l.toString();
        });
    }

    void listarEmprestimos() {        
        for(Livro l : f.getLivrosEmprestados()){
            for(Pessoa p : f.getPessoasEmprestaram())
                System.out.println(l.toString() + "\n" + p.toString() + "\n\n\n");
        }
    }
    
    public static void printInterfaceCadastroPessoas()
    {
        clearConsole();
        
        printTitle();
        System.out.println("\t1. Cadastro de alunos");
        System.out.println("\t2. Cadastro de professores");
        System.out.println("\t3. Cadastro da comunidade");
        System.out.println("\n");
        System.out.print("Opção: ");
    }
    
    public static void printInterfaceCadastroLivros()
    {
        clearConsole();
        
        printTitle();
        System.out.println("\t1. Cadastro de livro texto");
        System.out.println("\t2. Cadastro de livros gerais");
        System.out.println("\n");
        System.out.print("Opção: ");
    }
    
    public static void printTitle()
    {
        clearConsole();
        
        System.out.println("===== Sistema de Biblioteca ICMC ===== ");
        System.out.println("             " + Data.getDate());
        System.out.println("");
    }
    
    public final static void clearConsole()
    {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }
}
