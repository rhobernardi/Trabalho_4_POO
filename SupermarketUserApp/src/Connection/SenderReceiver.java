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


public interface SenderReceiver {
    public enum userType{
    Host,
    Client;
}
        public int getCommand () throws IOException;
        public String getString() throws IOException;
        public void sendCommand(int cmd);
        public void sendString(String c);
        public userType getType();
        public void setType(userType Type);

}
