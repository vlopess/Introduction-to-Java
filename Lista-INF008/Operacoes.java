//11.Faça um Programa que peça 2 números inteiros e um número real. Calcule e mostre: a. o produto do dobro do primeiro com metade do segundo . b. a soma do triplo do primeiro com o terceiro. c. o terceiro elevado ao cubo.

import java.util.Scanner;

public class Operacoes{
  public static void main(String[] args){
    try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um numero inteiro:");
        int number1 = scan.nextInt();
        System.out.println("Digite outro numero inteiro:");
        int number2 = scan.nextInt();
        System.out.println("Digite um numero real:");
        double number = scan.nextDouble();
        System.out.println("O produto do dobro do primeiro com metade do segundo: " + ((number1 * 2)*(number2/2)));
        System.out.println("A soma do triplo do primeiro com o terceiro: " + ((number1 * 3) + number));
        System.out.println("O terceiro elevado ao cubo: "+ Math.pow(number, 3));
    } catch(Exception e){
        System.out.println("Não é um numero"); 
    }  
  }
}