//2.Faça   um Programa   que   peça   um   número   e   então   mostre   a mensagem O número informado foi [número].
import java.util.Scanner;

public class Number{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int number = scan.nextInt();
        System.out.println("O número informado foi " + number); 
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    }  
  }
}