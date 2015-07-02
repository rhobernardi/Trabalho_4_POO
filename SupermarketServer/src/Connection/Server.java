
package Connection;

import cadastros.*;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import produtos.Produto;
import user.User;


public class Server extends Observable  implements Runnable {

    protected ServerSocket server;
    protected userConnection newConnection;
    protected List<SenderReceiver> Connections;
    protected List<Thread> ListThreads;
    
    protected List<Produto> ListaProdutos;
    protected List<User> ListaUser;
    
    protected int serverPort = 123;
    protected ServerSocket serverSocket = null;
    protected boolean isRunning = true;
    protected Thread runningThread = null;
    
    public UserCSV arquivoUsuarios;
    public ProductCSV arquivoProduto;
    
    
    

    public Server(int port) {
        this.serverPort = port;
        
        Connections = new ArrayList();
        ListThreads = new ArrayList();
        
        arquivoUsuarios = new UserCSV("src/regsitroUsuarios.csv");//Verificar Filepath
        
        String[] headerUser = new String [7];
        
        headerUser[0] = "NOME";
        headerUser[1] = "TELEFONE";
        headerUser[2] = "ENDERECO";
        headerUser[3] = "EMAIL";
        headerUser[4] = "ID";
        headerUser[5] = "SENHA";
        headerUser[6] = "PRODUTOS_COMPRADOS";
        
        arquivoUsuarios.createCSV(headerUser);
    }

    @Override
    public void run() {
        
        
        Thread newThread;
        userConnection novoUsuario;
        Observer novoObserver;
        int count = 0;
        
        
        isRunning = true;
        
        while(isRunning()) {
            try {  
                System.out.println("!!! SERVER !!! CONECTAR NA PORTA LIVRE: " +(serverPort+count));
                
                novoUsuario = WaitUserConnection(serverPort+count);
                System.out.println("Client has been connected...");
                
                
                
                newThread = new Thread(novoUsuario);
                Connections.add(novoUsuario);//Manter o Controle das Conexoes
                ListThreads.add(newThread);//Manter o Controle das Threads
                
                novoObserver = novoUsuario;
                this.addObserver(novoObserver);
                
                newThread.start();//INICIA SESSAO
                
            } catch (IOException e) {
                
                if(!isRunning()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
                
            }
           count++;
        }
        System.out.println("Server Stopped.") ;
    }

    private  boolean isRunning() {
        return this.isRunning;
    }

    public  void stop() {
        this.isRunning = false;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    public userConnection WaitUserConnection(int port) throws IOException{
        
        this.server = new ServerSocket(port);   
        
        System.out.println("Porta "+port+" Aberta");//Abre a Porta
        
        newConnection = new userConnection(this.server.accept(), this.server, arquivoUsuarios);//Cria um novo cliente e espera uma conexão... e espera...
        
        return (newConnection);
    }    
}