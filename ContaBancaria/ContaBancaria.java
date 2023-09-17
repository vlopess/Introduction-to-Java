public class ContaBancaria{
  private String nomeCliente;
  private String numConta;
  private double saldo;

  ContaBancaria(String nomeCliente, String numConta){
    this.nomeCliente = nomeCliente;
    this.numConta = numConta;
    this.saldo = 0;    
  }
  ContaBancaria(String nomeCliente, String numConta, double saldo){
    this.nomeCliente = nomeCliente;
    this.numConta = numConta;
    this.saldo = saldo;    
  }

  public String getNomeCliente(){
    return this.nomeCliente;
  }

  public void setNomeCliente(String nomeCliente){
    this.nomeCliente = nomeCliente;
  }
  
  public String getNumConta(){
    return this.numConta;
  }
  public double getSaldo(){
    return this.saldo;
  }

  public boolean sacar(double valor){
    if(valor <= this.saldo){
      this.saldo -= valor;
      return true;
    }
    return false;
    // else{
    //   System.out.println("Erro ao sacar o dinheiro, valor maior que o saldo");
    // }
  }


  public void depositar(double valor){
    if(valor > 0){
      this.saldo += valor;
    }else{
      System.out.println("Erro ao depositar valor negativo");
    }    
  }

  public String toString(){
    return "Nome do cliente: " + nomeCliente + "\nNúmero da conta: " + numConta + "\nSaldo: R$ " + saldo;
  }
  
}