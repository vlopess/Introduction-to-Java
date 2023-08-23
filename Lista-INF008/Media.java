//4.Faça um Programa que peça as 4 notas bimestrais e mostre a média.

import java.util.Scanner;

public class Media{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        int notas = 0;
        for(int i = 0 ; i < 4 ; i++){
          System.out.println("Digite a "+ (i + 1) +"º nota:");
          int nota = scan.nextInt();
          notas += nota;
        }
        System.out.println("A média das notas é " + notas/4); 
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    } 
  }
}