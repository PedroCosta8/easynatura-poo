package easynatura.model;

public class Funcionario extends Cliente {
	private String login;
	private String senha;
	
	public Funcionario() {
		super("", "", "", "");
		this.setLogin("");
		this.setSenha("");
	}
	
	public Funcionario(String nome, String endereco, String telefone, String cpf, String login, String senha) {
		super(nome, endereco, telefone, cpf);
		this.setLogin(login);
		this.setSenha(senha);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
