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
			System.out.print("Opção: ");
			Scanner scanf = new Scanner(System.in);
			menu = scanf.nextInt();
			
			switch (menu) {
				case 2:{
					System.out.println("\n -- Menu Correntista -- ");
					System.out.println("[2] Criar Correntista");
					System.out.println("[1] Remover Correntista");
					System.out.println("[0] Sair");
					System.out.print("Opção: ");
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
								System.out.println("Já Existe um correntista com esse CPF - Nome: " +nome);
							}
							break;
						}
						case 1: {
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
							
							break;
						}
						case 0: break;
						default: {
							System.out.println("Opção Inválida, aperte Enter para retornar ao Menu Banco");
							System.in.read();
						}
					}
					break;
				}
				case 1: {
					System.out.println("\n -- Menu Conta -- ");
					System.out.println("[5] Criar Conta");
					System.out.println("[4] Rendimento");
					System.out.println("[3] Transferências");
					System.out.println("[2] Depositar Valor");
					System.out.println("[1] Sacar Valor");
					System.out.println("[0] Sair");
					System.out.print("Opção: ");
					menu = scanf.nextInt();
					switch (menu) {
						case 5: {
							System.out.print("CPf Correntista: ");
							scanf.nextLine();
							String cpf = scanf.next();
							Correntista result = banco.buscarCPF(cpf);
							if (result == null) {
								System.out.println("Correntista Não Existe!! Não é possivel criar conta sem já correntista existente");
								System.out.println("Retornando ao Menu Principal");
								System.in.read();
							}
							else {
								System.out.print("Tipo De Conta (Corrente, Investimento, ou Poupança): ");
								nconta += 1;
								scanf.nextLine();
								String tipo = scanf.nextLine();
								if (tipo.equals(TipoConta.Corrente)) {
									Conta cc = new ContaCorrente(0, nconta, result, TipoConta.Corrente);
									System.out.println("Conta Corrente criada com sucesso");
								}
								else {
									if (tipo.equals(TipoConta.Poupança)) {
										Conta cp = new ContaPoupanca(0, nconta, result, TipoConta.Poupança);
										System.out.println("Conta Poupança criada com sucesso");
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
							System.out.print("Número Conta: ");
							int numero = scanf.nextInt();
							Conta result = banco.buscarPorNumero(numero);
							if (result == null) {
								System.out.println("Conta Não Existe");
							}
							else {
								result.render();
							}
							break;
						}
						case 3: {
							System.out.print("Número Conta: ");
							int numero = scanf.nextInt();
							Conta result = banco.buscarPorNumero(numero);
							if (result == null) {
								System.out.println("Conta Não Existe");
							}
							else {
								System.out.print("Valor: ");
								int valor = scanf.nextInt();
								result.render();
							}
							break;
						}
						case 2: {
							System.out.print("Número Conta: ");
							int numero = scanf.nextInt();
							Conta result = banco.buscarPorNumero(numero);
							if (result == null) {
								System.out.println("Conta Não Existe");
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
							System.out.println("Opção Inválida, aperte Enter para retornar ao Menu Banco");
							System.in.read();
						}
					}
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