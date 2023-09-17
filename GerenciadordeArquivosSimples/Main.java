import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Scanner scan = new Scanner(System.in);
        boolean controle = true;
        while(controle){
        	System.out.println();
          System.out.println("_______________________");          
          System.out.println("Digite a ação desejada:");
          System.out.println("_______________________");
          System.out.println("[1] Criar arquivo");
          System.out.println("[2] Criar diretório");
          System.out.println("[3] Listar arquivos de um diretório");
          System.out.println("[4] Listar tudo");
          System.out.println("[0] Sair");
          int option = scan.nextInt();
          switch(option){
            case 0:{
              controle = false; 
              break;
            }
            case 1:{
              System.out.println("Digite o nome do diretório:");
              String nomedir = scan.next();
              System.out.print("Digite o nome do arquivo:");
              String nomearq = scan.next();
              fileManager.createFile(nomedir,nomearq);
              break;
            }
            case 2:{              
              System.out.println("Digite o nome do diretório:");
              String nomedir = scan.next();
              fileManager.createDirectory(nomedir);
              break;
            }
            case 3:{              
              System.out.println("Digite o nome do diretório:");
              String nomedir = scan.next();
              fileManager.listContents(nomedir);
              break;
            }
            case 4:{              
              fileManager.listContents();
              break;
            }
          }

        }
    }
}