package easynatura.model;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	
	public Cliente() {
		this.setNome("");
		this.setEndereco("");
		this.setTelefone("");
		this.setCpf("");
	}
	
	public Cliente(String nome, String endereco, String telefone, String cpf) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setCpf(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void cadastrarCliente(String nome, String endereco, String Telefone, String cpf) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(Telefone);
		this.setCpf(cpf);
	}

}
