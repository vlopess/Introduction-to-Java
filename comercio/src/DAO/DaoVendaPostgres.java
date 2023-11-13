package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Venda;
import model.VendasProdutos;

public class DaoVendaPostgres implements DaoVenda{
	
	private PreparedStatement pstm;

	public DaoVendaPostgres() {
	}

	
	
	@Override
	public void vender(Venda venda) throws SQLException {
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("INSERT INTO VENDAS (QUANTIDADE, PRODUTO_ID, VALORTOTAL) VALUES (? , ?, ?)");
		this.pstm.setInt(1, venda.getQuantidade());
		this.pstm.setInt(2, venda.getProduto().getId());
		this.pstm.setDouble(3, (venda.getQuantidade() * venda.getProduto().getPreco()));
		this.pstm.executeUpdate();
		
	}



	@Override
	public ArrayList<VendasProdutos> getAllVendas() throws SQLException {
		this.pstm = ConexaoPostgres.getInstance().getConn().prepareStatement("SELECT P.NOME, COUNT (*) AS VENDAS, SUM(V.VALORTOTAL) AS VALOR_TOTAL "
				+ "FROM PRODUTO AS P "
				+ "INNER JOIN VENDAS AS V "
				+ "ON P.ID = V.PRODUTO_ID "
				+ "GROUP BY P.NOME");
		ResultSet rs= this.pstm.executeQuery();
		ArrayList<VendasProdutos> totvendas =new ArrayList<VendasProdutos>();
		while(rs.next()) {
			VendasProdutos vp = new VendasProdutos(rs.getString(1),rs.getDouble(3), rs.getInt(2));
			totvendas.add(vp);
		}
		return totvendas;

	}

}
