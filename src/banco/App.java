package banco;

public class App {
	public static void main(String args[]) {
		
		Conta cc = new ContaCorrente(100,3009009, "Maria");
		Conta cp = new ContaPoupanca(100,3013049,"Antonio");
		Conta ci = new ContaInvestimento(100,30130578,"Jos�");
		
		cc.depositar(50);
		cp.depositar(50);
		ci.depositar(50);
		
		System.out.println("Saldo Conta Corrente = "+ cc.getSaldo());
		System.out.println("Saldo Conta Poupan�a = "+ cp.getSaldo());
		System.out.println("Saldo Conta Investimento = "+ ci.getSaldo());
		
		cc.retirar(25);
		cp.retirar(25);
		ci.retirar(25);
		
		System.out.println("\nSaldo Conta Corrente = "+ cc.getSaldo());
		System.out.println("Saldo Conta Poupan�a = "+ cp.getSaldo());
		System.out.println("Saldo Conta Investimento = "+ ci.getSaldo());
		
		cc.transferirPara(cp, 100);
		cp.transferirPara(ci, 100);
		ci.transferirPara(cc, 50);
		
		System.out.println("\nSaldo Conta Corrente = "+ cc.getSaldo());
		System.out.println("Saldo Conta Poupan�a = "+ cp.getSaldo());
		System.out.println("Saldo Conta Investimento = "+ ci.getSaldo());
		
		cc.render();
		cp.render();
		ci.render();
		
		System.out.println("\nSaldo Conta Corrente = "+ cc.getSaldo());
		System.out.println("Saldo Conta Poupan�a = "+ cp.getSaldo());
		System.out.println("Saldo Conta Investimento = "+ ci.getSaldo());
	}
}