package easynatura.model;

import java.util.ArrayList;

public class Estoque {
	private ArrayList <Produto> produtos;
	
	public Estoque() {
		this.setProdutos(new ArrayList<Produto>());
	}

	public ArrayList <Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList <Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		produtos.remove(produto);
	}
}
