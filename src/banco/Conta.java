package banco;
public abstract class Conta {
	
	public abstract float getSaldo();
	
	public abstract void depositar(float valor);
	
	public abstract void retirar(float valor);
	
	public abstract void render();

	public void transferirPara(Conta outraConta, float valor){
		this.retirar(valor);
		outraConta.depositar(valor);
	}
}