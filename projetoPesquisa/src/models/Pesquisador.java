package models;

import java.util.ArrayList;

public abstract class Pesquisador {
	
	private String nome;
	private Pesquisador coordenador;
	
	public Pesquisador() {
	}

	public Pesquisador(String nome, Pesquisador coordenador) {
		this.nome = nome;
		this.coordenador = coordenador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pesquisador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Pesquisador coordenador) {
		this.coordenador = coordenador;
	}
	
	public abstract ArrayList<Pesquisador> getSupervisionados();
	
	public abstract double getValorPago();
	
	public abstract int getQtdPesquisadores();
	

	@Override
	public String toString() {
		return this.nome;
	}

}
