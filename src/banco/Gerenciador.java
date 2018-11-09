package banco;

public abstract class Gerenciador {
	
	protected Banco banco;
	
	public Gerenciador(Banco banco) {
		this.banco = banco;
	}
	
	protected abstract void criar();
	protected abstract void excluir();

}
