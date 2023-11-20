package restService.Request;

public class AddPizzaToOrderRequest {

	private final int orderId;
	private final int crustId;
	private final int sauceId;
	private final int sizeId;
	private final int toppingId;


	public AddPizzaToOrderRequest(int orderId, int crustId, int sauceId, int sizeId, int toppingId) {
		this.orderId = orderId;
		this.crustId = crustId;
		this.sauceId = sauceId;
		this.sizeId = sizeId;
		this.toppingId = toppingId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getCrustId() {
		return crustId;
	}

	public int getSauceId() {
		return sauceId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public int getToppingId() {
		return toppingId;
	}


}