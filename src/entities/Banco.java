package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	private List<Conta> conta = new ArrayList<>();
	
	public Banco() {}
	
	public Banco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return conta;
	}

	public void addContas(Conta contas) {
		this.conta.add(contas);
	}
	
	public void removeContas(Conta contas) {
		this.conta.remove(contas);
	}
	
	public void imprimirContas() {
		System.out.println("Nome do banco: " + nome);
		for(Conta c: conta) {
			System.out.println(c.getCliente().getName() + " - " + c.getNumero() );
		}
	}
	
	

}
