/**
  ● Uma Tv é caracterizada pela marca, se é smart, se
está ligada (power), o canal do momento e a senha
do wifi se for smart.
  ● Uma TV comum é instanciada passando a marca e
para a smart uma senha padrão. O canal é 100.
  ● Existem vários modos de ligar a TV. Pelo próprio
aparelho (sem parâmetros), pelo controle remoto
(passa o canal ) e se for smart passamos a senha.
  ● Retorna-se true ou false. Uma Tv comum não pode
ser ligada como uma smart.
 * @author (Victor Lopes dos Santos) 
 */
public class Tv
{
    private String marca;
    private boolean smart;
    private String senha;
    private int canal = 100;
    private boolean power = false;
    
    public Tv(String marca){
        this.marca = marca;
        this.senha = null;
        this.smart = false;
    }
    
    public Tv(String marca, String senha)
    {
        this.marca = marca;
        this.senha = senha;
        this.smart = true;
    }

    public boolean ligar()
    {
        return this.power = true;
    }
    
    public boolean ligar(int canal)
    {
        this.canal = canal;
        return this.power = true;
    }
    
    public boolean ligar(int canal, String senha)
    {
        if(this.smart && this.senha.equals(senha)){
           this.canal = canal;
           return this.power = true;
        }         
        return false;
        
    }
    public String toString(){
      return "Marca: " + this.marca + "\nSmart: " + this.smart + "\nCanal: " + this.canal + "\nLigada: " + this.power;
    }
    
}
