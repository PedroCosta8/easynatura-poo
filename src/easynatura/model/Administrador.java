package easynatura.model;

public class Administrador {
	private String nome;
	private String login;
	private String senha;
	
	public Administrador() {
		this.setNome("");
		this.setLogin("");
		this.setSenha("");
	}
	
	public Administrador(String nome, String login, String senha) {
		this.setNome(nome);
		this.setLogin(login);
		this.setSenha(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
