package banco;

public class ContaCorrente extends Conta {
	
	private float saldo;
	private String correntista;
	private int numeroConta;
	
	public ContaCorrente (float inicial, int numero, String nome) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = nome;
	}
	
	@Override
	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
		
	}

	@Override
	public void retirar(float valor) {
		this.saldo = this.saldo - valor;
	}

	@Override
	public float getSaldo() {
		return this.saldo;
	}

	@Override
	public void render() {
		System.out.println("\nConta n�o rende");
	}

}