package banco;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca (float inicial, int numero, String nome) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = nome;
	}
	
	@Override
	public void depositar(float valor) {
		this.saldo = this.saldo + (valor*1.01f);
		
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
		System.out.println("Conta n�o rende");
	}
}