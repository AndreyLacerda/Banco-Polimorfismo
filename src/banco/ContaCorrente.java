package banco;

public class ContaCorrente extends Conta {
	
	public ContaCorrente (float inicial, int numero, Correntista dono, TipoConta tipo) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = dono;
		this.tipo = tipo;
	}

	@Override
	public void render() {
		System.out.println("Conta não rende");
	}

}