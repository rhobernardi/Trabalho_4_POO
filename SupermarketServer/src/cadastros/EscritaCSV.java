
package cadastros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import produtos.Produto;
import user.User;

public class EscritaCSV {
    
    public static void EscritaProdutoCSV(ArrayList<Produto> list)
    {
        try
	{
            FileWriter fw = new FileWriter("data_csv/products.csv");
            for(Produto p : list)
            {
		fw.append(p.toString());
		fw.append("\n");
            }
            
            fw.flush();
            fw.close();
            
	} catch(IOException e) { System.out.println("Erro. Arquivo CSV 'products.csv' não encontrado."); }
    }
	
    public static void WriteCSVUsers(ArrayList<User> list)
    {
	try
	{
            FileWriter fw = new FileWriter("data_csv/users.csv");
            for(User u : list)
            {
//		if(us instanceof Professor)
//                    fw.append("Professor");
//		else if(us instanceof Community)
//                    fw.append("Community");
//                else
//                    fw.append("Student");
				
		fw.append(",");
		fw.append(u.toString());
		fw.append("\n");
            }
			
            fw.flush();
            fw.close();
            
        } catch(IOException e){ System.out.println("Erro. Arquivo CSV 'users.csv' não encontrado."); }
    }
}
