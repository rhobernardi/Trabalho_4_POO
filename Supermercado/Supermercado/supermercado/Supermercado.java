

package biblioteca;

import cadastros.CadastroLivros;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.*;
import livros.*;
import pessoas.*;


public class Biblioteca {
    
    public static void main(String[] args){
        int option = -1;
        Scanner sc = new Scanner(System.in);
        Sessao s = new Sessao();
        
        try{ 
            String dd = args[0];
            String mm = args[1];
            String aaaa = args[2];
        
            while(option != 0)
            {
                printInterfaceArg(dd, mm, aaaa);

                    option = sc.nextInt();

                    if(option > 0 && option <= 7)
                        switch(option)
                        {
                            case 1:{s.cadastrarPessoa(); break;}
                            case 2:{s.cadastrarLivros(); break;}
                            case 3:{s.emprestimo(); break;}
                            case 4:{s.devolucao(); break;}
                            case 5:{s.listarPessoas(); break;}
                            case 6:{s.listarLivros(); break;}
                            case 7:{s.listarEmprestimos(); break;}
                        }
            }
        }catch(Exception e){
                
            while(option != 0)
            {
                printInterface();

                    option = sc.nextInt();

                    if(option > 0 && option <= 7)
                        switch(option)
                        {
                            case 1:{s.cadastrarPessoa(); break;}
                            case 2:{s.cadastrarLivros(); break;}
                            case 3:{s.emprestimo(); break;}
                            case 4:{s.devolucao(); break;}
                            case 5:{s.listarPessoas(); break;}
                            case 6:{s.listarLivros(); break;}
                            case 7:{s.listarEmprestimos(); break;}
                        }
            }
        }
    }
    
    public static void printInterfaceArg(String dd, String mm, String aaaa)
    {
        System.out.println("===== Sistema de Biblioteca ICMC ===== ");
        System.out.println("             " + dd + "/" + mm + "/" + aaaa);
        System.out.println("");
        System.out.println("\t1. Cadastro de pessoas");
        System.out.println("\t2. Cadastro de livros");
        System.out.println("\t3. Emprestimo");
        System.out.println("\t4. DevoluÃ§Ã£o");
        System.out.println("\t5. Listar pessoas cadastradas");
        System.out.println("\t6. Listar livros cadastrados");
        System.out.println("\t7. Listar emprestimos");
        System.out.println("\n\t0. Sair do sistema");
        System.out.println("\n");
        System.out.print("OpÃ§Ã£o: ");
    }
    
    public static void printInterface()
    {
        System.out.println("===== Sistema de Biblioteca ICMC ===== ");
        System.out.println("             " + Data.getDate());
        System.out.println("");
        System.out.println("\t1. Cadastro de pessoas");
        System.out.println("\t2. Cadastro de livros");
        System.out.println("\t3. Emprestimo");
        System.out.println("\t4. DevoluÃ§Ã£o");
        System.out.println("\t5. Listar pessoas cadastradas");
        System.out.println("\t6. Listar livros cadastrados");
        System.out.println("\t7. Listar emprestimos");
        System.out.println("\n\t0. Sair do sistema");
        System.out.println("\n");
        System.out.print("OpÃ§Ã£o: ");
    }
    
    public final static void clearConsole()
    {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }
}
