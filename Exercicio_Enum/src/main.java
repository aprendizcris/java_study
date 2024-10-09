import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class main {

	static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("* Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client( name, email, birthDate );

		System.out.println("* Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();

		Order order = new Order( OrderStatus.valueOf(status), client );
	
		boolean continua = true;
		int sequence = 1;
		do {
			System.out.printf( "Enter #%d item data:%n", sequence++ );
			
			System.out.print("Product name: ");
			String product = sc.next();
			
			System.out.print("Product price: ");
			Double price = sc.nextDouble();

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			Product prod = new Product( product, price);
			OrderItem item = new OrderItem(prod, quantity);
			order.addItem(item);

			System.out.print("\nNovo item (S/N)?: ");
			String cont = sc.next().toUpperCase();
			continua = cont.equals("S");
			int xy1 = 1;
		} while (continua);

		System.out.println( order.toString() );

		sc.close();
 /*		
		for ( OrderStatus obj : OrderStatus.values() ) {
			System.out.printf( "Descript: %s - #%d%n", obj, obj.sequence() );
		}
*/
	}
}
