
public enum OrderStatus {
	PENDING_PAYMENT	(0),
	PROCESSING		(1),
	SHIPPED			(2),
	DELIVERED		(3);

	private final int seq;
	
	OrderStatus( int sequence ){
		this.seq = sequence;
	}

	int sequence() { return this.seq; }
}
