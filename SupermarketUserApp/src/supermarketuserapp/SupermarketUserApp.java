
package supermarketuserapp;

import java.util.Scanner;

public class SupermarketUserApp {

    public static void main(String[] args) {
//        int option = -1;
//        Scanner sc = new Scanner(System.in);
//        Sessao s = new Sessao();
//        
//        try{ 
//            String dd = args[0];
//            String mm = args[1];
//            String aaaa = args[2];
//        
//            while(option != 0)
//            {
//                printInterfaceArg(dd, mm, aaaa);
//
//                    option = sc.nextInt();
//
//                    if(option > 0 && option <= 7)
//                        switch(option)
//                        {
//                            case 1:{s.cadastrarPessoa(); break;}
//                            case 2:{s.cadastrarLivros(); break;}
//                            case 3:{System.out.println("Funcao com erro"); break;}
//                            case 4:{s.devolucao(); break;}
//                            case 5:{s.listarPessoas(); break;}
//                            case 6:{s.listarLivros(); break;}
//                            case 7:{s.listarEmprestimos(); break;}
//                        }
//            }
//        }catch(Exception e){
//                
//            while(option != 0)
//            {
//                printInterface();
//
//                    option = sc.nextInt();
//
//                    if(option > 0 && option <= 7)
//                        switch(option)
//                        {
//                            case 1:{s.cadastrarPessoa(); break;}
//                            case 2:{s.cadastrarLivros(); break;}
//                            case 3:{System.out.println("Funcao com erro"); break;}
//                            case 4:{s.devolucao(); break;}
//                            case 5:{s.listarPessoas(); break;}
//                            case 6:{s.listarLivros(); break;}
//                            case 7:{s.listarEmprestimos(); break;}
//                        }
//            }
//            
//        }
//        s.close();
    }
    
    public static void printTitle()
    {
        System.out.println("===== Sistema de Supermercado Online ICMC ===== ");
        System.out.println("");
    }
    
    public static void printUser()
    {
        System.out.println("LOGIN");
        System.out.println("");
        System.out.println("User: ");
    }
    
    public static void printPassword()
    {
        System.out.println("Senha: ");
    }

    public static void printInterface()
    {
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
    
    public final static void clearConsole()
    {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }
}
