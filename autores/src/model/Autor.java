package model;

public class Autor {
	private String nome;
	private String sexo;
	public Autor(String nome, String sexo) {
		super();
		this.nome = nome;
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Informações do Autor:\nNome : " + nome + "\nSexo : "+sexo;
	}
	
}
