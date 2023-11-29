package Model;
import java.util.ArrayList;

import DomainObject.OrderDomainObject;
import DomainObject.OrderPriceDomainObject;
import DomainObject.PizzaDomainObject;
import restService.Message;
import restService.Request.UpdatePizzaStatusRequest;


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

public static OrderDomainObject GetOrdersByCustomerId(int customerId) {
	
		for (OrderDomainObject order : orders) {
			if (order.customerId == customerId) {
				return order;
			}
		}
	
		return null;
	}
	
	public static OrderDomainObject CreateOrder(Message message, OrderDomainObject data) {    
		if (data == null) {
			message.addErrorMessage("Order data cannot be null");
			
			return null;
			}

	public static OrderDomainObject CreateOrder(Message message, OrderDomainObject data) {
			if (CustomerModel.GetCustomerById(data.customerId) == null) {
				message.addErrorMessage("CustomerId does not exist");
				
				return null;
			}
	
			for (OrderDomainObject existingOrder : orders) {
				if (existingOrder.customerId == data.customerId && existingOrder.orderStatus.equals("Not Submitted")) {
					message.addErrorMessage("Please submit your existing order before starting a new order.");
					return null;
				}
			}

			data.orderId = getNextId();

			data.orderStatus = "Not Submitted";

			orders.add(data);
	
			return data;
	}


	public static OrderDomainObject CancelOrder(Message message, int orderId) {
		OrderDomainObject OID = GetOrderById(orderId);
		if(OID != null) {
			if (GetOrderById(orderId).orderStatus == "Submitted" || GetOrderById(orderId).orderStatus == "Not Submitted") {
				OrderDomainObject order = GetOrderById(orderId);
				int customerID = order.customerId;
				order.setOrderStatus("Cancelled");
				OrderDomainObject orders = new OrderDomainObject(orderId, "Cancelled", 0);
				new UpdatePizzaStatusRequest(customerID, 1, order.orderStatus.toString());
				ArrayList<PizzaDomainObject> orderPizzas = OID.getPizzas();
				for (PizzaDomainObject pizza : orderPizzas) {
					pizza.status = "Cancelled";
				}
				return orders;
			} else if (OID.orderStatus == "Preparing" || OID.orderStatus == "Complete") {
				message.addErrorMessage("This order is already being prepared.  The order cannot be cancelled.");
			}
		}else if (OID == null) {
			message.addErrorMessage("OrderId does not exist");
		}
		return null;
	}

    public static OrderDomainObject SubmitOrder(Message message, int orderId) {
		OrderDomainObject order = GetOrderById(orderId);
		if(order == null){ // Checks if order exists
			message.addErrorMessage("OrderId does not exist");
		}
		else if(!order.orderStatus.equals("Not Submitted")){ // Checks order status
			message.addErrorMessage("This order is already being prepared.  The order cannot be submitted.");
		}
		else if(PizzaModel.GetPizzasForOrderId(orderId).isEmpty()){ // Checks if there is at least ONE pizza
			message.addErrorMessage("Order must have at least one pizza.");
		}
		else{ // Updates statuses ONLY IF all validations are passed
			order.orderStatus = "Submitted";
			for (PizzaDomainObject pizza : PizzaModel.GetPizzasForOrderId(orderId)) {
				pizza.status = "Submitted";
			}
			return order;
		}
		
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
