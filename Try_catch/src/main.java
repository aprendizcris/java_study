import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		method1();
		
		System.out.println("End of Program");
	}
	
	public static void method1() {
		System.out.println("** METHOD1 - START **");
		method2();
		System.out.println("** METHOD1 - STOP **");
	}

	public static void method2() {
		System.out.println("** METHOD2 - START **");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escreva uma frase");
		String[] vect = sc.nextLine().split(" ");
		
		System.out.println("a frase gerou "+ vect.length +" palavras.");

		try {
			System.out.print("Informe um número: ");
			int position = sc.nextInt();
			System.out.println("Palavra: " + vect[position]);
		}
		catch (InputMismatchException e) {
			System.err.println("Vc deveria informar um número inteiro.\n" + e.getMessage());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Vc informou um número maior.\n" + e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("Só Deus sabe o que vc fez.\n" + e.getMessage());
		}
		finally {
			System.out.println("... bloco finally - processa independente se deu erro ou não");
		}

		sc.close();
		
		System.out.println("** METHOD2 - STOP **");
	}
}
