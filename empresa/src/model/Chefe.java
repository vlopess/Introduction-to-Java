package model;

import java.util.ArrayList;

public class Chefe extends Pessoa{
	
	private ArrayList<Pessoa> subordinados;
	
	public Chefe() {
	}
	
	public Chefe(String nome, Pessoa superior) {
		super(nome, superior);
		this.subordinados = new ArrayList<Pessoa>();
	}
	
	public void addSubordinado(Pessoa e) {
		this.subordinados.add(e);
	}


	@Override
	public ArrayList<Pessoa> getListaEmpregadosAssociados() {
		ArrayList<Pessoa> allSubordinados = new ArrayList<Pessoa>();
		for(Pessoa p : subordinados) {
			allSubordinados.add(p);
			ArrayList<Pessoa> sub = p.getListaEmpregadosAssociados();
			if(sub != null)
				allSubordinados.addAll(sub);
		}
		return allSubordinados;
	}

}
