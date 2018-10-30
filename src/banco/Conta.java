package banco;
public abstract class Conta {
	
	protected float saldo;
	protected Correntista correntista;
	protected int numeroConta;
	protected TipoConta tipo;
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public TipoConta getTipo() {
		return this.tipo;
	}
	
	public Correntista getDono() {
		return this.correntista;
	}
	
	public int getNumero() {
		return this.numeroConta;
	}
	
	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void retirar(float valor) {
		this.saldo = this.saldo - valor;
	}
	
	public abstract void render();

	public void transferirPara(Conta outraConta, float valor){
		this.retirar(valor);
		outraConta.depositar(valor);
	}
}