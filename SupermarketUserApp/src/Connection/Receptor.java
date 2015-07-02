
package Connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Receptor  extends UserTCP{

    public void Connect(String host, int port) throws IOException{
        this.client = new Socket(host, port);
        System.out.println("Nova conexao, IP: "+host+" Porta: "+port);

        this.InputStream = new Scanner(this.client.getInputStream());
        this.OutputStream = new PrintStream(this.client.getOutputStream());
    }
            
    @Override
    public void shutUser() throws IOException {
        if(this.InputStream != null)
            this.InputStream.close();
        if(this.OutputStream != null)
            this.OutputStream.close();
        if(this.client != null)
            this.client.close();
    }
}