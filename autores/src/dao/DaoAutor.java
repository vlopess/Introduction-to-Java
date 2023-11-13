package dao;

import java.sql.SQLException;
import java.util.List;

import model.Autor;

public interface DaoAutor {
	
	public List<Autor> getAutores() throws SQLException;
	public Autor getAutor(String nome) throws SQLException;
	public void insertAutor(Autor a) throws SQLException;

}
