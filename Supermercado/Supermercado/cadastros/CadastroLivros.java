
package cadastros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import livros.Livro;

public class CadastroLivros extends InOutCSVfile{
	
    List<Livro> livros;

    public CadastroLivros(String livrosfile, String filePath) {
        super(filePath);
        String[] Reg = new String[4];
        Reg[0] = "Titulo";
        Reg[1] = "Ano";
        Reg[2] = "Edicao";
        Reg[3] = "Codigo";
        
        this.createCSV(Reg);
        
        livros = new ArrayList<Livro>();
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public Livro getLivroEspecifico(String codigo){
        for(Livro l : livros){
            if(l.toString().equalsIgnoreCase(codigo)){
                return l;
            }
        }
        return null;
    }
    
    @Override
    public void writeRegistro(String[] reg){
        if(this.OutputStream != null){
            try{
                escreverCampoTipo(reg[0]);
                this.OutputStream.append(',');
                escreverCampoTipo(reg[1]);
                this.OutputStream.append(',');
                escreverCampoTipo(reg[2]);
                this.OutputStream.append(',');
                escreverCampoTipo(reg[3]);
                this.OutputStream.append(System.lineSeparator());
        }
        catch(IOException ex){
            System.out.println("Falha ao Escrever no Arquivo");
        }
        }
 
    }
}
