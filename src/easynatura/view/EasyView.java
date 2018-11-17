package easynatura.view;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import easynatura.model.*;


public class EasyView {

	static String enteredPassword;
	
	public static void main(String[] args) {
		/*       ENTRADA DE DADOS       */
		Scanner in = new Scanner(System.in);

		
		/* VARIAVEIS DINÂMICAS */  
		boolean processo = true;
		String login, senha, op, nome, end, tel, cpf;		
		
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("","","","","admin","admin"));

		do {
			System.out.print("====== BEM-VINDO ======\nDigite seu login\n:");
			login = "admin";
			System.out.print("Digite sua senha\n:");
			senha = "admin";
			for(int i = 0; i < funcionarios.size(); i++) {
				if(funcionarios.get(i).getLogin().equals(login)
						&& funcionarios.get(i).getSenha().equals(senha)) {
					while(processo) {
						menuPrincipal();
						op = in.nextLine();
						switch (op) {
							case "0":
								processo = false;
								break;
							case "1":
									System.out.print("Nome\n:");
									nome = in.nextLine();
									System.out.print("Endereco\n:");
									end = in.nextLine();
									System.out.print("Telefone\n:");
									tel = in.nextLine();
									System.out.print("CPF\n:");
									cpf = in.nextLine();
									clientes.add(new Cliente(nome,end,tel,cpf));
									System.out.println("\n\n\n\n\nCliente " + nome + " adicionado com sucesso");
									break;
							case "2":
									break;
							case "3":
									break;
							case "4":
									System.out.printf("%s%20s%20s%20s\n","NOME","END","TEL","CPF");
									for(int j = 0; j < clientes.size(); j++) {
										System.out.printf("%s%20s%20s%20s\n", clientes.get(j).getNome(),
												clientes.get(j).getEndereco(),
												clientes.get(j).getTelefone(),
												clientes.get(j).getCpf());
									}
									break;
							case "5":
									break;
							case "6":
									break;
							case "7":
									break;
							case "8":
									break;
							case "9":
									break;
							case "10":
									break;
							default:
									System.out.println("Acreditamos que você "
											+ "digitou uma opção inválida, vamos tentar novamente. Ok?");
									break;
						}
					}
				}else {
					System.out.println("Sr.(a) funcionário(a) seus dados estão incorretos"
							+ " verifique se digitou tudo corretamente. Ok?");
				}
			}
		}
		while(processo);
		System.out.println("Até logo.");	

	}

	private static void menuPrincipal() {
		System.out.println("----------------------");
		System.out.println("--- MENU PRINCIPAL ---");
		System.out.println("----------------------");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Buscar Cliente");
		System.out.println("3 - Alterar dados Cliente");
		System.out.println("4 - Listar Clientes");
		System.out.println("5 - Cadastrar Produto");
		System.out.println("6 - Buscar Produto");
		System.out.println("7 - Listar Produtos");
		System.out.println("8 - Realizar Venda");
		System.out.println("9 - Listar Vendas");
		System.out.println("10 - Adicionar Funcionario");
		System.out.println("0 - Sair");
		System.out.println("-------------------------");
		System.out.print("Digite a opção desejada\n:");
	}

}
