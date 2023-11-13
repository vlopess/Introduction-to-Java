package model;

import exceptions.ValorNaoPodeSerNegativoException;

public class Pessoa {
	private double peso;
	private double altura;
	
	public Pessoa(double peso, double altura) throws ValorNaoPodeSerNegativoException {
		this.setPeso(peso);
		this.setAltura(altura);		
	}
	public String getIMC() {
		double imc = this.getPeso()/Math.pow(this.getAltura(),2);
		if((imc > 25) && (imc < 30))
			return "Sobrepeso";
		else if(imc >= 30)
			return "Obesidade";
		return "Peso Normal";
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso)  throws ValorNaoPodeSerNegativoException{
		if (peso<=0)
			throw new ValorNaoPodeSerNegativoException();
		
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) throws ValorNaoPodeSerNegativoException{
		if (altura<=0)
			throw new ValorNaoPodeSerNegativoException();
		
		this.altura = altura;
	}
	

}
