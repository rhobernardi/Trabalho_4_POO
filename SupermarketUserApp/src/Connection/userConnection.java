/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class userConnection extends UserTCP implements Observer, Runnable{
    
    ServerSocket server;
    Observable ObsServer;
    
    public userConnection(Socket client, ServerSocket server){
        this.client = client;
        this.server = server;
    }
    
    
    public byte[] receiveConnection () throws IOException{
        
        System.out.println("Nova conexao, cliente: "+this.client.getInetAddress().getHostAddress());
        
        this.InputStream = new Scanner (this.client.getInputStream());
        this.OutputStream = new PrintStream(this.client.getOutputStream());

     return this.client.getInetAddress().getAddress();
    }

    @Override
    public void shutUser() throws IOException{
        if(this.InputStream != null)
            this.InputStream.close();
        if(this.OutputStream != null)
            this.OutputStream.close();
        if(this.client != null)
            this.client.close();
        if(this.server != null)
            this.server.close();
        
        ObsServer.deleteObserver(this);
    }
    
    public synchronized void askServerForItem(String c){
        
    }
    
    @Override
    public void run() {
        
        int x;
        String c;
        boolean exit = false;
        
        try
          {
            receiveConnection();
            do{
                if(InputStream.hasNext()){
                    x = this.getCommand();
                    if(x == -1)
                        exit = true;
                    if(x == 2)
                      {
                        c = this.getString();
                      }
                }
              }while(!exit); 
          } catch (IOException ex)
          {
              System.out.println("Erro na thread Connection");
          } 
        try
          {
            this.shutUser();
          } catch (IOException ex)
          {
              System.out.println("Erro ao fechar a thread");
          }
        System.out.println("Fim Thread - Bye!");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Notificado!!! Port = "+this.server.getLocalPort());
    }
}
