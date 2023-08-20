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