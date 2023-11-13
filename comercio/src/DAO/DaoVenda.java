package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Venda;
import model.VendasProdutos;

public interface DaoVenda {
	
	public void vender(Venda venda) throws SQLException ;
	
	public ArrayList<VendasProdutos> getAllVendas() throws SQLException ;

}
