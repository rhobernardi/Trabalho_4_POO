
package supermarketuserapp;

import user.User;
import produtos.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sessao {
    
    public Sessao() {
        
    }

    public String cadastrarUsuario() {

        String nome = null, telefone = null, endereco = null, email = null, ID = null, senha = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String DB = null; //Data Base
        
        //clearConsole();
        printTitle();
        
        System.out.println("Nome: ");
        try {
            nome = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler nome.");
        }
        
        System.out.println("Telefone: ");
        try {
            telefone = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler telefone.");
        }
        
        System.out.println("Endereco: ");
        try {
            endereco = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler endereco.");
        }
            
        System.out.println("Email: ");
        try {
            email = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler email.");
        }
        
        System.out.println("ID: ");
        try {
            ID = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler ID.");
        }
        
        System.out.println("Nova senha: ");
        try {
            senha = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler senha.");
        }
        
        DB = nome + "," + telefone + "," + endereco + "," + email + "," + ID + "," + senha;
        //System.out.println(DB);
        return DB;
        //enviar DataBase via socket para servidor.
    }

    public String cadastrarProdutos() {
        
        String nome = null, validade = null, fornecedor = null;
        float preco = 0;
        int quantidade = 0;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String DB = null; //Data Base
        
        //clearConsole();
        printTitle();
            
        System.out.println("Nome: ");
        try {
            nome = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler nome.");
        }
        
        System.out.println("Preco: ");
        preco = sc.nextFloat();
        
        System.out.println("Validade: ");
        try {
            validade = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler validade.");
        }
        System.out.println("Fornecedor: ");
        try {
            fornecedor = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler fornecedor.");
        }
        
        System.out.println("Quantidade: ");
        quantidade = sc.nextInt();
        
        DB = nome + "," + preco + "," + validade + "," + fornecedor + "," + quantidade;
        //System.out.println(DB);
        return DB;
        //enviar DataBase via socket para o servidor.
    }
    
    public void atualizarEstoque() {
        
    }
    
    public void comprar(String prod_name) {
        
    }

    public void gerarRelatorioPDF() {
        
    }

    public void listarProdutos() {

    }

    public void listarCompras() {        

    }
    
    public static void printInterfaceCadastroPessoas() {
        //clearConsole();
        printTitle();
        System.out.println("\t1. Cadastro de alunos");
        System.out.println("\t2. Cadastro de professores");
        System.out.println("\t3. Cadastro da comunidade");
        System.out.println("\n");
        System.out.print("Opção: ");
    }
    
    public static void printInterfaceCadastroLivros() {
        //clearConsole();
        printTitle();
        System.out.println("\t1. Cadastro de livro texto");
        System.out.println("\t2. Cadastro de livros gerais");
        System.out.println("\n");
        System.out.print("Opção: ");
    }
    
    public static void printTitle() {
        //clearConsole();
        System.out.println("");
        System.out.println("");
        System.out.println("============================================================================= ");
        System.out.println("===== Sistema de Supermercado Online ICMC ===== ");
        System.out.println("");
    }
    
    public final static void clearConsole() {
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\b") ;
        }
    }
    
    public void close() {

    }
}