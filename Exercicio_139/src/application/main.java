package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Número de contribuintes: ");
		int contrib = sc.nextInt();
		
		for (int i=1; i <= contrib; i++) {
			System.out.println("Contribuinte #"+i+" dados:");
			
			System.out.print("Pessoa Física ou Jurídica (F/J): ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			String nome = sc.next();
			
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if ( ch == 'F' ) {
				System.out.print("Gastos médicos: ");
				double gastosMedicos = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosMedicos));
			} else {
				System.out.print("Número de funcionários: ");
				int numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
		}
		sc.close();
		
		System.out.println();
		System.out.println("PAGAMENTO DE IMPOSTOS:");

		Double totalTaxas = 0.0;
		
		for (Pessoa pessoa : list) {
			Double taxa = pessoa.imposto();
			totalTaxas += taxa;
			
			System.out.println( pessoa.getNome() + " $" + String.format("%.2f", taxa) );
		}
		
		System.out.println();
		System.out.println("Impostos total: $" + String.format("%.2f", totalTaxas));
	}
}
