/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import cadastros.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


/**
 *
 * @author Guilherme
 */
public class userConnection extends UserTCP implements Observer, Runnable{
    
    ServerSocket server;
    UserCSV arquivoUsuarios;
    boolean permissao;
    
    public userConnection(Socket client, ServerSocket server, UserCSV arquivoUsuario){
        this.client = client;
        this.server = server;
        this.arquivoUsuarios = arquivoUsuario;
        this.permissao = false;
        
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
        
        //ObsServer.deleteObserver(this);
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
                    processCMD(x);
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
    
    private void processCMD(int x) throws IOException{
        String s;
        
        
        switch(x){
            case -1://Desconectar
                break;
            case 1://Login
                this.permissao = Login();
                
                break;
            case 2://Cadastro
                s = this.getString();
                CadastrarUsuario(s);
                this.permissao = true;
                break;
            case 3:
                if(permissao)
                  {
                    
                  }
                break;
            case 4:
                if(permissao)
                  {
                    
                  }
                break;
            case 5:
                if(permissao)
                  {
                    
                  }
                
                break;

        }
        
    }
    
    private synchronized void CadastrarUsuario(String s){
        
        String[] c = new String[arquivoUsuarios.nCampos];
        String buff;
        
        int i = 0;
        int j;
        boolean cond = true;
        for(j = 0; j<arquivoUsuarios.nCampos; j++)
          {
              cond = true;
              buff = new String();
              do{
                  if(i<s.length()){
                      if(s.charAt(i)!= ',')
                            buff = buff + s.charAt(i);
                      else
                          cond = !cond;
                    i++;
                  }
                  else
                      cond = !cond;
              }while(cond);
              c[j] = buff;
          }
        
        arquivoUsuarios.ativarWriteMode();
        arquivoUsuarios.writeRegistro(c);
    }
    
    private synchronized boolean Login(){
        String Id;
        String psw;
        String[] Registro;
        boolean perm = false;
        boolean cond = false;
        
        
        try{
        Id = this.getString();
        psw = this.getString();
        
        while(!cond)
          {
            Registro = arquivoUsuarios.readRegistroCSV();
            if(Registro[4].compareTo(Id) == 0 && Registro[5].compareTo(psw) == 0)
              {
                perm = true;
                cond = true;
              }
          }     
        }catch(IOException e){
            System.out.println("Falha na cconcexao com o Client");
        }
        return perm;
    }
    
    
}
