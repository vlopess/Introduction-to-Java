package model;

public class VendasProdutos extends VendaBase{
	private double valortotal;
	private String nomeProduto;
	
	public VendasProdutos(String nomeProduto, double valorTotal, int quantidade) {
		super(quantidade);
		this.setNomeProduto(nomeProduto);
		this.setValortotal(valorTotal);
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	@Override
	public String toString() {
		return "NomeProduto :" + nomeProduto + " Qtd de Vendas: "+ super.getQuantidade() +" Valortotal =" + valortotal +"";
	}
}
