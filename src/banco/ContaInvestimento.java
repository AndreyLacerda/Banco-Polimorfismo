package banco;

public class ContaInvestimento extends Conta implements Rentável{
	
	public ContaInvestimento (float inicial, int numero, Correntista dono, TipoConta tipo) {
		this.saldo = inicial;
		this.numeroConta = numero;
		this.correntista = dono;
		this.tipo = tipo;
	}
	
	@Override
	public void render() {
		this.saldo = this.saldo * 1.05f;
		System.out.println("Conta rendeu 5%");
		float rendimento = this.getSaldo();
		System.out.println("Saldo Pós rendimento: " +rendimento);
	}
	
	@Override
	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
	}

}
