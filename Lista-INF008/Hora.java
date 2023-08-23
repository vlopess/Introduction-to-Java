//8. Faça um Programa que pergunte quanto você ganha por hora e o número de horas trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês.

import java.util.Scanner;

public class Hora {
  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in);
      System.out.println("Quanto você ganha por hora?");
      double valuePerHour = scan.nextDouble();
      System.out.println("Quantas horas vc trabalha no mês?");
      double hours = scan.nextDouble();
      System.out.println("Salário: R$ " + (valuePerHour * hours));      
    } catch (Exception e) {
      System.out.println("Não é um numero");
    }
  }
}