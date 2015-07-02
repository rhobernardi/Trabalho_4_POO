
package supermarketuserapp;

import Connection.Client;
import Connection.Receptor;
import user.User;
import produtos.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sessao {
    
    Receptor ConexaoServer;
    
    public Sessao(Receptor i) {
        this.ConexaoServer = i;
    }

    public void cadastrarUsuario() {

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
        
        DB = nome + "," + telefone + "," + endereco + "," + email + "," + ID + "," + senha + "\n";
        
        ConexaoServer.sendCommand(2);
        ConexaoServer.sendString(DB);
    }

    public void comprar() {
        int quantidade;
        Produto p = new Produto();
        String prod_name = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        printTitle();        
        
        System.out.println("nome do produto: ");
        try {
            prod_name = br.readLine();
        } catch (IOException ex) {
            System.out.println("Erro ao ler nome do produto.");
        }
        System.out.println("Quantidade: ");
        quantidade = sc.nextInt();
        
        //ADICIONA PRODUTO PARA LISTA DE COMPRAS DO CLIETE!!!!!!!!!!!!!
    }

    public void notificacao(){
        printTitle();        
    }
    
    public void listarProdutosUser(){
        printTitle();        
        //SERVIDOR RETORNA LISTA DOS PRODUTOS DO USUARIO
        System.out.println();
    }
    
    public void listarCompras() {        
        printTitle();        
                
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
    
    public boolean Login(String usr, String psw) throws IOException{
        ConexaoServer.sendCommand(1);
        ConexaoServer.sendString(usr);
        ConexaoServer.sendString(psw);
        
            int x = ConexaoServer.getCommand();
            
        return x == 1;
    }
}