package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pessoa;

public interface DaoAgenda {
	
	public void addPessoa(Pessoa pessoa) throws SQLException ;
	public Pessoa getPessoa(String nome) throws SQLException ;
	public List<Pessoa> getPessoas() throws SQLException ;
}
