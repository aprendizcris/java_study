import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		File file = new File("C:\\TEMP\\IN.TXT");
		Scanner sc = null;

		System.out.println("start program");

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println( sc.nextLine() );
			}
		}
		catch (FileNotFoundException e) {
			System.err.println( e.getMessage() );
		}
		finally {
			if (sc != null) sc.close();
		}
		
		System.out.println("end of program");
	}

}
