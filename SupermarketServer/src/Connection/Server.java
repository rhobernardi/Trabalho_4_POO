
package Connection;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;


public class Server implements Runnable {

    protected int serverPort = 12332;
    protected ServerSocket serverSocket = null;
    protected boolean isRunning = true;
    protected Thread runningThread = null;

    public Server(int port) {
        this.serverPort = port;
    }

    @Override
    public void run() {
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        
        while(isRunning()) {
            Socket clientSocket = null;
            //System.out.println("Server running...");
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(!isRunning()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            new Thread( new DataHandle(clientSocket, "Welcome to the SupermarketWebServer") ).start();
            System.out.println("Client has been connected...");
        }
        System.out.println("Server Stopped.") ;
    }

    private synchronized boolean isRunning() {
        return this.isRunning;
    }

    public synchronized void stop() {
        this.isRunning = false;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port" + this.serverPort, e);
        }
    }
}