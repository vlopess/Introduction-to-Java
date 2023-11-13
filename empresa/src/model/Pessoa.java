package model;

import java.util.ArrayList;

public abstract class Pessoa {
	
	private String nome;
	private Pessoa superior;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome,Pessoa superior) {
		this.nome = nome;
		this.superior = superior;
	}
	
	

	public Pessoa getSuperior() {
		return superior;
	}



	public void setSuperior(Pessoa superior) {
		this.superior = superior;
	}


	public ArrayList<Pessoa> getListaSuperiores() {
		ArrayList<Pessoa> allSuperiores = new ArrayList<Pessoa>();
		Pessoa sup = this.getSuperior();
		while(sup != null) {
			allSuperiores.add(sup);
			sup = sup.getSuperior();
		}
		return allSuperiores;
	}
	
	public abstract ArrayList<Pessoa> getListaEmpregadosAssociados();

	@Override
	public String toString() {
		return this.nome;
	}
	
	

}
