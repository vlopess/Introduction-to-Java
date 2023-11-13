package DAO;
import model.Produto;

import java.sql.SQLException;
import java.util.List;


public interface DAOProduto {
	
	List<Produto> getAllProdutos() throws SQLException;
	
	Produto insertProduto(Produto produto) throws SQLException;
		

}
