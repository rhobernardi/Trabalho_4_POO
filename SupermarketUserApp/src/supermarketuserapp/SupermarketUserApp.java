
package supermarketuserapp;

import Connection.Client;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupermarketUserApp {
    private static String IP;
    private static final int port = 9000;
    
    public static void main(String[] args) {
        
        //IP = args[0];
        IP = "192.168.0.31";
        try {
            new Client(IP, port).executa();
        } catch (Exception ex) {
            System.out.println("Impossivel conectar com o servidor.");
        } finally {
            System.out.println("Logged off");
        }
    }
}
