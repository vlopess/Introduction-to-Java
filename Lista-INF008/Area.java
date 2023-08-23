//7. Faça um Programa que calcule a área de um quadrado, em seguida mostre o dobro desta área para o usuário.

import java.util.Scanner;

public class Area{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o lado:");
        double l = scan.nextDouble();
        System.out.println("A área é igual a " + l * l); 
        System.out.println("O dobro da área é igual a " + (l * l) * 2); 
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    } 
  }
}