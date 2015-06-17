/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

/**
 *
 * @author Guilherme
 */
public interface CSVfileInterface {
    
        public void writeRegistro(String[] reg);
        public String[] readRegistroCSV();
        public void ativarWriteMode();
        public void ativarReadMode();
        public void closeCSV();

    
}
