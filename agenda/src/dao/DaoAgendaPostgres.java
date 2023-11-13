package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class DaoAgendaPostgres implements DaoAgenda{
	
	private PreparedStatement pstm;

	public DaoAgendaPostgres() {}
	@Override
	public void addPessoa(Pessoa pessoa) throws SQLException {
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("INSERT INTO AGENDA (NOME, TELEFONE) VALUES (?,?)");
		this.pstm.setString(1, pessoa.getNome());
		this.pstm.setString(2, pessoa.getTelefone());
		this.pstm.executeUpdate();		
	}

	@Override
	public Pessoa getPessoa(String nome) throws SQLException {
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("SELECT * FROM AGENDA WHERE NOME LIKE ?");
		this.pstm.setString(1, nome);
		ResultSet rs = this.pstm.executeQuery();
		Pessoa pessoa = null;
		while(rs.next()) {
			String nomeAutor = rs.getString("nome");
			String telefone = rs.getString("telefone");
			pessoa = new Pessoa(nomeAutor, telefone);			
		}
		return pessoa;
	}

	@Override
	public List<Pessoa> getPessoas() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("SELECT * FROM AGENDA");
		ResultSet rs = this.pstm.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			String telefone = rs.getString("telefone");
			pessoas.add(new Pessoa(nome, telefone));
		}
		return pessoas;
	}

}
