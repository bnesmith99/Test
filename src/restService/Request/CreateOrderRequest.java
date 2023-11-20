package restService.Request;

public class CreateOrderRequest {

	private final int customerId;

	public CreateOrderRequest(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

}