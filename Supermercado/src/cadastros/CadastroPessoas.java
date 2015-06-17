
package cadastros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pessoas.Pessoa;


public class CadastroPessoas{

    List<Pessoa> pessoas;

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public CadastroPessoas() {
        pessoas = new ArrayList<Pessoa>();

    }
    
    public Pessoa getUsuarioEspecifico(String nomeUsuario){
       
        return new Pessoa();
    }
    
}
