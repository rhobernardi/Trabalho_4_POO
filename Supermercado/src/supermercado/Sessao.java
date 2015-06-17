
package supermercado;

import static supermercado.Data.getDate;
import cadastros.CadastroLivros;
import cadastros.CadastroPessoas;
import funcoes.Funcao;
import java.io.*;
import java.util.ArrayList;
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
    
    InOutCSVfile arquivoPessoas;
    InOutCSVfile arquivoLivros;
    InOutCSVfile arquivoEmprestimos;
    
    ArrayList<String[]> Pessoas;
    
    
      
    public Sessao(){

            this.filePathPessoas = "pessoasfile.csv";
            this.filePathLivros = "livrosfile.csv";
            this.filePathEmprestimos = "emprestimosfile.csv"; 
        
            this.arquivoPessoas = new InOutCSVfile(filePathPessoas);
            this.arquivoLivros  = new InOutCSVfile(filePathLivros);
            this.arquivoEmprestimos = new InOutCSVfile(filePathEmprestimos);
            
            this.Pessoas = new ArrayList<>();

            String[] Campos = new String[4];
            Campos[0] = "Nome";
            Campos[1] = "Cidade";
            Campos[2] = "Idade";
            Campos[3] = "Estado";

            this.arquivoPessoas.createCSV(Campos);
            Campos = new String[5];
            Campos[0] = "Titulo";
            Campos[1] = "Autor";
            Campos[2] = "Ano";
            Campos[3] = "Edicao";
            Campos[4] = "Codigo";
            
            
            this.arquivoLivros.createCSV(Campos);
           
            Campos = new String[4];
            Campos[0] = "Data";
            Campos[1] = "Devolucao";
            Campos[2] = "Usuario";
            Campos[3] = "Codigo";
            
            this.arquivoEmprestimos.createCSV(Campos);
            
            this.cp = new  CadastroPessoas();
            this.cl = new CadastroLivros();
            this.f = new Funcao();
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
                    cp = new CadastroPessoas();
                    break;
                }
                case 2:{
                    Professores p = new Professores(nome, idade, cidade, estado);
                    cp = new CadastroPessoas();
                    break;
                }
                case 3:{
                    Comunidade p = new Comunidade(nome, idade, cidade, estado);
                    cp = new CadastroPessoas();
                    break;
                }
                
        }
            
            Campos[0] = nome;
            Campos[1] = cidade;
            Campos[2] = Integer.toString(idade);
            Campos[3] = estado;
            
            this.arquivoPessoas.ativarWriteMode();
            this.arquivoPessoas.writeRegistro(Campos);


    }

    void cadastrarLivros() {
        int option = 0;
        String[] Campos = new String[5];
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
                    cl = new CadastroLivros();
                    break;
                }
                case 2:{
                    Livro l = new Livro(titulo, autor, ano, edicao, codigo, TipoLivro.Geral);
                    cl = new CadastroLivros();
                    break;
                }
            }
            
            Campos[0] = titulo;
            Campos[1] = autor;
            Campos[2] = Integer.toString(ano);
            Campos[3] = edicao;
            Campos[4] = codigo;
            this.arquivoLivros.writeRegistro(Campos);
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
                                try{
                                    if(a.permicaoEmprestar()){
                                        livro.Emprestar(Data.getDate(), Data.getDateDevolucao(a.getMax_dias()));
                                        a.emprestaLivro(livro);             
                                        f.emprestar(livro, pessoa);
                                    }
                                }catch(NullPointerException e){
                                    System.out.println("\nerror\n");
                                }finally{
                                    break;
                                }
                            }
                            case 2:{
                                Professores p = (Professores)  pessoa;
                                try{
                                    if(p.permicaoEmprestar()){
                                        livro.Emprestar(Data.getDate(), Data.getDateDevolucao(p.getMax_dias()));
                                        p.emprestaLivro(livro);        
                                        f.emprestar(livro, pessoa);
                                    }
                                }catch(NullPointerException e){
                                    System.out.println("\nerror\n");
                                }finally{
                                    break;
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
                                try{
                                    if(a.permicaoEmprestar()){
                                        livro.Emprestar(Data.getDate(), Data.getDateDevolucao(a.getMax_dias()));
                                        a.emprestaLivro(livro);       
                                        f.emprestar(livro, pessoa);
                                    }
                                }catch(NullPointerException e){
                                    System.out.println("\nerror\n");
                                }finally{
                                    break;
                                }
                            }
                            case 2:{
                                Professores p = (Professores) pessoa;
                                try{
                                    if(p.permicaoEmprestar()){
                                        livro.Emprestar(Data.getDate(), Data.getDateDevolucao(p.getMax_dias()));
                                        p.emprestaLivro(livro);       
                                        f.emprestar(livro, pessoa);
                                    }
                                }catch(NullPointerException e){
                                    System.out.println("\nerror\n");
                                }finally{
                                    break;
                                }
                            }
                            case 3:{
                                Comunidade c = (Comunidade) pessoa;
                                try{
                                    if(c.permicaoEmprestar()){
                                        livro.Emprestar(Data.getDate(), Data.getDateDevolucao(c.getMax_dias()));
                                        c.emprestaLivro(livro);   
                                        f.emprestar(livro, pessoa);
                                    }
                                }catch(NullPointerException e){
                                    System.out.println("\nerror\n");
                                }finally{
                                    break;
                                }                                
                            }
                        }
                    }
                }
            }
        }
    }

    void devolucao() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nomeUsuario, codigo;
        Pessoa pessoa = new Pessoa();
        Livro livro = new Livro();
        
        System.out.println("Nome do usuario: ");
        try {
            nomeUsuario = br.readLine();
            pessoa = cp.getUsuarioEspecifico(nomeUsuario);
        } catch (IOException ex) {
            System.out.println("Falha ao recuperar Usuario");
        }
        
        System.out.println("NomeCodigo do livro: ");
        try {
            codigo = br.readLine();
            livro = cl.getLivroEspecifico(codigo);
        } catch (IOException ex) {
            System.out.println("Falha ao recuperar Livro");
        }
        
        
    }

    void listarPessoas() {

       String[] e;
       this.arquivoPessoas.closeCSV();
       this.arquivoPessoas.ativarReadMode();
       String[] Campos =  this.arquivoPessoas.readRegistroCSV();
       do{
        e = this.arquivoPessoas.readRegistroCSV();
        if(e[0].length() !=  0){
            for(int i = 0; i< e.length; i++){
                System.out.println(Campos[i]+": "+e[i]);
            }
            System.out.println("");
        }
       }while(e[0].length() !=  0);
    }

    void listarLivros() {
       String[] e;
       this.arquivoLivros.closeCSV();
       this.arquivoLivros.ativarReadMode();
       String[] Campos =  this.arquivoLivros.readRegistroCSV();
       do{
        e = this.arquivoLivros.readRegistroCSV();
        if(e[0].length() !=  0){
            for(int i = 0; i< e.length; i++){
                System.out.println(Campos[i]+": "+e[i]);
            }
          System.out.println("");
        }
       }while(e[0].length() !=  0);
    }

    void listarEmprestimos() {        
        String[] e;
       this.arquivoEmprestimos.closeCSV();
       this.arquivoEmprestimos.ativarReadMode();
       String[] Campos =  this.arquivoEmprestimos.readRegistroCSV();
       do{
        e = this.arquivoEmprestimos.readRegistroCSV();
        if(e[0].length() !=  0){
            for(int i = 0; i< e.length; i++){
                System.out.println(Campos[i]+": "+e[i]);
            }
        }
       }while(e[0].length() !=  0);
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
    
    public void close(){
        this.arquivoEmprestimos.closeCSV();
        this.arquivoLivros.closeCSV();
        this.arquivoPessoas.closeCSV();
        
    }
}
