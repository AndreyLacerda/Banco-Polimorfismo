package banco;

public class ContaInvestimento extends Conta{
	
	public ContaInvestimento (float inicial, int numero, String nome) {
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
	
	public void render() {
		this.saldo = this.saldo * 1.05f;
		System.out.println("Conta rendeu 5%");
	}
}
