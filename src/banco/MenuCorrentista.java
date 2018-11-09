package banco;

import java.util.Scanner;

public class MenuCorrentista extends Menu{
	
	private int menu;
	private GerenciadorCorrentista gCorrentista;
	
	public MenuCorrentista(GerenciadorCorrentista gerenteCorrentistas) {
		this.gCorrentista = gerenteCorrentistas;
	}

	Scanner scanf = new Scanner(System.in);

	@Override
	public void telaMenu() {
		System.out.println("\n -- Menu Correntista -- ");
		System.out.println("[2] Criar Correntista");
		System.out.println("[1] Remover Correntista");
		System.out.println("[0] Sair");
		System.out.print("Opção: ");
		menu = scanf.nextInt();
		switch (menu) {
			case 2: {
				this.gCorrentista.criar();
				break;
			}
			case 1: {
				this.gCorrentista.excluir();
				break;
			}
			case 0: {
				this.sair();
			}
			default: {
				System.out.println("Opção Inválida, aperte Enter para retornar ao Menu Banco");
			}
		}
		
	}
	
}
