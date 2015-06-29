
package cadastros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import produtos.Produto;
import user.User;

public class LeituraCSV {
    
    public static ArrayList<Produto> LeituraProdutosCSV() {
        
        ArrayList<Produto> list = new ArrayList<Produto>();	
	try {
            BufferedReader br = new BufferedReader(new FileReader("./products.csv"));
	    String dataP;
	    while((dataP = br.readLine()) != null) {    
                Produto pr = new Produto();
                list.add(pr.csv(dataP));
            }
            
	    br.close();        
	} catch(Exception e){ System.out.println("Erro. Arquivo CSV 'products.csv' não encontrado."); }
	
        return list;
    }
    
    public static ArrayList<User> LeituraUsersCSV() {
	
        ArrayList<User> list = new ArrayList<User>();
	try {
            BufferedReader br = new BufferedReader(new FileReader("./users.csv"));
	    String dataU;
            
	    while((dataU = br.readLine()) != null) {
                User user = new User();
                list.add(user.csv(dataU));
	    }
	        
	    br.close();
	} catch(Exception e){ e.printStackTrace(); System.out.println("Erro. Arquivo CSV 'users.csv' não encontrado."); }
	
        return list;
    }
}
