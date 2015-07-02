
package Connection;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import supermarketuserapp.Sessao;

public class Client{
    
    private final String host;
    private final int port;
    private Receptor ConexaoServer;

    public Client (String host, int porta) {
        this.host = host;
        this.port = porta;
    }

    public void executa() throws UnknownHostException, IOException {
        
        
        ConexaoServer = new Receptor();
        ConexaoServer.Connect(host, port);
        
        System.out.println("O cliente se conectou ao servidor!");

        // thread para receber do servidor

        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        int option = -1;
        String stdin = null, aux_user = null, aux_pw = null;
        Scanner sc = new Scanner(System.in);
        
        Sessao s = new Sessao(ConexaoServer);
        
        boolean permissao;
        
        //clearConsole();
        printTitle();
        System.out.print("Possui cadastro?(y/n) ");
        stdin = sc.next();
        

            
        if(!stdin.isEmpty() && (stdin.contains("n") || stdin.contains("n")))
                s.cadastrarUsuario();
        
            printUser();
            aux_user = sc.next();
            printPassword();
            aux_pw = sc.next();
            
            permissao  = s.Login(aux_user, aux_pw);

            
        if(permissao)
            { 
                while(option != 0)
                {
                    printInterface();

                    option = sc.nextInt();

                    if(option > 0 && option <= 5)
                        switch(option)
                        {
                            case 0:{closeClient(); break; }
                            case 1:{s.cadastrarUsuario(); break;}
                            case 2:{s.comprar(); break;}
                            case 3:{s.listarCompras(); break;}
                            case 4:{; break;}
                            case 5:{; break;}
                        }
                }
            }
            
            else {
                System.out.println("Usuario não cadastrado.");
                s.close();
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
        System.out.println("\t1. Cadastrar Usuario");
        System.out.println("\t2. Comprar um produto");
        System.out.println("\t3. Listar compras");
        System.out.println("\t4. ");
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
    
    private void closeClient(){
        
    }
}