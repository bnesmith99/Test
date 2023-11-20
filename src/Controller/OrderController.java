package Controller;

import java.util.ArrayList;


import DomainObject.OrderDomainObject;
import DomainObject.PizzaDomainObject;
import Model.OrderModel;
import restService.Message;
import restService.Request.AddPizzaToOrderRequest;
import restService.Request.CancelOrderRequest;
import restService.Request.CreateOrderRequest;
import restService.Request.SubmitOrderRequest;
import restService.Request.UpdatePizzaStatusRequest;
import restService.Response.OrderResponse;

public class OrderController {
	//The OrderController will convert the request from the REST Request and the Domain Model.
	//Then it will call the Model or Service, and convert the response from the Domain model
	//to the REST Response.
	public static ArrayList<OrderResponse> getAllOrders(Message message) {
		try {
			ArrayList<OrderDomainObject> domain = OrderModel.GetAllOrders();

            if (domain == null)
                return null;

			ArrayList<OrderResponse> response = OrderResponse.MapList(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}
	}

    public static ArrayList<OrderResponse> getActiveOrders(Message message) {
		try {
			ArrayList<OrderDomainObject> domain = OrderModel.GetActiveOrders();

            if (domain == null)
                return null;

			ArrayList<OrderResponse> response = OrderResponse.MapList(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}
	}

	public static OrderResponse getOrderByOrderId(Message message, int orderId) {
		try {
			OrderDomainObject domain = OrderModel.GetOrderById(orderId);

            if (domain == null)
                return null;

			OrderResponse response = new OrderResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}
	}

	public static OrderResponse createOrder(Message message, CreateOrderRequest request) {
		try {
			OrderDomainObject newOrder = new OrderDomainObject(request);
			OrderDomainObject domain = OrderModel.CreateOrder(message, newOrder);
            
            if (domain == null)
                return null;

			OrderResponse response = new OrderResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}

	public static OrderResponse cancelOrder(Message message, CancelOrderRequest request) {
		try {
			int orderId = request.getOrderId();
			OrderDomainObject domain = OrderModel.CancelOrder(message, orderId);

            if (domain == null)
                return null;

			OrderResponse response = new OrderResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}

	public static OrderResponse submitOrder(Message message, SubmitOrderRequest request) {
		try {
			int orderId = request.getOrderId();
			OrderDomainObject domain = OrderModel.SubmitOrder(message, orderId);

            if (domain == null)
                return null;

			OrderResponse response = new OrderResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}

	public static OrderResponse UpdatePizzaStatus(Message message, UpdatePizzaStatusRequest request) {
		try {
			int orderId = request.getOrderId();
            int pizzaId = request.getPizzaId();
            String pizzaStatus = request.getPizzaStatus();
			OrderDomainObject domain = OrderModel.UpdatePizzaStatus(message, orderId, pizzaId, pizzaStatus);
           
            if (domain == null)
                return null;

			OrderResponse response = new OrderResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}


	public static OrderResponse AddPizzaToOrder(Message message, AddPizzaToOrderRequest request) {
		try {
			PizzaDomainObject newPizza = new PizzaDomainObject(request);
			OrderDomainObject domain = OrderModel.AddPizzaToOrder(message, newPizza);
            
            if (domain == null)
                return null;
			
            OrderResponse response = new OrderResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}


}
