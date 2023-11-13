package models;

import java.util.ArrayList;

public class ProjetoDePesquisa {
	private ArrayList<Pesquisador> pesquisadores;

	public ProjetoDePesquisa() {
		this.pesquisadores = new ArrayList<Pesquisador>();
		this.pesquisadores.add(new Coordenador("Sra. Mara Andrade", null));
	}
	
	public void addPesquisador(Pesquisador p) {
		this.pesquisadores.add(p);
	}
	
	public ArrayList<Pesquisador> getListaPesquisadores(){
		return this.pesquisadores;
	}
	public ArrayList<Coordenador> getAllCoordenadores(){
		ArrayList<Coordenador> coo = new ArrayList<Coordenador>();
		for(Pesquisador c : pesquisadores) {
			if(c instanceof Coordenador)
				coo.add((Coordenador) c);
		}
		return coo;
	}
	
	public Pesquisador findPesquisador(String nomePesquisador) {
		for(Pesquisador p : pesquisadores) {
			if(p.getNome().equals(nomePesquisador)) return p;				
		}
		return null;
	}

}
