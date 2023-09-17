import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileManager {

    private String path = "Files/";
    
    public void createDirectory(String directoryName) {
      try{
        File diretorio = new File(path + directoryName);
        if(diretorio.exists()){
          System.out.println("Diretório já existente");
        }
        if(diretorio.mkdir()){
          System.out.println("Diretório criado");
        }else{
          System.out.println("Diretório não criado");
        }
      }catch(Exception e) {
        System.out.println("Erro ao criar o diretório");
      }
    }

  
    public void createFile(String directoryPath, String fileName) {
        String caminho = path +  directoryPath + "/" + fileName;
        try{
          File diretorio = new File(path + directoryPath);
          if(!diretorio.exists()){
            System.out.println("Diretório não existe");
          }else{
            File arquivo = new File(caminho);
            if(arquivo.createNewFile()){
              System.out.println("Arquivo criado com sucesso!");
              FileWriter writer = new FileWriter(arquivo);
              Scanner scan = new Scanner(System.in);
              System.out.println("Escreva:");
              String input = scan.nextLine();
              writer.write(input);
              writer.close();
            }else{
              System.out.println("Já existe arquivo com esse nome!");          
            }
          }
          
        }catch(IOException e){
          System.out.println("Erro ao criar o arquivo");
        }
    }
    
    public void listContents() {
      File diretorio = new File(path);      
      File[] arquivos = diretorio.listFiles();
      if(arquivos != null){
        for(File arq : arquivos){
          System.out.print(arq.getName());
          File dir = new File(path + arq.getName());
          if(dir.isDirectory()){
            System.out.println("/");            
            listContents(arq.getName());
          }
        }          
      }              
    }

    public void listContents(String directoryPath) {
      String caminho = path + directoryPath;
      File diretorio = new File(caminho);
      if(diretorio.isDirectory()){
        File[] arquivos = diretorio.listFiles();
        if(arquivos != null){
          for(File arq : arquivos){
            System.out.println("  "+arq.getName());    
          }          
        }        
      }else{
        System.out.println("Não há um diretório com esse nome");    
      }
      
    }
  
    public void delete(String path) {
    }
}