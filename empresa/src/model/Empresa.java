package model;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Pessoa> funcionarios;

	public Empresa() {
		this.funcionarios = new ArrayList<Pessoa>();
		funcionarios.add(new Chefe("Antonio Carlos Pereira", null));
	}
	
	public Empresa(ArrayList<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void addFuncionarios(Pessoa funcionario) {
		this.funcionarios.add(funcionario);
	}
	
	public ArrayList<Pessoa> getAllChefes(){
		ArrayList<Pessoa> chefes = new ArrayList<Pessoa>();
		for(Pessoa p : funcionarios) {
			if(p instanceof Chefe)
				chefes.add(p);
		}
		return chefes;
	}

}
