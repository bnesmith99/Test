package restService.Request;

public class CancelOrderRequest {

	private final int orderId;

	public CancelOrderRequest(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

}