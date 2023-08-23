//3.Faça um Programa que peça dois números e imprima a soma.
import java.util.Scanner;

public class Soma{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int number1 = scan.nextInt();
        System.out.println("Digite outro numero:");
        int number2 = scan.nextInt();
        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2)); 
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    } 
  }
}