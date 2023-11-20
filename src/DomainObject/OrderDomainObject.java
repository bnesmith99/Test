package DomainObject;

import java.util.ArrayList;
import Model.CustomerModel;
import Model.PizzaModel;
import restService.Request.CreateOrderRequest;

public class OrderDomainObject {

    //Data Objects
    public int orderId;
    public String orderStatus;
	public int customerId;


    //Domain Objects
    //private CustomerDomainObject customer;
    //private ArrayList<PizzaDomainObject> pizzas;

   
    public OrderDomainObject (int orderId, String orderStatus, int customerId) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.customerId = customerId;
    }

	public OrderDomainObject(CreateOrderRequest data) {
		this.orderId = -1;
        this.orderStatus = "";
        this.customerId = data.getCustomerId();
    }

    public CustomerDomainObject getCustomer() {
        return CustomerModel.GetCustomerById(customerId);
    }


    public ArrayList<PizzaDomainObject> getPizzas() {
        return PizzaModel.GetPizzasForOrderId(orderId);
    }

}
