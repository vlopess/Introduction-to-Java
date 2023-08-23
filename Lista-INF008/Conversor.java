//5.Faça um Programa que converta metros para centímetros.

import java.util.Scanner;

public class Conversor{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int metro = scan.nextInt();
        System.out.println(metro + " metros é igual a " + metro*100 + " cm "); 
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    } 
  }
}