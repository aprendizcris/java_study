package entities;

public class Product {

	static String name  = "";
	static double price = 0.0;
	static int    stock = 0;
	static double totalCost = 0.0;

	public Product() {
		
	}

	public Product( String name, double price ) {
		Product.name  = name;
		Product.price = price;
		Product.totalCost = price * stock;

		show( "Product" );
	}

	public Product( String name, double price, int stock ) {
		Product.name  = name;
		Product.price = price;
		Product.stock = stock;
		Product.totalCost = price * stock;

		show( "Product" );
	}

	public void setProduct( String name, double price, int stock ) {
		Product.name  = name;
		Product.price = price;
		Product.stock = stock;
		Product.totalCost = price * stock;

		show( "Product" );
	}
	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Product.name = name;
	}

	public static double getPrice() {
		return price;
	}

	public static void setPrice(double price) {
		Product.price = price;
	}

	public static int getStock() {
		return stock;
	}

	public void addQuantity( int quant) {
		Product.stock += quant;
		Product.totalCost = Product.price * Product.stock;

		show( "Updated" );
	}

	public void removeQuantity( int quant) {
		Product.stock -= quant;
		Product.totalCost = Product.price * Product.stock;

		show( "Updated" );
	}

	static void show( String moveType ) {
		String text = moveType +
				" data: " + name +
				", $ " + price +
				", " + stock +
				" units, Total: $ " +
				totalCost;
		System.out.println( text );
	}
}
