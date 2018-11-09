package banco;

import java.util.Scanner;

public class GerenciadorContas extends Gerenciador implements OutrasOpções{
	
	Scanner scanf = new Scanner(System.in);
	private int nconta = 100;

	public GerenciadorContas(Banco banco) {
		super(banco);
	}

	@Override
	protected void criar(){
		System.out.print("CPf Correntista: ");
		String cpf = scanf.next();
		Correntista result = banco.buscarCPF(cpf);
		if (result == null) {
			System.out.println("Correntista Não Existe!! Não é possivel criar conta sem correntista já existente");
			System.out.println("Retornando ao Menu Principal");
		}
		else {
			int flag = 0;
			while (flag == 0) {
				System.out.print("Tipo De Conta (Corrente, Investimento, ou Poupança): ");
				scanf.nextLine();
				String tipo = scanf.next();
				nconta += 1;
				if (tipo.equals("Corrente")) {
					ContaCorrente cc = new ContaCorrente(0, nconta, result, TipoConta.Corrente);
					banco.adicionarConta(cc);
					System.out.println("Conta Corrente criada com sucesso");
					System.out.println("Número Da Conta (ANOTE E GUARDE): "+cc.getNumero());
					flag = 1;
				}
				else {
					if (tipo.equals("Poupança")) {
						ContaPoupanca cp = new ContaPoupanca(0, nconta, result, TipoConta.Poupança);
						banco.adicionarConta(cp);
						System.out.println("Conta Poupança criada com sucesso");
						System.out.println("Número Da Conta (ANOTE E GUARDE): "+cp.getNumero());
						flag = 1;
					}
					else {
						if (tipo.equals("Investimento")) {
							ContaInvestimento ci = new ContaInvestimento(0, nconta, result, TipoConta.Investimento);
							banco.adicionarConta(ci);
							System.out.println("Conta Investimento criada com sucesso");
							System.out.println("Número Da Conta (ANOTE E GUARDE): "+ci.getNumero());
							flag = 1;
						}
						else {
							System.out.println("Tipo de Conta Inexistente! Insira Novamente, conforme explicitado em parenteses");
						}
					}
				}
			}
		}
	}

	@Override
	protected void excluir() {
		int flag = 0;
		while (flag == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			if (numero == 0)
				flag = 1;
			else {
				Conta result = banco.buscarPorNumero(numero);
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag = 1;
					banco.removerConta(result);
					System.out.println("Conta Cancelada Com Sucesso!!");
				}
			}
		}
	}

	@Override
	public void outrasOpcoes(int opcao) {
		if (opcao == 8)
			this.informacao();
		else
			if (opcao == 5)
				this.saldo();
			else
				if (opcao == 4)
					this.rendimento();
				else
					if (opcao == 3)
						this.transferencia();
					else
						if (opcao == 2)
							this.deposito();
						else
							if (opcao == 1)
								this.saque();
	}
				
	private void informacao() {
		int flag = 0;
		while (flag == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			if (numero == 0)
				flag = 1;
			else {
				Conta result = banco.buscarPorNumero(numero);
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag = 1;
					System.out.println(" -- Informações -- ");
					System.out.println("Conta de Número: "+numero);
					Correntista dono = result.getDono();
					System.out.println("Dono: "+dono.getNome());
					System.out.println("Tipo: "+result.getTipo());
				}
			}
		}
	}
	
	private void deposito() {
		int flag = 0;
		while (flag == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			Conta result = banco.buscarPorNumero(numero);
			if (numero == 0)
				flag = 1;
			else {
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag = 1;
					System.out.print("Valor: ");
					float valor = scanf.nextFloat();
					result.depositar(valor);
					System.out.println("Valor depositado com Sucesso!!");
				}
			}
		}
	}
	
	private void saldo() {
		int flag = 0;
		while (flag == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			if (numero == 0)
				flag = 1;
			else {
				Conta result = banco.buscarPorNumero(numero);
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag = 1;
					float saldo = result.getSaldo();
					System.out.println("Saldo Atual: " +saldo);
				}
			}
		}
		
	}
	
	private void saque() {
		int flag = 0;
		while (flag == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			Conta result = banco.buscarPorNumero(numero);
			if (numero == 0)
				flag = 1;
			else {
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag = 1;
					System.out.print("Valor para saque: ");
					float valor = scanf.nextFloat();
					result.retirar(valor);
					System.out.println("Valor retirado com Sucesso!!");
				}
			}
		}
	}
	
	private void transferencia() {
		int flag1 = 0;
		while (flag1 == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			Conta result = banco.buscarPorNumero(numero);
			if (numero == 0)
				flag1 = 1;
			else {
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag1 = 1;
					System.out.print("Valor: ");
					float valor = scanf.nextFloat();
					int flag = 0;
					while (flag == 0) {
						System.out.print("Número da Conta a ser transferido o valor: ");
						numero = scanf.nextInt();
						Conta result2 = banco.buscarPorNumero(numero);
						if (numero == 0)
							flag = 1;
						else {
							if (result2 == null) {
								System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
							}
							else {
								flag = 1;
								result.transferirPara(result2, valor);
								System.out.println("Transferência Realizada com Sucesso");
							}
						}
					}
				}
			}
		}
	}
	
	private void rendimento() {
		int flag = 0;
		while (flag == 0) {
			System.out.print("Número Conta: ");
			int numero = scanf.nextInt();
			if (numero == 0)
				flag = 1;
			else {
				Conta result = banco.buscarPorNumero(numero);
				if (result == null) {
					System.out.println("Conta Não Existe!! Insira Novamente (CASO QUERIA RETORNAR AO MENU, INSIRA 0)");
				}
				else {
					flag = 1;
					if (result.getTipo() == TipoConta.Investimento) {
						ContaInvestimento result2 = (ContaInvestimento) result;
						result2.render();
					}
					else {
						System.out.println("Essa conta não rende!");
					}
				}
			}
		}
	}

}
