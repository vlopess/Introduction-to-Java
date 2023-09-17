public class ContaEspecial extends ContaBancaria {
  private int limite;
  ContaEspecial(String nomeCliente, String numConta, double saldo,int limite){
    super(nomeCliente,numConta,saldo);
    this.limite = limite;
  }

  public double getLimite(){
    return limite;
  }

  public void setLimite(double limite){
    this.limite = limite;
  }
   
  public void sacar(double valor) throws Exception{
    if(valor < (limite + this.getSaldo())){
      this.setSaldo(this.getSaldo() - valor);
    }else{      
      throw new Exception();
      // System.out.println("Erro ao sacar o dinheiro, valor maior que o limite");
    }
  }
  
  public String toString(){
    String resultado = super.toString();
    resultado += "\nLimite: " + limite; 
    return resultado;
  }
}
