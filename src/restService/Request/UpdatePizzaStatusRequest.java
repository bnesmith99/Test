package restService.Request;

public class UpdatePizzaStatusRequest {

	private final int orderId;
	private final int pizzaId;
	private final String pizzaStatus;

	public UpdatePizzaStatusRequest(int orderId, int pizzaId, String pizzaStatus) {
		this.orderId = orderId;
		this.pizzaId = pizzaId;
		this.pizzaStatus = pizzaStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public String getPizzaStatus() {
		return pizzaStatus;
	}

}