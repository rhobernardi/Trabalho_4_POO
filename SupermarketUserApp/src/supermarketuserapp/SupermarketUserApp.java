
package supermarketuserapp;

import Connection.Client;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupermarketUserApp {

    
    public static void main(String[] args) {
        
        //IP = args[0];
        int port;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a porta que deseja conectar?");
        port = sc.nextInt();
        
        try {
            new Client("127.0.0.1", port).executa();
        } catch (Exception ex) {
            System.out.println("Não foi possivel conectar com o servidor.");
        } finally {
            System.out.println("Logged off");
        }
    }
}
