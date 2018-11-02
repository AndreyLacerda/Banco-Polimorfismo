package banco;

import java.util.Collection;
import java.util.ArrayList;

public class Banco {
	
	private  Collection<Conta> contas = new ArrayList<Conta>();
	private  Collection<Correntista> correntistas = new ArrayList<Correntista>();
	
	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public void adicionarCorrentista(Correntista correntista) {
		this.correntistas.add(correntista);
	}
	
	public void removerConta(Conta conta) {
		this.contas.remove(conta);
	}
	
	public void removerCorrentista(Correntista correntista) {
		this.correntistas.remove(correntista);
	}
	
	public  Conta buscarPorNumero(int numeroConta) {		
		Conta resultado = null;
		
		for(Conta conta : this.contas) {
			if(conta.getNumero() == numeroConta) {
				resultado = conta;
				break;
			}
		}
		
		return resultado;
	}
	
	public  Correntista buscarCPF(String cpf) {		
		Correntista resultado = null;
		
		for(Correntista correntista : this.correntistas) {
			if(correntista.getCPF().equals(cpf)) {
				resultado = correntista;
				break;
			}
		}
		
		return resultado;
	}
	
}