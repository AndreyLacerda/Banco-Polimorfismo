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
								System.out.println("Correntista criado com sucesso");
								System.in.read();
							}
							else {
								String nome = result.getNome();
								System.out.println("J� Existe um correntista com esse CPF - Nome: " +nome);
								System.in.read();
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
								System.in.read();
							}
							else {
								banco.removerCorrentista(result);
								System.out.println("Correntista excluido");
								System.in.read();
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
					System.out.println("[8] Informa��o Sobre Conta");
					System.out.println("[7] Cancelar Conta");
					System.out.println("[6] Criar Conta");
					System.out.println("[5] Consultar Saldo");
					System.out.println("[4] Rendimento");
					System.out.println("[3] Transfer�ncias");
					System.out.println("[2] Depositar Valor");
					System.out.println("[1] Sacar Valor");
					System.out.println("[0] Sair");
					System.out.print("Op��o: ");
					menu = scanf.nextInt();
					switch (menu) {
						case 8:{
							int flag = 0;
							while (flag == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag = 1;
									System.out.println(" -- Informa��es -- ");
									System.out.println("Conta de N�mero: "+numero);
									Correntista dono = result.getDono();
									System.out.println("Dono: "+dono.getNome());
									System.out.println("Tipo: "+result.getTipo());
								}
							}
							System.in.read();
							break;
						}
						case 7:{
							int flag = 0;
							while (flag == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag = 1;
									banco.removerConta(result);
									System.out.println("Conta Cancelada Com Sucesso!!");
								}
							}
							System.in.read();
							break;
						}
						case 6: {
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
								int flag = 0;
								while (flag == 0) {
									System.out.print("Tipo De Conta (Corrente, Investimento, ou Poupan�a): ");
									scanf.nextLine();
									String tipo = scanf.next();
									nconta += 1;
									if (tipo.equals("Corrente")) {
										Conta cc = new ContaCorrente(0, nconta, result, TipoConta.Corrente);
										banco.adicionarConta(cc);
										System.out.println("Conta Corrente criada com sucesso");
										System.out.println("N�mero Da Conta (ANOTE E GUARDE): "+cc.getNumero());
										flag = 1;
									}
									else {
										if (tipo.equals("Poupan�a")) {
											Conta cp = new ContaPoupanca(0, nconta, result, TipoConta.Poupan�a);
											banco.adicionarConta(cp);
											System.out.println("Conta Poupan�a criada com sucesso");
											System.out.println("N�mero Da Conta (ANOTE E GUARDE): "+cp.getNumero());
											flag = 1;
										}
										else {
											if (tipo.equals("Investimento")) {
												Conta ci = new ContaInvestimento(0, nconta, result, TipoConta.Investimento);
												banco.adicionarConta(ci);
												System.out.println("Conta Investimento criada com sucesso");
												System.out.println("N�mero Da Conta (ANOTE E GUARDE): "+ci.getNumero());
												flag = 1;
											}
											else {
												System.out.println("Tipo de Conta Inexistente! Insira Novamente, conforme explicitado em parenteses");
											}
										}
									}
								}
							}
							System.in.read();
							break;
						}
						case 5: {
							int flag = 0;
							while (flag == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag = 1;
									float saldo = result.getSaldo();
									System.out.println("Saldo Atual: " +saldo);
								}
							}
							System.in.read();
							break;	
						}
						case 4: {
							int flag = 0;
							while (flag == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag = 1;
									result.render();
								}
							}
							System.in.read();
							break;
						}
						case 3: {
							int flag1 = 0;
							while (flag1 == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag1 = 1;
									System.out.print("Valor: ");
									float valor = scanf.nextFloat();
									int flag = 0;
									while (flag == 0) {
										System.out.print("N�mero da Conta a ser transferido o valor: ");
										numero = scanf.nextInt();
										Conta result2 = banco.buscarPorNumero(numero);
										if (result2 == null) {
											System.out.println("Conta N�o Existe!! Insira Novamente");
										}
										else {
											flag = 1;
											result.transferirPara(result2, valor);
											System.out.println("Transfer�ncia Realizada com Sucesso");
										}
									}
								}
							}
							System.in.read();
							break;
						}
						case 2: {
							int flag = 0;
							while (flag == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag = 1;
									System.out.print("Valor: ");
									float valor = scanf.nextFloat();
									result.depositar(valor);
									System.out.println("Valor depositado com Sucesso!!");
								}
							}
							System.in.read();
							break;
						}
						case 1: {
							int flag = 0;
							while (flag == 0) {
								System.out.print("N�mero Conta: ");
								int numero = scanf.nextInt();
								Conta result = banco.buscarPorNumero(numero);
								if (result == null) {
									System.out.println("Conta N�o Existe!! Insira Novamente");
								}
								else {
									flag = 1;
									System.out.print("Valor para saque: ");
									float valor = scanf.nextFloat();
									result.retirar(valor);
									System.out.println("Valor retirado com Sucesso!!");
								}
							}
							System.in.read();
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