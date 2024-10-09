import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");

		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		System.out.println("Index of Juca: " + list.indexOf("Juca"));

		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("--------------");

		list.add(2, "Marco");

// como filtrar com a letra A
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

		System.out.println("Iniciados com 'A'");
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("--------------");
//------		
		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println( "1o nome com a letra A: " + name );
		System.out.println("--------------");
		
		list.remove("Anna");
		list.remove(1);

		System.out.println("Tamanho da lista: " + list.size());
		System.out.println("--------------");

		for (String x : list) {
			System.out.println(x);
		}
		
		System.out.println("----------------");

		list.removeIf(x -> x.charAt(0) == 'M');

		for (String x : list) {
			System.out.println(x);
		}
}

}
