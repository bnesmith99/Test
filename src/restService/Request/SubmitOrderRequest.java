package restService.Request;

public class SubmitOrderRequest {

	private final int orderId;

	public SubmitOrderRequest(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

}