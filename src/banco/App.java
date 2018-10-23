package banco;

import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String args[]) throws IOException {
		
		Banco banco = new Banco();
		
		int menu, nconta = 100;
		String resp = "sim";
		
		while (resp.equals("sim") || resp.equals("Sim")) {
			System.out.println("\n -- Menu Banco -- ");
			System.out.println("[2] Correntista");
			System.out.println("[1] Conta");
			System.out.println("[0] Sair");
			System.out.print("Op��o: ");
			Scanner scanf = new Scanner(System.in);
			menu = scanf.nextInt();
			
			switch (menu) {
				case 2:{
					System.out.println("\n -- Menu Correntista -- ");
					System.out.println("[2] Criar Correntista");
					System.out.println("[1] Remover Correntista");
					System.out.println("[0] Sair");
					System.out.print("Op��o: ");
					menu = scanf.nextInt();
					switch (menu) {
						case 2: {
							System.out.print("CPF: ");
							scanf.nextLine();
							String cpf = scanf.next();
							Correntista result = banco.buscarCPF(cpf);
							if (result == null) {
								System.out.print("Nome: ");
								scanf.nextLine();
								String nome = scanf.nextLine();
								Correntista correntista = new Correntista(nome, cpf);
								banco.adicionarCorrentista(correntista);
							}
							else {
								String nome = result.getNome();
								System.out.println("J� Existe um correntista com esse CPF - Nome: " +nome);
							}
							break;
						}
						case 1: {
							System.out.print("CPF do correntista a ser removido: ");
							scanf.nextLine();
							String cpf = scanf.next();
							Correntista result = banco.buscarCPF(cpf);
							if (result == null) {
								System.out.println("Correntista N�o Existe");
							}
							else {
								banco.removerCorrentista(result);
								System.out.println("Correntista excluido");
							}
							
							break;
						}
						case 0: break;
						default: {
							System.out.println("Op��o Inv�lida, aperte Enter para retornar ao Menu Banco");
							System.in.read();
						}
					}
					break;
				}
				case 1: {
					System.out.println("\n -- Menu Conta -- ");
					System.out.println("[5] Criar Conta");
					System.out.println("[4] Rendimento");
					System.out.println("[3] Transfer�ncias");
					System.out.println("[2] Depositar Valor");
					System.out.println("[1] Sacar Valor");
					System.out.println("[0] Sair");
					System.out.print("Op��o: ");
					menu = scanf.nextInt();
					switch (menu) {
						case 5: {
							System.out.print("CPf Correntista: ");
							scanf.nextLine();
							String cpf = scanf.next();
							Correntista result = banco.buscarCPF(cpf);
							if (result == null) {
								System.out.println("Correntista N�o Existe!! N�o � possivel criar conta sem j� correntista existente");
								System.out.println("Retornando ao Menu Principal");
								System.in.read();
							}
							else {
								System.out.print("Tipo De Conta (Corrente, Investimento, ou Poupan�a): ");
								nconta += 1;
								scanf.nextLine();
								String tipo = scanf.nextLine();
								if (tipo.equals(TipoConta.Corrente)) {
									Conta cc = new ContaCorrente(0, nconta, result, TipoConta.Corrente);
									System.out.println("Conta Corrente criada com sucesso");
								}
								else {
									if (tipo.equals(TipoConta.Poupan�a)) {
										Conta cp = new ContaPoupanca(0, nconta, result, TipoConta.Poupan�a);
										System.out.println("Conta Poupan�a criada com sucesso");
									}
									else {
										Conta ci = new ContaInvestimento(0, nconta, result, TipoConta.Investimento);
										System.out.println("Conta Investimento criada com sucesso");
									}
								}
							}
							
							break;
						}
						case 4: {
							System.out.print("N�mero Conta: ");
							int numero = scanf.nextInt();
							Conta result = banco.buscarPorNumero(numero);
							if (result == null) {
								System.out.println("Conta N�o Existe");
							}
							else {
								result.render();
							}
							break;
						}
						case 3: {
							System.out.print("N�mero Conta: ");
							int numero = scanf.nextInt();
							Conta result = banco.buscarPorNumero(numero);
							if (result == null) {
								System.out.println("Conta N�o Existe");
							}
							else {
								System.out.print("Valor: ");
								int valor = scanf.nextInt();
								result.render();
							}
							break;
						}
						case 2: {
							System.out.print("N�mero Conta: ");
							int numero = scanf.nextInt();
							Conta result = banco.buscarPorNumero(numero);
							if (result == null) {
								System.out.println("Conta N�o Existe");
							}
							else {
								System.out.print("Valor: ");
								int valor = scanf.nextInt();
								result.render();
							}
							break;
						}
						case 1: {
							break;
						}
						case 0: break;
						default: {
							System.out.println("Op��o Inv�lida, aperte Enter para retornar ao Menu Banco");
							System.in.read();
						}
					}
					break;	
				}
				case 0: {
					resp = "n�o";
					break;
				}
				default: {
					System.out.println("Op��o Inv�lida, aperte Enter para retornar ao Menu Banco");
					System.in.read();
				}
			}
		}
	}
}