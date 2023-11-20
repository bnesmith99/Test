package Model;
import java.util.ArrayList;

import DomainObject.OrderDomainObject;
import DomainObject.OrderPriceDomainObject;
import DomainObject.PizzaDomainObject;
import restService.Message;


public class OrderModel {
	
	private static ArrayList<OrderDomainObject> orders;
    private static boolean initialized = false;

	public OrderModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		orders = new ArrayList<OrderDomainObject>();
	
		//Default Data  
        //Used for Test 2.2
		orders.add( new OrderDomainObject (1, "Complete", 1));
		orders.add( new OrderDomainObject (2, "Not Submitted", 1));
		orders.add( new OrderDomainObject (3, "Submitted", 1));		
		
        //Used for Test 2.2
        orders.add( new OrderDomainObject (4, "Not Submitted", 2));		
		orders.add( new OrderDomainObject (5, "Not Submitted", 3));		
		orders.add( new OrderDomainObject (6, "Complete", 2));		
		orders.add( new OrderDomainObject (7, "Not Submitted", 2));		

        //Used for Test 2.4
		orders.add( new OrderDomainObject (8, "Submitted", 10));		
        orders.add( new OrderDomainObject (9, "Submitted", 10));		


        //Used for Test 2.5
		orders.add( new OrderDomainObject (10, "Not Submitted", 11));		
		orders.add( new OrderDomainObject (11, "Not Submitted", 12));		
		orders.add( new OrderDomainObject (12, "Not Submitted", 13));		

        //Used for Test 2.4
		orders.add( new OrderDomainObject (13, "Submitted", 10));		
		orders.add( new OrderDomainObject (14, "Submitted", 10));		
        orders.add( new OrderDomainObject (15, "Preparing", 10));		

        //Not used in any test yet
		//orders.add( new OrderDomainObject (9, "Cancelled", 2));		

        initialized = true;
	}

	private static int getNextId() {
		return orders.size()+1;
	}

	public static ArrayList<OrderDomainObject> GetAllOrders() {
		return orders;
	}

	public static ArrayList<OrderDomainObject> GetActiveOrders() {
		
        ArrayList<OrderDomainObject> active = new ArrayList<OrderDomainObject>();
	
		for (OrderDomainObject order : orders) {
			if (order.orderStatus.equals("Ordered")) {
				active.add(order);
			}
		}
        
        return active;
	}
    

	public static OrderDomainObject GetOrderById(int orderId) {
		
		for (OrderDomainObject order : orders) {
			if (order.orderId == orderId) {
				return order;
			}
		}

		return null;
	}


	public static OrderDomainObject CreateOrder(Message message, OrderDomainObject data) {
		//This needs to be implemented.
        return null;
    }


	public static OrderDomainObject CancelOrder(Message message, int orderId) {
		//This needs to be implemented.
        return null;
    }

    public static OrderDomainObject SubmitOrder(Message message, int orderId) {
		//This needs to be implemented.
        return null;
	}

	public static OrderDomainObject UpdatePizzaStatus(Message message, int orderId, int pizzaId, String pizzaStatus) {
		//This needs to be implemented.
        return null;
	}


    public static OrderDomainObject AddPizzaToOrder(Message message, PizzaDomainObject data) {
		//This needs to be implemented.
        return null;
	}

    public static OrderPriceDomainObject PriceOrder(Message message, OrderPriceDomainObject order) {
		//This needs to be implemented.
        return null;
    }

}
