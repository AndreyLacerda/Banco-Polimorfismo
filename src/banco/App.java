package banco;

import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String args[]) throws IOException {
		
		Banco banco = new Banco();
		Menu mCorrentista = new MenuCorrentista();
		Menu mConta = new MenuConta();
		int menu;
		String resp = "sim";
		
		while (resp.equals("sim") || resp.equals("Sim")) {
			System.out.println("\n -- Menu Banco -- ");
			System.out.println("[2] Correntista");
			System.out.println("[1] Conta");
			System.out.println("[0] Sair");
			System.out.print("Opção: ");
			Scanner scanf = new Scanner(System.in);
			menu = scanf.nextInt();
			
			switch (menu) {
				case 2:{
					mCorrentista.telaMenu(banco);
					break;
				}
				case 1: {
					mConta.telaMenu(banco);
					break;
				}
				case 0: {
					resp = "não";
					break;
				}
				default: {
					System.out.println("Opção Inválida, aperte Enter para retornar ao Menu Banco");
					System.in.read();
				}
			}
		}
	}
}