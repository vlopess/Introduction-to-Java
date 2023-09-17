import java.util.Scanner;

public class AnimalDemo{
  public static void main(String[] args) {

    Animal camelo = new Animal();
    camelo.setNome("Camelo");
    camelo.setComprimento(150);
    //camelo.setPatas(4);
    camelo.setCor("Amarelo");
    camelo.setAmbiente("Terra");
    camelo.setVelocidade(2);
    
    Peixe tubarao = new Peixe();
    tubarao.setNome("Tubarão");
    tubarao.setComprimento(300);
    tubarao.setVelocidade(1.5);
    
    Mamifero urso = new Mamifero();
    urso.setNome("Urso-do-canadá");
    urso.setComprimento(180);
    urso.setCor("Vermelho");
    urso.setVelocidade(0.5);
    
    Animal[] animais = new Animal[3];
    animais[0] = camelo;
    animais[1] = tubarao;
    animais[2] = urso;
    
    System.out.println("-----------------------");
    for (Animal animal : animais){
        System.out.println(animal);
        System.out.println("-----------------------");
    }
    // Scanner scan = new Scanner(System.in);
    // System.out.println("Digite o animal:");
    // String animal = scan.next();
    // System.out.println("Digite o comprimento:");
    // int comprimento = scan.nextInt();
    // System.out.println("Digite a qtd patas:");
    // int patas = scan.nextInt();
    // System.out.println("Digite a cor:");
    // String cor = scan.next();
    // System.out.println("Digite o ambiente:");
    // String ambiente = scan.next();
    // System.out.println("Digite a velocidade:");
    // Double velocidade = scan.nextDouble();
    // Animal animal1 = new Animal(animal, comprimento, patas, cor, ambiente, velocidade);
    // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
    // System.out.println("Digite o animal:");
    // animal = scan.next();
    // System.out.println("Digite o comprimento:");
    // comprimento = scan.nextInt();
    // System.out.println("Digite a qtd patas:");
    // patas = scan.nextInt();
    // System.out.println("Digite a cor:");
    // cor = scan.next();
    // System.out.println("Digite a velocidade:");
    // velocidade = scan.nextDouble();    
    // System.out.println("Digite as caracteristicas:");
    // String caracteristicas = scan.nextLine();
    // scan.nextLine();
    // Peixe animal2 = new Peixe(animal, comprimento, patas, cor, velocidade, caracteristicas);
    // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
    // System.out.println("Digite o animal:");
    // animal = scan.next();
    // System.out.println("Digite o comprimento:");
    // comprimento = scan.nextInt();
    // System.out.println("Digite a qtd patas:");
    // patas = scan.nextInt();
    // System.out.println("Digite a cor:");
    // cor = scan.next();
    // System.out.println("Digite o ambiente:");
    // ambiente = scan.next();
    // System.out.println("Digite a velocidade:");
    // velocidade = scan.nextDouble();    
    // System.out.println("Digite o alimento:");
    // String alimento = scan.next();
    // Mamifero animal3 = new Mamifero(animal, comprimento, patas, cor, ambiente,velocidade, alimento);
    // System.out.println("Zoo");  
    // System.out.println("__________________________");  
    // imprimir(animal1);
    // System.out.println("__________________________");    
    // imprimir(animal2);
    // System.out.println("__________________________");    
    // imprimir(animal3);    
    // System.out.println("__________________________");    
  }

  public static void imprimir(Animal a){
    System.out.println(a.toString());
  }
}