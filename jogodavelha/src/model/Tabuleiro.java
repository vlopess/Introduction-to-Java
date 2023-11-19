package model;

import java.util.ArrayList;

public class Tabuleiro {
	private String winner;
	private boolean partidaEncerrada;

	public Tabuleiro() {
		this.partidaEncerrada = false;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	public void verificarGanhador(ArrayList<String> posicoes) {
		for(int i = 0; i < 9 ; i+=3) {
 			if(posicoes.get(i).equals(posicoes.get(i+1)) && posicoes.get(i+1).equals(posicoes.get(i+2))) {
 				if(!posicoes.get(i).equals("")) this.setWinner(posicoes.get(i));
 			}
 		}
		for(int i = 0; i < 3 ; i++) {
 			if(posicoes.get(i).equals(posicoes.get(i+3)) && posicoes.get(i+3).equals(posicoes.get(i+6))) {
 				if(!posicoes.get(i).equals(""))  this.setWinner(posicoes.get(i));
 			}
 		}
		if(posicoes.get(0).equals(posicoes.get(4)) && posicoes.get(4).equals(posicoes.get(8))) {
 			if(!posicoes.get(0).equals("")) this.setWinner(posicoes.get(0));
 		}
		
		if(posicoes.get(2).equals(posicoes.get(4)) && posicoes.get(4).equals(posicoes.get(6))) {
 			if(!posicoes.get(2).equals("")) this.setWinner(posicoes.get(2));
 		}
		int count = 0;
 		for(int i = 0 ; i < 9 ; i++) {
 			if(!posicoes.get(i).equals("")) count++;
 		}
 		if(count == 9) this.partidaEncerrada = true;
	}
	public boolean partidaEncerrada() {
		return this.partidaEncerrada;
	}
	
}
