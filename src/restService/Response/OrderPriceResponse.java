package restService.Response;

import java.util.ArrayList;
import DomainObject.OrderPriceDomainObject;

public class OrderPriceResponse {

	private final int totalPrice;
    private final ArrayList<PizzaPriceResponse> pizzas;

	public OrderPriceResponse(OrderPriceDomainObject domainObject) {
		this.totalPrice = domainObject.getPrice();
        this.pizzas = PizzaPriceResponse.MapList(domainObject.getPizzas());
	}


	public int getTotalPrice() {
		return totalPrice;
	}

    public ArrayList<PizzaPriceResponse> getPizzas() {
        return pizzas;
    }


}
