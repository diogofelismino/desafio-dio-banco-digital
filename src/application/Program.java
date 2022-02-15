package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Conta> conta = new ArrayList<>();

		System.out.print("Quantas conta deseja criar ? ");
		int n = sc.nextInt();
		Banco banco = new Banco("BancoDio");

		for (int i = 0; i < n; i++) {
			System.out.print("Nome do titular: ");
			String name = sc.next();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();

			Cliente cliente = new Cliente(name);

			System.out.print("Deseja criar uma conta corrente ou poupanca: [C/P]: ");
			char tipoConta = sc.next().toUpperCase().charAt(0);

			if (tipoConta == 'C') {
				Conta contaCC = new ContaCorrente(saldo, cliente);
				banco.addContas(contaCC);
				conta.add(contaCC);
			} else if (tipoConta == 'P') {
				Conta contaPP = new ContaPoupanca(saldo, cliente);
				banco.addContas(contaPP);
				conta.add(contaPP);
			}
		}

		banco.imprimirContas();

		System.out.println();
		boolean testeWl = true;

		while (testeWl) {
			try {
				
				System.out.print("----------------------------\n");
				System.out.print("Qual conta deseja acessar: ");
				int acesso = sc.nextInt();
				
				conta.get(acesso-1);

				System.out.print("Deseja sacar, depositar, transferir,"
						+ " imprimir extrato ou finalizar operação [S/D/T/I/F] ? ");
				char esc = sc.next().toUpperCase().charAt(0);

				switch (esc) {
				case 'S':
					System.out.print("Valor a ser sacado: ");
					double valor = sc.nextDouble();
					conta.get(acesso - 1).saque(valor);
					break;

				case 'D':
					System.out.print("Valor a ser depositado: ");
					valor = sc.nextDouble();
					conta.get(acesso - 1).deposito(valor);
					break;

				case 'T':
					System.out.print("Numero da conta que recebera a transferencia: ");
					int numConta = sc.nextInt();
					System.out.print("Valor a ser Trasferido: ");
					valor = sc.nextDouble();
					conta.get(acesso - 1).transferencia(valor, conta.get(numConta - 1));
					break;

				case 'I':
					conta.get(acesso - 1).imprimirExtrato();
					break;

				case 'F':
					testeWl = false;
					break;

				default:
					System.out.println("Operação invalida!!! Digite um operação validade.");
					continue;

				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			}

		}

		sc.close();
	}

}
