package enumeracao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department´s name: ");
		String depto = sc.nextLine();

		System.out.print("Enter worker date:");

		System.out.print("Name:");
		String name = sc.nextLine();

		System.out.print("Level:");
		String auxLevel = sc.nextLine();
		
		System.out.print("Base salary:");
		Double salary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(auxLevel), salary, new Department(depto));
		

		
		System.out.println("How many contracts to this worker? ");
		int nContracts = sc.nextInt();

		Date date;
		Double valor;
		int duracao;
		
		for ( int i=1; i <= nContracts; i++ ) {
			sc.nextLine();
			System.out.println("Enter contract #" +i+" data: ");

			System.out.print("Date (dd/mm/yyyy): ");
			date = sdf.parse(sc.next());

			System.out.print("Value per hour: ");
			valor = sc.nextDouble();
			
			System.out.print("Duration: ");
			duracao = sc.nextInt();

			HourContract contract = new HourContract(date, valor, duracao);
			worker.addContract(contract);
		}
		sc.nextLine();

		System.out.println();
		
		System.out.print("Enter month and year calculate income (MM/YYYY): ");
		String cAux = sc.nextLine();
		int month = Integer.parseInt(cAux.substring(0, 2));
		int year = Integer.parseInt(cAux.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());

		System.out.print("Income for " + cAux + ": " );
		System.out.printf("%.2f%n", worker.income(year, month));
		
		sc.close();
	}
}
