package banco;

import java.util.Scanner;

public class MenuConta extends Menu{
	
	private int menu;
	private GerenciadorContas gContas;
	
	public MenuConta(GerenciadorContas gerenteContas) {
		this.gContas = gerenteContas;
	}

	Scanner scanf = new Scanner(System.in);
	int nconta = 100;

	@Override
	public void telaMenu()  {
		System.out.println("\n -- Menu Conta -- ");
		System.out.println("[8] Informação Sobre Conta");
		System.out.println("[7] Cancelar Conta");
		System.out.println("[6] Criar Conta");
		System.out.println("[5] Consultar Saldo");
		System.out.println("[4] Rendimento");
		System.out.println("[3] Transferências");
		System.out.println("[2] Depositar Valor");
		System.out.println("[1] Sacar Valor");
		System.out.println("[0] Sair");
		System.out.print("Opção: ");
		menu = scanf.nextInt();
		switch (menu) {
			case 8: {
				this.gContas.outrasOpcoes(menu);
				break;
			}
			case 7: {
				this.gContas.excluir();
				break;
			}
			case 6: {
				this.gContas.criar();
				break;
			}
			case 5: {
				this.gContas.outrasOpcoes(menu);
				break;
			}
			case 4: {
				this.gContas.outrasOpcoes(menu);
				break;
			}
			case 3: {
				this.gContas.outrasOpcoes(menu);
				break;
			}
			case 2: {
				this.gContas.outrasOpcoes(menu);
				break;
			}
			case 1: {
				this.gContas.outrasOpcoes(menu);
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
