package dio.banco_poo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Banco {

	@Setter
	private String nome;
	private List<Conta> contas;

	public Banco(String nome){
		this.nome = nome;
		contas = new ArrayList<>();
	}

	public void adicionar(Conta conta) {
		contas.add(conta);
	}

	public void exibirContas(){
		System.out.println("\n==============================");
		System.out.println("\t"+nome+"\n");

		for (Conta c : contas){
			c.imprimirExtrato();
			System.out.println();
		}

		System.out.println("==============================\n");
	}

	public void exibirContasCorrente() {
		System.out.println("\n==============================");
		System.out.println("\t"+nome+"\n");

		for (Conta c : contas){
			if (c instanceof ContaCorrente){
				c.imprimirExtrato();
				System.out.println();
			}
		}

		System.out.println("==============================\n");
	}

    public void exibirContasPoupanca() {
        System.out.println("\n==============================");
		System.out.println("\t"+nome+"\n");

		for (Conta c : contas){
			if (c instanceof ContaPoupanca){
				c.imprimirExtrato();
				System.out.println();
			}
		}

		System.out.println("==============================\n");
    }

}
