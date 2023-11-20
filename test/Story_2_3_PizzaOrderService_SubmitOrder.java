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
import restService.Request.SubmitOrderRequest;
import restService.Response.OrderResponse;
import restService.Response.PizzaResponse;

public class Story_2_3_PizzaOrderService_SubmitOrder {
  
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
    public void Test_SubmitOrder_Successful_onepizza() {

        Message message = new Message();
        SubmitOrderRequest request = new SubmitOrderRequest(4);
        
        OrderResponse order = OrderController.submitOrder(message, request);
        
        assertTrue("Submit Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("OrderStatus should be 'Submitted'", order.getOrderStatus().equals("Submitted"));
     
        for (PizzaResponse pizza : order.getPizzas()) {
            assertTrue("The Pizza Status of each order should be 'Submitted'", pizza.getStatus().equals("Submitted"));
        }

    }

    @Test
    public void Test_SubmitOrder_Successful_twopizza() {

        Message message = new Message();
        SubmitOrderRequest request = new SubmitOrderRequest(5);
        
        OrderResponse order = OrderController.submitOrder(message, request);
        
        assertTrue("Submit Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("OrderStatus should be 'Submitted'", order.getOrderStatus().equals("Submitted"));
     
        for (PizzaResponse pizza : order.getPizzas()) {
            assertTrue("The Pizza Status of each order should be 'Submitted'", pizza.getStatus().equals("Submitted"));
        }
        
    }

    @Test
    public void Test_SubmitOrder_NoPizza() {

        Message message = new Message();
        SubmitOrderRequest request = new SubmitOrderRequest(7);
    
        OrderResponse order = OrderController.submitOrder(message, request);
    
        assertTrue("Submit Order should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Submit Order error is incorrect", message.getErrorMessage().contains("Order must have at least one pizza."));
        assertTrue("Order should have returned as null", order == null);
    }


    @Test
    public void Test_SubmitOrder_InvalidStatus() {

        Message message = new Message();
        SubmitOrderRequest request = new SubmitOrderRequest(6);
    
        OrderResponse order = OrderController.submitOrder(message, request);
    
        assertTrue("Submit Order should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Submit Order error is incorrect", message.getErrorMessage().contains("This order is already being prepared.  The order cannot be submitted."));
        assertTrue("Order should have returned as null", order == null);
    }

    @Test
    public void Test_SubmitOrder_InvalidOrderId() {

        Message message = new Message();
        SubmitOrderRequest request = new SubmitOrderRequest(1000);
    
        OrderResponse order = OrderController.submitOrder(message, request);
    
        assertTrue("Submit Order should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Submit Order error is incorrect", message.getErrorMessage().contains("OrderId does not exist"));
        assertTrue("Submit Order should have returned as null", order == null);
       

    }

}
        