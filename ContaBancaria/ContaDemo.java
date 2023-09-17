import java.util.Scanner;

class ContaDemo {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Digite o seu nome:");
    String nome = scan.next();
    System.out.println("Digite o número da conta:");
    String num = scan.next();
    System.out.println("Digite o saldo:");
    double saldo = scan.nextDouble();
    ContaBancaria cb1 = new ContaBancaria(nome, num, saldo);
    System.out.println(cb1.toString());
    cb1.sacar(100);
    System.out.println(cb1.toString());
    cb1.depositar(1000);
    System.out.println(cb1.toString());
    cb1.sacar(100000);
    System.out.println(cb1.toString());

    System.out.println("##################");
    System.out.println("Digite o seu nome:");
    nome = scan.next();
    System.out.println("Digite o número da conta:");
    num = scan.next();
    System.out.println("Digite o saldo:");
    saldo = scan.nextDouble();
    System.out.println("Digite o dia de rendimento:");
    int dia = scan.nextInt();
    ContaPoupanca cb2 = new ContaPoupanca(nome, num, saldo, dia);
    System.out.println(cb2.toString());
    cb2.sacar(100);
    System.out.println(cb2.toString());
    cb2.depositar(1000);
    System.out.println(cb2.toString());
    cb2.sacar(100000);
    System.out.println(cb2.toString());

    System.out.println("##################");    
    System.out.println("Digite o seu nome:");
    nome = scan.next();
    System.out.println("Digite o número da conta:");
    num = scan.next();
    System.out.println("Digite o saldo:");
    saldo = scan.nextDouble();
    System.out.println("Digite o limite:");
    int limite = scan.nextInt();    
    ContaEspecial cb3 = new ContaEspecial(nome, num, saldo, limite);
    System.out.println(cb3.toString());
    cb3.sacar(100);
    System.out.println(cb3.toString());
    cb3.depositar(1000);
    System.out.println(cb3.toString());
    cb3.sacar(100000);
    System.out.println(cb3.toString());
    
    
    
  }
}