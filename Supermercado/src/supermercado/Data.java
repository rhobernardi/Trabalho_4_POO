
package supermercado;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
    private String dia;
    private String mes;
    private String ano;
    
    public String getDay()
    {
        DateFormat day = new SimpleDateFormat("dd");
	Date date = new Date();
        
	return day.format(date);
    }
    
    public String getMonth()
    {
        DateFormat month = new SimpleDateFormat("MM");
	Date date = new Date();
        
	return month.format(date);
    }
    
    public String getYear()
    {
        DateFormat year = new SimpleDateFormat("yyyy");
	Date date = new Date();
        
	return year.format(date);
    }
    
    public static String getDate() {
	DateFormat day = new SimpleDateFormat("dd");
        DateFormat month = new SimpleDateFormat("MM");
        DateFormat year = new SimpleDateFormat("yyyy");
	Date date = new Date();
	return day.format(date) + "/" + month.format(date) + "/" + year.format(date);
    }
    
    public static String getDateDevolucao(int i){
        DateFormat day = new SimpleDateFormat("dd"+i);
        DateFormat month = new SimpleDateFormat("MM");
        DateFormat year = new SimpleDateFormat("yyyy");
	Date date = new Date();
	return day.format(date) + "/" + month.format(date) + "/" + year.format(date);
    }
}
