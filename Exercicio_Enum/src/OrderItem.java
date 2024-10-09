
public class OrderItem {
	private Product product;
	private int quantity;
	private Double price;
	private int sequence;

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.price = this.product.getPrice();
	}

	public Double subTotal() {
		return this.quantity * this.price;
	}

	public int getSequence() { return this.sequence; }
	public String getProdName() { return this.product.getName(); }
	public int getQuant()    { return this.quantity; }

	public void setSequence( int sequence ) {
		this.sequence = sequence;
	}
}
