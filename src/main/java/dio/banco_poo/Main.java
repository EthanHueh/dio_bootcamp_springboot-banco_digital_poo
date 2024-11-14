package dio.banco_poo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Banco banco = inicializarBanco();

		do {
		
			System.out.println(
				"Escolha sua opção:\n"+

				"1 - Exibir todas as contas\n"+
				"2 - Exibir apenas contas correntes\n"+
				"3 - Exibir apenas contas poupancas\n"+
				"4 - Exemplo de Operacoes\n"+
				"5 - Sair do programa\n"
			);

			System.out.print(": ");

			int opcao = consistirInteiro(sc);

			switch (opcao) {
				case 1:
					banco.exibirContas();
					break;

				case 2:
					banco.exibirContasCorrente();
					break;

				case 3:
					banco.exibirContasPoupanca();
					break;

				case 4:
					exemploOperacoes(banco);
					break;
					
				case 5:
					System.out.println("Saindo do programa...");
					return;

				case 999:
					System.out.println("Saindo do programa...");
					sc.close();
					return;
			
				default:
					System.out.println("Opcao inexistente!");
					break;
				}
	
			}
			while (true);
					
	}

	private static Banco inicializarBanco() {
		Banco banco = new Banco("Banco do Basil");

		ContaCorrente cc1 = new ContaCorrente(new Cliente("Bruno"));
		ContaCorrente cc2 = new ContaCorrente(new Cliente("Haroldo"));
		ContaPoupanca cp1 = new ContaPoupanca(new Cliente("Katlyn"));
		ContaCorrente cc3 = new ContaCorrente(new Cliente("Josefina"));

		cc1.depositar(2000);
		cc2.depositar(1000);
		cp1.depositar(3500);
		cc3.depositar(1000);

		banco.adicionar(cc1);
		banco.adicionar(cc2);
		banco.adicionar(cp1);
		banco.adicionar(cc3);
		
		return banco;
	}

	private static void exemploOperacoes(Banco banco) {

		Conta cc = banco.getContas().get(0);
		Conta cp = banco.getContas().get(2);

		double saldo = 100;

		System.out.println("\n==============================\n");
		System.out.println(cp.cliente.getNome()+" depositando "+saldo+".");
		cp.depositar(100);

		System.out.println(cp.cliente.getNome()+" transferindo "+saldo+" para "+cc.cliente.getNome()+ ".");
		cp.transferir(100, cc);
		
		System.out.println();
		cp.imprimirExtrato();

		System.out.println();
		cc.imprimirExtrato();

		System.out.println("\n==============================\n");
	}

	private static int consistirInteiro(Scanner sc){
        do {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.print("Insira um número válido: ");
            }
        }
        while (true);
	}

}
