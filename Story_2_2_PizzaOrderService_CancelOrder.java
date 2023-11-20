import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Controller.OrderController;
import Model.CrustModel;
import Model.CustomerModel;
import Model.OrderModel;
import Model.PizzaModel;
import Model.SauceModel;
import Model.SizeModel;
import Model.ToppingModel;

import restService.Message;
import restService.Request.CancelOrderRequest;
import restService.Response.OrderResponse;
import restService.Response.PizzaResponse;

public class Story_2_2_PizzaOrderService_CancelOrder {
  
    @Before
    public void Setup() {
        CrustModel crustModel = new CrustModel();
        SauceModel sauceModel = new SauceModel();
        SizeModel sizeModel = new SizeModel();
        ToppingModel toppingModel = new ToppingModel();
        PizzaModel pizzaModel = new PizzaModel();
		CustomerModel customerModel = new CustomerModel();
		OrderModel orderModel = new OrderModel();
    }	

    @Test
    public void Test_CancelOrder_Successful_1() {

        Message message = new Message();
        CancelOrderRequest request = new CancelOrderRequest(2);
        
        OrderResponse order = OrderController.cancelOrder(message, request);
        
        assertTrue("Order Cancel should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the order that was cancelled", order.getOrderId() == 2);
        assertTrue("The Order Status should have changed to 'Cancelled'", order.getOrderStatus().equals("Cancelled"));

        assertTrue("Service should have returned the pizzas for the order", order.getPizzas().size() == 1);

        for (PizzaResponse pizza : order.getPizzas()) {
            assertTrue("The Pizza Status of each order should be 'Cancelled'", pizza.getStatus().equals("Cancelled"));
        }
    }

    @Test
    public void Test_CancelOrder_Successful_2_multiplepizzas() {

        Message message = new Message();
        CancelOrderRequest request = new CancelOrderRequest(3);
        
        OrderResponse order = OrderController.cancelOrder(message, request);
        
        assertTrue("Order Cancel should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the order that was cancelled", order.getOrderId() == 3);
        assertTrue("The Order Status should have changed to 'Cancelled'", order.getOrderStatus().equals("Cancelled"));

        assertTrue("Service should have returned the pizzas for the order", order.getPizzas().size() == 2);

        for (PizzaResponse pizza : order.getPizzas()) {
            assertTrue("The Pizza Status of each order should be 'Cancelled'", pizza.getStatus().equals("Cancelled"));
        }
    }

    @Test
    public void Test_CancelOrder_InvalidOrder() {

        Message message = new Message();
        CancelOrderRequest request = new CancelOrderRequest(1000);
        
        OrderResponse order = OrderController.cancelOrder(message, request);
    
        assertTrue("Cancel Order should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Cancel Order error is incorrect", message.getErrorMessage().contains("OrderId does not exist"));
        assertTrue("Cancel Order should have returned as null", order == null);
    }

    @Test
    public void Test_CancelOrder_InvalidStatus() {

        Message message = new Message();
        CancelOrderRequest request = new CancelOrderRequest(1);
        
        OrderResponse order = OrderController.cancelOrder(message, request);
    
        assertTrue("Cancel Order should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Cancel Order error is incorrect", message.getErrorMessage().contains("This order is already being prepared.  The order cannot be cancelled."));
        assertTrue("Cancel Order should have returned as null", order == null);
    }


}
        