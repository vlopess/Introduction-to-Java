package model;

public class Venda extends VendaBase{
	private Produto produto;
	
	public Venda(int quantidade, Produto produto) {
		super(quantidade);
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
