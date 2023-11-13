package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class DAOProdutoPostgres implements DAOProduto{

	
	public DAOProdutoPostgres() {
	}

	private PreparedStatement pstm;
	
	@Override
	public List<Produto> getAllProdutos() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("SELECT * FROM PRODUTO;");
		ResultSet rs= this.pstm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			double preco = rs.getDouble("preco");
			Produto p = new Produto(id,nome, preco);
			produtos.add(p);
		}
		return produtos;
	}

	@Override
	public Produto insertProduto(Produto produto) throws SQLException {
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("INSERT INTO PRODUTO (NOME, PRECO)VALUES (?, ?)");
		this.pstm.setString(1, produto.getNome());
		this.pstm.setDouble(2, produto.getPreco());
		this.pstm.executeUpdate();	
		return produto;
	}

}
