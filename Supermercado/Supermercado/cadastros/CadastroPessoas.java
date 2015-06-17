
package cadastros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pessoas.Pessoa;


public class CadastroPessoas extends InOutCSVfile{

    List<Pessoa> pessoas;

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public CadastroPessoas(String pessoasfile, String filePath) {
        super(filePath);
        String[] Campos = new String[4];
        Campos[0] = "Nome";
        Campos[1] = "Cidade";
        Campos[2] = "Idade";
        Campos[3] = "Estado";
        
        this.createCSV(Campos);
        
        pessoas = new ArrayList<Pessoa>();

    }
    
    public Pessoa getUsuarioEspecifico(String nomeUsuario){
        for(Pessoa p : pessoas){
            if(p.toString().equalsIgnoreCase(nomeUsuario)){
                return p;
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
