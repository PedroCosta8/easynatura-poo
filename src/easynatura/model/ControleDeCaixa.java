package easynatura.model;

import java.util.ArrayList;

public class ControleDeCaixa {
	private ArrayList <Venda> vendas;
	
	public ControleDeCaixa() {
		this.setVendas(new ArrayList<Venda>());
	}

	public ArrayList <Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList <Venda> vendas) {
		this.vendas = vendas;
	}
	
	public void adicionarVenda(Venda venda) {
		vendas.add(venda);
	}
	
	public void removerVenda(Venda venda) {
		vendas.remove(venda);
	}
	
	//public Venda buscaVenda_data() {
		
	//}
	
	//public Venda buscaVenda_preco() {
		
	//}
	
	//public Venda buscaVenda_NomeProd() {
		
	//}
}
