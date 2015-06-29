
package Connection;

import cadastros.EscritaCSV;
import cadastros.LeituraCSV;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import produtos.Produto;
import user.User;

public class DataHandle implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public DataHandle(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    @Override
    public void run() {
        try {
            int option;
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            ArrayList<User> usr = new ArrayList<User>();
            ArrayList<Produto> pr = new ArrayList<Produto>();
            
            output.write(("HTTP/1.1 200 OK\n\nRodrigo says: " + this.serverText + " - " + "").getBytes());
            
            option = input.read();
            
            switch(option) {
                case 0: { //Option 0: cliente criando usuario
                    User nu = new User();
                    //while(input.toString() == null)
                    System.out.println("writting in csv file");
                    while(true) {
                        System.out.println(input.toString());
                        if(input.toString().contains(",")) {
                            nu.csv(input.toString());
                            break;
                        }
                    }
                    System.out.println("OK");
                    usr.add(nu);
                    EscritaCSV.EscritaCSVUsers(usr);
                }
                case 1: { //Option 1: cliente criando produto
                
                }
                case 2: { //Option 2: cliente pedindo usuario
                
                }
                case 3: { //Option 3: cliente pedindo produto
                
                }
                case 4: { //Option 4: 
                
                }
                case 5: { //Option 5: 
                
                }
            }
            
            output.close();
            input.close();
            
        } catch (Exception e) {
            System.out.println("Error connecting client");
        }
    }
}