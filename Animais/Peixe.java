public class Peixe extends Animal{
  private String caracteristicas;

  Peixe(){
    super();
    this.setPatas(0);
    this.setAmbiente("Mar");
    this.setCor("Cinzento");
    this.caracteristicas = "Barbatanas e cauda";
  }
  Peixe(String nome,int comprimento, int patas,String cor,Double velocidade,String caracteristicas){    super(nome,comprimento,patas,cor,"Mar",velocidade);
    this.caracteristicas = caracteristicas;
  }

  public String getCaracteristicas(){
    return caracteristicas;
  }

  public void setCaracteristicas(String caracteristicas){
    this.caracteristicas = caracteristicas;  
  }
  
  public String toString(){
    String resultado = super.toString();
    resultado += "\nCaracteristica: " + caracteristicas;
    return resultado;    
  }
} 

