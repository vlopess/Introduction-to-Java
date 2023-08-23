//9. Faça um Programa que peça a temperatura em graus Farenheit, transforme e mostre a temperatura em graus Celsius. C = (5 * (F-32) / 9).

import java.util.Scanner;

public class Temperatura {

  public static void toCelsius(double f){
    double celsius = (5 * (f - 32))/9;
    System.out.println("Celsius: " + celsius);
  }

  public static void toFarenheit(double c){
    double farenheit = ((9 * c)/5) + 32;
    System.out.println("Farenheit: " + farenheit);
  }
  
  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in);
      System.out.println("Digite a temperatura em Farenheit:");
      double value = scan.nextDouble();
      toCelsius(value);
      System.out.println("Digite a temperatura em Celsius:");
      value = scan.nextDouble();   
      toFarenheit(value);
    } catch (Exception e) {
      System.out.println("Não é um numero");
    }
  }
}