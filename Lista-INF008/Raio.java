//6.Faça  um  Programa  que  peça  o  raio  de  um  círculo,  calcule  e  mostre sua área.

import java.util.Scanner;

public class Raio{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o raio:");
        double r = scan.nextDouble();
        System.out.println("A área é igual a " + (Math.PI * Math.pow(r,2))); 
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    } 
  }
}