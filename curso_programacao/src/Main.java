import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.Product;
import entities.Triangle;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o número de pessoas: ");
		int n = sc.nextInt();

		Pessoa[] vect = new Pessoa[n];
		
		for (int i=0; i<vect.length; i++) {
			sc.nextLine();
			
			System.out.print("Nome #"+(i+1)+": ");
			String name = sc.nextLine();

			System.out.print("Idade #"+(i+1)+": ");
			int idade = sc.nextInt();

			System.out.print("Altura #"+(i+1)+": ");
			double altura = sc.nextDouble();

			vect[i] = new Pessoa( name, idade, altura );
		}

		double altura = 0;
		int    menoresQtd  = 0;
		String menoresNome = "";
		for (int i=0;i<vect.length;i++) {
			altura += vect[i].getAltura();
			if (vect[i].getIdade() < 16) {
				menoresQtd++;
				menoresNome += vect[i].getName() + "\n";
			}
		}
		double alturaMedia = altura / vect.length;
		System.out.printf("Altura média é %.2f%n", alturaMedia );

		double menoresPercent = menoresQtd * 100 / vect.length;
		
		System.out.printf("Pessoas com menos de 16 anos: %d - %.1f%n", menoresQtd, menoresPercent );
		System.out.println(menoresNome);


		sc.close();
/*
		Scanner sc = new Scanner(System.in);
		int x1, x2;

		System.out.print("Informe 1o numero: ");
		x1 = sc.nextInt();
		
		System.out.print("Informe 2o numero: ");
		x2 = sc.nextInt();

		System.out.println( x1 % x2 );
		System.out.println( x2 % x1 );

		if ( x1 % x2 == 0.0 || x2 % x1 == 0.0)
			System.out.println("São múltiplos");
		else
			System.out.println("Não são múltiplos");
		textos();
		
		triangulo();

		Produto();
		
		vetor();
*/
	}

	static void vetor() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o número de produtos: ");
		int n = sc.nextInt();

		Product[] vect = new Product[n];
		double acm = 0.0;
		
		for (int i=0; i<vect.length; i++) {
			sc.nextLine();
			
			System.out.print("Nome do Produto #"+(i+1)+": ");
			String name = sc.nextLine();

			System.out.print("Preco do Produto #"+(i+1)+": ");
			double price = sc.nextDouble();

			vect[i] = new Product( name, price );
			acm += price;
		}

		System.out.printf("A média dos valores é %.2f%n", (acm/n) );
		sc.close();
	}
	
	static void Produto() {
		Product prod = new Product();
		Scanner sc   = new Scanner(System.in);
		String  nome;
		double  preco;
		int     quant;

		Locale.setDefault(Locale.US);

		System.out.println("Enter product data:");
		
		System.out.print("Name: ");
		nome  = sc.nextLine();
		System.out.print("Price: ");
		preco = sc.nextDouble();
		System.out.print("Quantity in stock: ");
		quant = sc.nextInt();
		
		prod.setProduct(nome, preco, quant);


		System.out.print("Enter number to Add: ");
		prod.addQuantity( sc.nextInt() );

		System.out.print("Enter number to Remove: ");
		prod.removeQuantity( sc.nextInt() );

		
//		prod.addQuantity( 5 );
		
//		prod.removeQuantity( 3 );
		
		sc.close();
	}
	
	
	
	static void triangulo() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangle x, y;
		
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("informe 3 valores de X:");

		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		System.out.println("informe 3 valores de Y:");
		y.setValue(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
/*
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
*/
		x.calcArea();		
		y.calcArea();

		if (x.getArea() > y.getArea() ) System.out.printf("X tem a maior área: %.4f%n", x.getArea());
		else 
			if (x.area > y.area) System.out.printf("Y tem a maior área: %.4f%n", y.area);
			else
				System.out.println("ambos tem a mesma área");
		sc.close();
	}
	
	
	static void textos() {
		String texto = "abcd EFGH ABC abc DEFG   ";

		System.out.println( "Original...............: [" + texto + "]");
		System.out.println( "lowerCase..............: [" + texto.toLowerCase() + "]");
		System.out.println( "upperCase..............: [" + texto.toUpperCase() + "]");
		System.out.println( "trim...................: [" + texto.trim() + "]");
		System.out.println( "subString(2)...........: [" + texto.substring(2) + "]");
		System.out.println( "subString(2,9).........: [" + texto.substring(2,9) + "]");
		System.out.println( "replace('a','x').......: [" + texto.replace('a', 'x') + "]");
		System.out.println( "replace('abc','xy')....: [" + texto.replace("abc", "xy") + "]");
		System.out.println( "texto.indexOf('bc')....: [" + texto.indexOf("bc") + "]");
		System.out.println( "texto.lastIndexOf('bc'): [" + texto.lastIndexOf("bc") + "]");
		
		String[] vetor = texto.split(" ");
		System.out.println("vetor[0] " + vetor[0]);
		System.out.println("vetor[1] " + vetor[1]);
		System.out.println("vetor[3] " + vetor[3]);
	}
}
