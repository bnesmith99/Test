package DomainObject;

import java.util.ArrayList;
import restService.Request.OrderPriceRequest;

public class OrderPriceDomainObject {

    //Data Objects
    public int price;
    private ArrayList<PizzaPriceDomainObject> pizzas;


	public OrderPriceDomainObject(OrderPriceRequest data) {
		this.price = -1;

        pizzas = PizzaPriceDomainObject.MapList(data.getPizzas());

    }

    public int getPrice() {
        return price;
    }


    public ArrayList<PizzaPriceDomainObject> getPizzas() {
        return pizzas;
    }



}
