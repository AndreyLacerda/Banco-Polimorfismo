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
}