/*
 *    Programacao Orientada a Objeto - Trabalho 2
 *
 *      7656209 - Guilherme Tomaz Torres Pinto
 *      7986879 - Otavio Guido Silva
 *      8066395 - Rodrigo das Neves Bernardi
 *
 */

package Connection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public abstract class UserTCP implements SenderReceiver {
    Socket client;
    Scanner InputStream;
    PrintStream OutputStream;
    String localHost = "127.0.0.1";
    userType Type;
    
    @Override
    public int getCommand () throws IOException{
        int cmd = -1;
            if(InputStream.hasNext())
                cmd = InputStream.nextInt();
        return cmd;
    }
    
    @Override
    public String getString() throws IOException{
        String c = null;
            if(InputStream.hasNext())
              {
                c = InputStream.nextLine();
                if(c.isEmpty())//Verifica se pegou nada. Acontece logo depois de se ler um comando
                    if(InputStream.hasNext())
                       c = InputStream.nextLine();
              }
                
        return c;
    }

    
    @Override
    public void sendCommand(int cmd) {
        this.OutputStream.println(cmd);
    }
    
    @Override
    public void sendString(String c){
        this.OutputStream.println(c);
    }
    
    @Override
    public void setType(userType Type){
        this.Type = Type;
    }
    
    @Override
    public userType getType() {
        return this.Type;
    }
    
    public abstract void shutUser()throws IOException;
    
}
