package banco;

public class ContaCorrente extends Conta {
	
	public ContaCorrente (float inicial, int numero, Correntista dono, TipoConta tipo) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = dono;
		this.tipo = tipo;
	}
	
	@Override
	public TipoConta getTipo() {
		return this.tipo;
	}
	
	@Override
	public Correntista getDono() {
		return this.correntista;
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
		System.out.println("Conta não rende");
	}
	
	@Override
	public int getNumero() {
		return this.numeroConta;
	}

}