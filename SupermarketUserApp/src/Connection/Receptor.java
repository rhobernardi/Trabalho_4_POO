
package Connection;

import java.io.InputStream;
import java.util.Scanner;


public class Receptor implements Runnable {

    private InputStream servidor;

    public Receptor(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}