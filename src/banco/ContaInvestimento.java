package banco;

public class ContaInvestimento extends Conta{
	
	public ContaInvestimento (float inicial, int numero, Correntista dono, TipoConta tipo) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = dono;
		this.tipo = tipo;
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
	
	@Override
	public int getNumero() {
		return this.numeroConta;
	}
}
