package banco;

public enum TipoConta {
	
	Corrente, 
	Poupança, 
	Investimento;
	
	public String toString() {
		switch (this) {
		case Corrente:
			return "Corrente";
		case Poupança:
			return "Poupança";
		case Investimento:
			return "Investimento";
		}
		return null;
	}
}