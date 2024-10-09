import java.util.Scanner;

public class Main {

	public static final int MAX = 10;
	public static Estudante[] quartos = new Estudante[MAX];

	public static void main(String[] args) {

		System.out.println("=== Pensionato ===");
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Número de estudantes: ");
		int numEstudantes = sc.nextInt();

		for (int i=1;i<=numEstudantes;i++) {
			System.out.printf("#%d Nome: ", i);
			String nome = sc.next();
			System.out.printf("#%d E-mail: ", i);
			String email = sc.next();

			int quarto = 0;
			boolean ok = false;
			while (!ok) {
				System.out.printf("#%d Quarto: [0-9]", i);
				quarto = sc.nextInt();
				
				if (quarto < 0 || quarto > 9) {
					System.out.println("valor incorreto!");
				} else {				
					if (quartos[quarto] != null) {
						System.out.println("infelizmente quarto ocupado");
					} else {
						ok = true;
					}
				}
			}

			quartos[quarto] = new Estudante(nome, email);
			quartoStatus();
		}
		
		sc.close();
		System.out.println("programa concluído");
	}

	static void quartoStatus() {
		System.out.printf("%nStatus quartos:%n");
		for (int i=0;i<MAX;i++) {
			String status = "vago";
			if (quartos[i] != null) {
				status = "ocupado - " + quartos[i].nome;
			}
			System.out.printf("#%d - %s %n", i, status);
		}
		System.out.println();
	}
}
