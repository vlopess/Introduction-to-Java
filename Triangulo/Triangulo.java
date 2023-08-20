/**
Criar uma classe que represente um triangulo. Esta
classe possuirá os atributos a, b e c (lados do
triângulo). Caso o objeto seja instanciado apenas
com um parâmetro, o triângulo deverá ser eqüilátero
(três lados iguais), caso o objeto seja instanciado
com dois parâmetros, o triângulo deverá ser
isósceles e o primeiro parâmetro indicará o tamanho
de a e b, caso haja três parâmetros na iniciação do
objeto, o triângulo é escaleno.
**/

public class Triangulo
{
    // instance variables - replace the example below with your own
    private double a;
    private double b;
    private double c;
    private String tipo;

    /**
     * Constructor for Triangulo equilatero
     */
    public Triangulo(double a)
    {
        this.a = a;
        this.b = a;
        this.c = a;
        this.tipo = "Equilatero";
    }
    /**
     * Constructor for Triangulo isósceles
     */
    public Triangulo(double a, double b)
    {
        this.a = a;
        this.b = a;
        this.c = b;
        this.tipo = "Isósceles";
    }
    /**
     * Constructor for Triangulo escaleno.
     */
    public Triangulo(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.tipo = "Escaleno";
    }
  
    public String toString(){
      return "Lado 1: " + this.a + "\nLado 2: " + this.b + "\nLado 3:" + this.c + "\nTipo: " + this.tipo;
    }
}
