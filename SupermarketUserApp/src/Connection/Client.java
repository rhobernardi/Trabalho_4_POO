
package Connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import supermarketuserapp.Sessao;

public class Client {
    
    private final String host;
    private final int port;

    public Client (String host, int porta) {
        this.host = host;
        this.port = porta;
    }

    public void executa() throws UnknownHostException, IOException {
        
        Socket cliente = new Socket(this.host, this.port);
        InputStream client_input = cliente.getInputStream();
        OutputStream client_output = cliente.getOutputStream();
        
        System.out.println("O cliente se conectou ao servidor!");

        // thread para receber do servidor
        Receptor rcp = new Receptor(cliente.getInputStream());
        new Thread(rcp).start();
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        int option = -1;
        String stdin = null, aux_user = null, aux_pw = null;
        Scanner sc = new Scanner(System.in);
        Sessao s = new Sessao();
        
        //clearConsole();
        printTitle();
        System.out.print("Possui cadastro?(y/n) ");
        stdin = sc.next();
        
        if(!stdin.isEmpty() && (stdin.contains("n") || stdin.contains("N")))
        {
            client_output.write(0);
            client_output.write(s.cadastrarUsuario().getBytes());
            
            System.out.println("Cadastro efetuado com sucesso. Faca login para continuar.\n");
            //stdin = "Y";
        }
            
        if(!stdin.isEmpty() && (stdin.contains("y") || stdin.contains("Y")))
        {
            printUser();
            aux_user = sc.next();
            printPassword();
            aux_pw = sc.next();
            
            //enviar user e senha para servidor fazer checagem. Se existir usuario e se user e senha estiverem corretos, inicia sessão
        
            if(true)
            { 
                while(option != 0)
                {
                    printInterface();

                    option = sc.nextInt();

                    if(option > 0 && option <= 5)
                        switch(option)
                        {
                            case 1:{s.listarProdutos(); break;}
                            case 2:{s.comprar(""); break;}
                            case 3:{s.listarCompras(); break;}
                            case 4:{s.atualizarEstoque(); break;}
                            case 5:{s.gerarRelatorioPDF(); break;}
                        }
                }
            }
            
            else {
                System.out.println("Usuario não cadastrado.");
                s.close();
            }
        }
        
        s.close();
        System.out.println("Sessao encerrada.");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //saida.close();
        //teclado.close();
        cliente.close();    
    }
    
    void appHandle() {
        int option = -1;
        String stdin = null, aux_user = null, aux_pw = null;
        Scanner sc = new Scanner(System.in);
        Sessao s = new Sessao();
        
        //clearConsole();
        printTitle();
        System.out.print("Possui cadastro?(y/n) ");
        stdin = sc.next();
        
        if(!stdin.isEmpty() && (stdin.contains("n") || stdin.contains("N")))
        {
            s.cadastrarUsuario();
            System.out.println("Cadastro efetuado com sucesso. Faca login para continuar.\n");
            stdin = "Y";
        }
            
        if(!stdin.isEmpty() && (stdin.contains("y") || stdin.contains("Y")))
        {
            printUser();
            aux_user = sc.next();
            printPassword();
            aux_pw = sc.next();
            
            //enviar user e senha para servidor fazer checagem. Se existir usuario e se user e senha estiverem corretos, inicia sessão
        
            if(true)
            { 
                while(option != 0)
                {
                    printInterface();

                    option = sc.nextInt();

                    if(option > 0 && option <= 5)
                        switch(option)
                        {
                            case 1:{s.listarProdutos(); break;}
                            case 2:{s.comprar(""); break;}
                            case 3:{s.listarCompras(); break;}
                            case 4:{s.atualizarEstoque(); break;}
                            case 5:{s.gerarRelatorioPDF(); break;}
                        }
                }
            }
            
            else {
                System.out.println("Usuario não cadastrado.");
                s.close();
            }
        }
        
        s.close();
        System.out.println("Sessao encerrada.");
    }    
    public static void printTitle() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("===============================================================================");
        System.out.println("===== Sistema de Supermercado Online ICMC ===== ");
        System.out.println("");
    }
    
    public static void printUser() {
        System.out.println("-- LOGIN --");
        System.out.println("");
        System.out.print("User: ");
    }
    
    public static void printPassword() {
        System.out.print("Senha: ");
    }

    public static void printInterface() {
        printTitle();
        System.out.println("\t1. Listar produtos");
        System.out.println("\t2. Comprar um produto");
        System.out.println("\t3. Listar compras");
        System.out.println("\t4. Atualizar estoque");
        System.out.println("\t5. Gerar relatorio PDF");
        System.out.println("\n\t0. Sair do sistema");
        System.out.println("\n");
        System.out.print("Opcao: ");
    }
    
    public final static void clearConsole() {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }
    
}