import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private Date moment;
	private OrderStatus status;
	private int numItens;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
		this.moment = new Date();
		this.numItens = 0;
	}

	public Date getMoment() {
		return moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public Client getClient() {
		return client;
	}

	public int getNumItems() {
		return this.items.size();
	}

	void addItem( OrderItem item ) {
		this.items.add(item);
		this.numItens++;
		item.setSequence( this.numItens );
	}

	void removeItem( OrderItem item ) {
		this.items.remove(item);
		this.numItens--;
	}

	Double total() {
		Double total = 0.0;

		for (OrderItem it : this.items)
			total += it.subTotal();
		return total;
	}
	
	public String toString() {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf2.format( this.getMoment() ) +"\n" );
		sb.append("Order status: " + this.getStatus() + "\n");
		sb.append("Client: " + this.getClient().getName() );
		sb.append(" (" + sdf.format( this.getClient().getBirthDate() ) + ") - ");
		sb.append( this.getClient().getEmail() + "\n");
		sb.append("Order items:\n");

		for ( OrderItem oi : this.items ) {
			sb.append("#" + oi.getSequence() );
			sb.append(" " + oi.getProdName() );
			sb.append(", Quantity: " + oi.getQuant() );
			sb.append(", Subtotal: $" + oi.subTotal() );
			sb.append("\n");
		}
		sb.append("Total price: $" + this.total() );

		return sb.toString();
	}
}
