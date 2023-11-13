package models;

import java.util.ArrayList;

public class Coordenador extends Pesquisador{
	
	private ArrayList<Pesquisador> supervisionados;
	
	public Coordenador(String nome, Pesquisador pesquisador) {
		super(nome, pesquisador);
		this.supervisionados = new ArrayList<Pesquisador>();
	}
	
	public void addSupervisionado(Pesquisador pesquisador) {
		this.supervisionados.add(pesquisador);
	}
	
	@Override
	public ArrayList<Pesquisador> getSupervisionados() {
		ArrayList<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
		for(Pesquisador p : supervisionados) {
			if(p.getSupervisionados() != null)
				pesquisadores.addAll(p.getSupervisionados());
			pesquisadores.add(p);
		}
		return pesquisadores;
	}

	@Override
	public double getValorPago() {
		return 300 - (300 * this.getQtdPesquisadores() * 0.025);
	}

	@Override
	public int getQtdPesquisadores() {
		ArrayList<Pesquisador> pesquisadores = this.getSupervisionados();
		return pesquisadores.size();
	}


	
}
