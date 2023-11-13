package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Autor;

public class DaoAutorPostgres implements DaoAutor{

	private PreparedStatement pstm;
	
	@Override
	public List<Autor> getAutores()  throws SQLException{
		List<Autor> autores = new ArrayList<Autor>();
		try {
			this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("SELECT * FROM AUTORES");
			ResultSet rs = this.pstm.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("NOME");
				String sexo = rs.getString("SEXO");
				Autor autor = new Autor(nome, sexo);
				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autores;

	}

	@Override
	public Autor getAutor(String nomeAutor)  throws SQLException{
		try {
			this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("SELECT * FROM AUTORES WHERE NOME LIKE ?");
			this.pstm.setString(1, nomeAutor);
			ResultSet rs = this.pstm.executeQuery();
			Autor autor = null;
			while(rs.next()) {
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				autor = new Autor(nome, sexo);				
			}
			return autor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insertAutor(Autor a)  throws SQLException{
		try {
			this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("INSERT INTO AUTORES (NOME, SEXO) VALUES (?, ?)");
			this.pstm.setString(1, a.getNome());
			this.pstm.setString(2, a.getSexo());
			this.pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
