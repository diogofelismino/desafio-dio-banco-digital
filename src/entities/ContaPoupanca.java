package entities;

public class ContaPoupanca extends Conta {

	
	public ContaPoupanca(double saldo, Cliente cliente) {
		super(saldo, cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("-----Extrato da Conta Poupança-----");
		super.imprimirExtrato();
	}
}
