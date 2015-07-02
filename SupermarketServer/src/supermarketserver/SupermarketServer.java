
package supermarketserver;

import Connection.Server;

public class SupermarketServer {
    
    public static void main(String[] args) {

        
               
        Server server = new Server(9000);

        System.out.println("Initializing Server..");
        new Thread(server).start();
        System.out.println("Server inicialized. Running...");
    }
}
