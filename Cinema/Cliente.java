/**
Construir uma classe que represente os clientes de um cinema. Todo cliente possui os atributos nome e idade. Construir um construtor para a classe e um método para calculo do valor do ingresso sabendo-se que:
- Crianças (menos 14 anos) e idosos (mais de 65 anos) pagam meia entrada R$ 6,00
- Existe uma promoção onde todos pagam meia nas quartas e quintas feiras.
- Receber como argumento o dia da semana e retornar o valor do ingresso.
**/

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