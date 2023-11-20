package restService.Request;

import java.util.ArrayList;

public class OrderPriceRequest {

    private final ArrayList<PizzaPriceRequest> pizzas;

	public OrderPriceRequest(ArrayList<PizzaPriceRequest> pizzas) {
		this.pizzas = pizzas;
	}

	public ArrayList<PizzaPriceRequest> getPizzas() {
		return pizzas;
	} 

}