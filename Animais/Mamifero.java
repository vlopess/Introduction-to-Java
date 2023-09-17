public class Mamifero extends Animal{
  private String alimento;

  Mamifero(){
    super();
    this.setCor("Castanho");
    this.setAmbiente("Terra");
    this.alimento = "Mel";
  }
  Mamifero(String nome,int comprimento, int patas,String cor,String ambiente,Double velocidade,String alimento){
super(nome,comprimento,patas,cor,ambiente,velocidade);
    this.alimento = alimento;
  }

  public String getAlimento(){
    return alimento;
  }

  public void setAlimento(String alimento){
    this.alimento = alimento;
  }
  
  public String toString(){
    String resultado = super.toString();
    resultado += "\nAlimento: " + alimento;
    return resultado;
  }
}