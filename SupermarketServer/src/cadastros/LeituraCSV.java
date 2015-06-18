
package cadastros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import produtos.Produto;
import user.User;

public class LeituraCSV {
    public static ArrayList<Produto> LeituraProdutosCSV()
    {
        ArrayList<Produto> list = new ArrayList<Produto>();
		
	try 
        {
            BufferedReader br = new BufferedReader(new FileReader("data_csv/products.csv"));
	    String dataP;
	    while((dataP = br.readLine()) != null) 
            {    
                String[] val = dataP.split(",");
            
                list.add(new Produto(dataP));
            }
            
	    br.close();        
	} catch(IOException e){ System.out.println("Erro. Arquivo CSV 'products.csv' não encontrado."); }
	
        return list;
    }
    
    public static ArrayList<User> LeituraUsersCSV()
    {
	ArrayList<User> list = new ArrayList<User>();
		
	try
	{
            BufferedReader br = new BufferedReader(new FileReader("data_csv/users.csv"));
	    String dataU;
	    while((dataU = br.readLine()) != null)
	    {
                String[] val = dataU.split(",");
	        	
//	        if(val[0].equals("Community"))
//                    list.add(new Community(val));
//	        else if(val[0].equals("Professor"))
//                    list.add(new Professor(val));
//	        else if(val[0].equals("Student"))
//                    list.add(new Student(val));
	    }
	        
	    br.close();
	} catch(IOException e){ e.printStackTrace(); System.out.println("Erro. Arquivo CSV 'users.csv' não encontrado."); }
	
        return list;
    }
}
