/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Guilherme
 */
public abstract class InOutCSVfile implements CSVfileInterface {
    
    
    FileReader InputStream;
    FileWriter OutputStream;
    
    File   file;
    String filePath;
    
    String[] Campos;

    public InOutCSVfile(String filePath) {
        this.filePath = filePath;
        this.InputStream = null;
        this.OutputStream = null;
        
        try
          {
            this.file = new File(filePath);
            this.file.createNewFile();
          } catch (IOException ex)
          {
            System.out.println("Arquivo e leitores nao abriram");
          }  
    }
    
    @Override
      public void ativarWriteMode(){
          try{
                if(this.InputStream != null)
                  {
                    this.InputStream.close();
                    this.InputStream = null;
                  }
                this.OutputStream = new FileWriter(file);
          }catch(IOException ex){
              System.out.println("Erro ao trocar o modo Leitura/Escrita");
          }
    }
    
    @Override
      public void ativarReadMode(){
          try{
                if(this.OutputStream != null)
                  {
                    this.OutputStream.close();
                    this.OutputStream = null;
                  }
                this.InputStream = new FileReader(file);
          }catch(IOException ex){
              System.out.println("Erro ao trocar o modo Leitura/Escrita");
          }
    }
    
    public void createCSV(String[] Campos ){
        
        int i;
        this.Campos = Campos;
        
        String[] reg;
        this.ativarReadMode();
        reg = this.readRegistroCSV();
        boolean cond = true;
        for(i = 0; i<this.Campos.length;i++){
            
            if(reg[i].compareTo(this.Campos[i]) != 0)
                cond = false;
        }
        if(!cond){
            this.ativarWriteMode();
            if(this.OutputStream != null){
                try{
                    for(i = 0; i<this.Campos.length-1; i++){
                        escreverCampoTipo(this.Campos[i]);
                        this.OutputStream.write(',');
                    }
                    escreverCampoTipo(this.Campos[i]);
                    this.OutputStream.write('\n');
                }
                catch(IOException ex){
                    System.out.println("Falha ao Escrever no Arquivo");
                }
            }
            //this.closeCSV();
        }
            
    }
    
    public void escreverCampoComentario(String Comment){
        int i;
        if(this.OutputStream != null)
          {
            try{
                this.OutputStream.append('"');
                for(i = 0; i< Comment.length();i++){
                    if(Comment.charAt(i) == '"')
                        this.OutputStream.append('"');
                    this.OutputStream.append(Comment.charAt(i));
                }
                this.OutputStream.append('"');
            }catch(IOException ex){
                System.out.println("Falha ao Escrever no Arquivo");
            }
          }
    }
    
    public void escreverCampoTipo(String Tipo){
        
        int i, j;
        if(this.OutputStream != null){
            try{
            for(i = 0; i< Tipo.length();i++){
                this.OutputStream.append(Tipo.charAt(i));
            }
            
        }catch(IOException ex){
            System.out.println("Falha ao Escrever no Arquivo");
        }
        }
        
        
    }
    
    @Override
    public abstract void writeRegistro(String[] reg);
    
    public void TestewriteRegistro(String[] reg){
        if(this.OutputStream != null){
            try{
                escreverCampoTipo(reg[1]);
                this.OutputStream.append(',');
                escreverCampoTipo(reg[2]);
                this.OutputStream.append(',');
                escreverCampoComentario(reg[3]);
                this.OutputStream.append(',');
                escreverCampoTipo(reg[4]);
                this.OutputStream.append(System.lineSeparator());
        }
        catch(IOException ex){
            System.out.println("Falha ao Escrever no Arquivo");
        }
        }
 
    }
    
    @Override
    public String[] readRegistroCSV(){
            
            String[] dados = new String[this.Campos.length];
            boolean quotes;
            boolean cond;
            char r;
            
            if(this.InputStream != null){
                try{
                for(int i = 0; i<this.Campos.length; i++){
                    String buff = new String();
                    quotes = false;
                    cond = false;
                    do{
                        r = (char)this.InputStream.read();
                        if(r != ',' && r != (char)-1 && r!='\n'){
                                if(r == '"'){
                                    if(!cond){
                                        buff = buff + r;
                                        cond = !cond;
                                        quotes = true;
                                      }
                                    else 
                                        cond = !cond;
                                }
                                else{
                                        buff = buff + r;
                                }
                        }                                            
                    }while(r != ',' && r != (char)-1 && r!='\n');
                    if(quotes){
                        r = '"';
                        buff = buff + r;    
                    }
                    dados[i] = buff;
                }
                }catch(IOException ex){
                System.out.println("Falha ao Ler o Arquivo");
                }
            }
            return(dados);
        }
    
    @Override
            public void closeCSV(){
                try{
                if(this.InputStream!=null){
                    this.InputStream.close();
                    this.InputStream = null;
                }
                if(this.OutputStream!=null){
                    this.OutputStream.close();
                    this.OutputStream = null;
                }
                }catch(IOException ex){
                    System.out.println("Erro ao fechar as streams");
                }
            }

}
