package banco;

import java.util.Scanner;

public class GerenciadorCorrentista extends Gerenciador{
	
	Scanner scanf = new Scanner(System.in);
	
	public GerenciadorCorrentista(Banco banco) {
		super(banco);
	}

	@Override
	protected void criar() {
		System.out.print("CPF: ");
		String cpf = scanf.next();
		Correntista result = banco.buscarCPF(cpf);
		if (result == null) {
			System.out.print("Nome: ");
			scanf.nextLine();
			String nome = scanf.nextLine();
			Correntista correntista = new Correntista(nome, cpf);
			banco.adicionarCorrentista(correntista);
			System.out.println("Correntista criado com sucesso");
		}
		else {
			String nome = result.getNome();
			System.out.println("Já Existe um correntista com esse CPF - Nome: " +nome);
		}
	}

	@Override
	protected void excluir() {
		int flag = 0;
		while (flag == 0) {
			System.out.println("Para excluir, você não deve possuir contas no sistema");
			System.out.print("Você possui alguma conta no sistema?(sim ou nao) ");
			scanf.nextLine();
			String existe = scanf.next();
			if (existe.equals("nao")) {
				System.out.print("CPF do correntista a ser removido: ");
				scanf.nextLine();
				String cpf = scanf.next();
				Correntista result = banco.buscarCPF(cpf);
				if (result == null) {
					System.out.println("Correntista Não Existe");
				}
				else {
					banco.removerCorrentista(result);
					System.out.println("Correntista excluido");
				}
				flag = 1;
			}
			else
				if (existe.equals("sim")) {
					System.out.println("Exclua suas contas no Menu Conta");
					flag = 1;
				}
				else {
					System.out.println("Resposta Inválida");
				}
		}
	}
}
