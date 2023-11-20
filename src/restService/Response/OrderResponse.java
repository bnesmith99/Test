package restService.Response;

import java.util.ArrayList;
import DomainObject.OrderDomainObject;
import DomainObject.PizzaDomainObject;


public class OrderResponse {

	private final int orderId;
	private final String orderStatus;
	private final String customerName;

    private final ArrayList<PizzaResponse> pizzas;

	public OrderResponse(int orderId, String orderStatus, String customerName) {
		this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.customerName = customerName;
        this.pizzas = null;
	}

	public OrderResponse(OrderDomainObject domainObject) {
		this.orderId = domainObject.orderId;
        this.orderStatus = domainObject.orderStatus;
        if (domainObject.getCustomer() != null)
            this.customerName = domainObject.getCustomer().name;
        else
            this.customerName = "";

        this.pizzas = PizzaResponse.MapList(domainObject.getPizzas());

	}

	public static ArrayList<OrderResponse> MapList(ArrayList<OrderDomainObject> domainList) {
		ArrayList<OrderResponse> responseList = new ArrayList<OrderResponse>();
		
		for (int i=0; i<domainList.size(); i++) {
			OrderResponse response = new OrderResponse(domainList.get(i));
			responseList.add(response);
		}

		return responseList;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public String getCustomerName() {
		return customerName;
	}

    public ArrayList<PizzaResponse> getPizzas() {
        return pizzas;
    }


}
