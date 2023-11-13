package model;

import java.util.ArrayList;

public class Empregado extends Pessoa{

	public Empregado() {
		
	}
	
	public Empregado(String nome, Pessoa superior) {
		super(nome, superior);
	}

	@Override
	public ArrayList<Pessoa> getListaEmpregadosAssociados() {
		return null;
	}

}
