package banco;
public abstract class Conta {
	
	protected float saldo;
	protected Correntista correntista;
	protected int numeroConta;
	protected TipoConta tipo;
	
	public abstract float getSaldo();
	
	public abstract TipoConta getTipo();
	
	public abstract Correntista getDono();
	
	public abstract int getNumero();
	
	public abstract void depositar(float valor);
	
	public abstract void retirar(float valor);
	
	public abstract void render();

	public void transferirPara(Conta outraConta, float valor){
		this.retirar(valor);
		outraConta.depositar(valor);
	}
}