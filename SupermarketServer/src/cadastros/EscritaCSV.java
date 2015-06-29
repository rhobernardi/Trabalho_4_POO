
package cadastros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import produtos.Produto;
import user.User;

public class EscritaCSV {
    
    public static void EscritaProdutoCSV(ArrayList<Produto> list)
    {
        try {
            FileWriter fw = new FileWriter("products.csv");
            
            for(Produto pr : list) {
		fw.append(pr.toString());
		fw.append("\n");
            }
            
            fw.flush();
            fw.close();
	} catch(Exception e) { System.out.println("Erro. Arquivo CSV 'products.csv' não encontrado."); }
    }
	
    public static void EscritaCSVUsers(ArrayList<User> list)
    {
	try {
            FileWriter fw = new FileWriter("users.csv");
            
            for(User u : list) {
		fw.append(u.toString());
		fw.append("\n");
            }
			
            fw.flush();
            fw.close();
        } catch(Exception e){ System.out.println("Erro. Arquivo CSV 'users.csv' não encontrado."); }
    }
}
