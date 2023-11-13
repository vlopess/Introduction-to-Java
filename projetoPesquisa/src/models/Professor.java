package models;

import java.util.ArrayList;

public class Professor extends Pesquisador{

	public Professor(String nome, Pesquisador coordenador) {
		super(nome, coordenador);
	}

	
	@Override
	public ArrayList<Pesquisador> getSupervisionados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getValorPago() {
		return 220 + (0.3 * this.getCoordenador().getValorPago());
	}


	@Override
	public int getQtdPesquisadores() {
		return 0;
	}
	

}
