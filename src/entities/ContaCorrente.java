package entities;

public class ContaCorrente extends Conta{
	
	
	public ContaCorrente(double saldo, Cliente cliente) {
		super(saldo, cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("-----Extrato da Conta Corrente-----");
		super.imprimirExtrato();
	}


}
