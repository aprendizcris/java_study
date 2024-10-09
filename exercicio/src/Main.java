import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		System.out.println("Exercício - Funcionários\n");

		List<funcionario> list = new ArrayList<>();
		int id = 0;
		int pos;

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Número funcionários: ");
		int N = sc.nextInt();
		
		for (int i=0;i<N;i++) {
			System.out.println("\nFuncionário #" + (i+1) + " de " + N );
			boolean achou = false;

			while ( ! achou ) { // check se existe ID
				System.out.print("Id: ");
				id = sc.nextInt();

				final int search = id;
				List<funcionario> result = list.stream().filter(x -> x.id == search).collect(Collectors.toList());

				if ( result.size() > 0 ) {
					System.out.println("ID já existente.. informe outro\n");
				} else achou = true;
			}

			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			
			list.add( new funcionario( id, name, salary ) );
		}
		
		System.out.println("*** aumento de salário ***");
		System.out.print("Informe o ID:");
		id = sc.nextInt();

		pos = buscaID( list, id );
		if ( pos == -1 ) {
			System.out.println("ID não encontrado");
		} else {
			// aplicar acrescimo
			System.out.print("Informe o % de aumento:");
			double increase = sc.nextDouble();
			
			double salary = list.get(pos).getSalary();
			salary += salary * increase / 100;

			list.get(pos).setSalary(salary);
		}

		System.out.println("\nTamanho da lista: " + list.size());
		System.out.println("-------------------");

		for (funcionario x : list) {
			System.out.print("  #" + x.id + " - " + x.name + " - $ ");
			System.out.printf("%.2f%n", x.getSalary());
		}

		System.out.println("*** fim de programa ***");
		sc.close();
	}


	static int buscaID( List<funcionario> func, int id ) {
		for (int i = 0; i < func.size(); i++) {
			if (func.get(i).id == id) return i;
		}
		return -1;
	}

}
