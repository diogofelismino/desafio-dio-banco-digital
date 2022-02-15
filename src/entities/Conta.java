package entities;

public class Conta {
	
	private static int SEQUENCIAL = 1;
	private static int AGENCIA_PADRAO = 1;
	
	
	private int agencia;
	private int numero;
	protected double saldo;
	
	private Cliente cliente;

	public Conta(double saldo, Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public void saque(double valor) {	
		if(valor <= saldo) {
			this.saldo -= valor;
		}
		else {
			System.out.println("Saldo insuficiente para o saque.");
		}
	}
	
	public void transferencia(double valor, Conta contaDestino) {
		this.saque(valor);
		contaDestino.deposito(valor);
	}
	
	public void imprimirExtrato() {
		System.out.println(String.format("Titular: %s", getCliente().getName()));
		System.out.println(String.format("Agencia: %d", getAgencia()));
		System.out.println(String.format("Numero: %d", getNumero()));
		System.out.println(String.format("Saldo: %.2f", getSaldo()));
	}

}
