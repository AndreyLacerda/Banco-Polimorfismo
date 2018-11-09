package banco;

public abstract class Menu {
	
	public abstract void telaMenu();
	
	protected void sair() {
		System.out.println("Retornando ao Menu Principal");
	}
	
}