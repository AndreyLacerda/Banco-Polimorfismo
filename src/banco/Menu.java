package banco;

public abstract class Menu {
	protected int menu;
	protected String resp = "sim";
	protected Banco banco;
	
	public abstract void telaMenu(Banco banco);
	
	protected abstract void criar();
	
	protected abstract void excluir();
	
	protected void sair() {
		System.out.println("Retornando ao Menu Principal");
	}
	
	protected abstract void outrasOpcoes(int opcao);
	
}