package banco;

public enum TipoConta {
	
	Corrente, 
	Poupan�a, 
	Investimento;
	
	public String toString() {
		switch (this) {
		case Corrente:
			return "Corrente";
		case Poupan�a:
			return "Poupan�a";
		case Investimento:
			return "Investimento";
		}
		return null;
	}
}