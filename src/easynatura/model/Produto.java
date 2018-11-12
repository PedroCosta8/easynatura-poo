package easynatura.model;

public class Produto {
	private int codigo;
	private double valor;
	private int quantidade;
	
	public Produto() {
		this.setCodigo(0);
		this.setValor(0);
		this.setQuantidade(0);
	}
	
	public Produto(int codigo, double valor, int quantidade) {
		this.setCodigo(codigo);
		this.setValor(valor);
		this.setQuantidade(quantidade);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
