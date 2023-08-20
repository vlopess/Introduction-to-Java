public class Cliente{
  public String nome;
  public int idade;

  public Cliente(String nome, int idade){
    this.nome = nome;
    this.idade = idade;
  }

  public String valueTicket(int day){

    if(this.idade < 14 || this.idade > 65 || day == 4 || day == 5){
      return "R$6,00";
    }
    
    return "R$12,00";
  }
  
  
}