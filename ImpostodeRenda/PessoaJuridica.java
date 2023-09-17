public class PessoaJuridica extends Contribuinte{
  private String cnpj;

  public String getCnpj(){
    return cnpj;
  }

  public void setCnpj(String cnpj){
    this.cnpj = cnpj;
  }

  public double calcularImposto(){
    return this.getRendaBruta() * 0.1;
  }

  public String toString(){
    String resultado = "Pessoa Jurídica\n";
    resultado += super.toString();
    resultado += "\nCnpj : "+cnpj;
    resultado += "\nImposto a pagar : "+calcularImposto();  
    return resultado;
  }
}