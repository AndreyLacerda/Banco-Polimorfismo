package banco;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca (float inicial, int numero, Correntista dono, TipoConta tipo) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = dono;
		this.tipo = tipo;
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
		System.out.println("Conta não rende");
	}
	
	@Override
	public int getNumero() {
		return this.numeroConta;
	}
}