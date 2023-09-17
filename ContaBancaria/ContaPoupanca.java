public class ContaPoupanca extends ContaBancaria {
  private int diaRendimento;

  ContaPoupanca(String nomeCliente, String numConta, double saldo,int diaRendimento){
    super(nomeCliente,numConta,saldo);
    this.diaRendimento = diaRendimento;
  }

  public int getDiaRendimento(){
    return diaRendimento;
  }
  public void setDiaRendimento(int diaRendimento){
    this.diaRendimento = diaRendimento;
  }
  
  public void calcularNovoSaldo(double taxa) throws Exception{
    if(taxa > 0 ){
      double saldo=this.getSaldo();
      saldo = (saldo*taxa/100);
      this.depositar(saldo);
    }else{
      throw new Exception();
    }
  }

  public String toString(){
    String resultado = super.toString();
    resultado += "\nDia de rendimento: " + diaRendimento; 
    return resultado;
  }
}