/**
Construir uma classe em java PARIMPAR. Esta classe tem um unico atributo, o atributo par que é um booleano.  A classe temum método que recebe um parâmetro limite  e laço (inteiros). Se o atributo par for true o método imprime na tela os números pares de 0 até o limite. Se par for false, são os números impares que devem ser impressos. Além disto, se o laço for igual a 1, a lista deve ser gerada através de um comando for, se for 2 com um comando while, e se 3 com um comando do while. Caso laço seja diferente de 1,2 ou 3 imprimir uma mensagem opção inválida.
**/

public class Parimpar{
  public boolean par;

  public Parimpar(boolean value){
    this.par = value;
  }

  public void iterar(int limite, int laco){
    int x = par ? 0 : 1;
    switch(laco){
      case 1: 
        for(int i = 0 + x; i < limite; i = i + 2)
          System.out.println(i);
        break;        
      case 2: 
        int c = 0 + x;
        while(c < limite){
          System.out.println(c);          
          c = c + 2;
        }
        break;
      case 3: 
        int h = 0 + x;
        do{
          System.out.println(h);          
          h = h + 2;
        }while(h < limite);
        break;
      default:
        System.out.println("Opção Inválida!");
    }
  }
}