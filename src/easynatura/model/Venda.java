package easynatura.model;

public class Venda {
	private Cliente cliente;
	private Produto produto; // deve ser substituido por estoque
	//private Estoque estoque;
	//deve ter uma data
	
	public Venda() {
		this.setCliente(null);
		this.setProduto(null);
	}
	
	public Venda(Cliente cliente, Produto produto) {
		this.setCliente(cliente);
		this.setProduto(produto);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
