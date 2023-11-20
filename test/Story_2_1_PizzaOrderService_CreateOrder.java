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
import restService.Request.CreateOrderRequest;
import restService.Response.OrderResponse;

public class Story_2_1_PizzaOrderService_CreateOrder {
  
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
    public void Test_CreateOrder_Successful() {

        Message message = new Message();
        CreateOrderRequest request = new CreateOrderRequest(6);
        
        OrderResponse order = OrderController.createOrder(message, request);
        
        assertTrue("Order Creation should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("OrderStatus should be 'Not Submitted'", order.getOrderStatus().equals("Not Submitted"));
        assertTrue("Order should not have any pizzas defined", order.getPizzas().size() == 0);
        
    }

    @Test
    public void Test_CreateOrder_SequentialOrderId() {

        Message message = new Message();
        CreateOrderRequest request1 = new CreateOrderRequest(7);
        OrderResponse order1 = OrderController.createOrder(message, request1);

        assertTrue("Order Creation should not return any errors", message.getErrorMessage().size() == 0);


        CreateOrderRequest request2 = new CreateOrderRequest(8);
        OrderResponse order2 = OrderController.createOrder(message, request2);

        assertTrue("Order Creation should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("OrderId should be sequential", order1.getOrderId() == (order2.getOrderId() - 1));
        
    }

    @Test
    public void Test_CreateOrder_InvalidCustomer() {

        Message message = new Message();
        CreateOrderRequest request = new CreateOrderRequest(1000);
    
        OrderResponse order = OrderController.createOrder(message, request);
    
        assertTrue("Order Creation should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Order Creation error is incorrect", message.getErrorMessage().contains("CustomerId does not exist"));
        assertTrue("Order should have returned as null", order == null);
       
    }

    @Test
    public void Test_CreateOrder_CustomerWithNotSubmittedOrder() {

        Message message = new Message();
        CreateOrderRequest request1 = new CreateOrderRequest(9);
        OrderResponse order1 = OrderController.createOrder(message, request1);

        assertTrue("Order Creation should not return any errors", message.getErrorMessage().size() == 0);


        CreateOrderRequest request2 = new CreateOrderRequest(9);
        OrderResponse order2 = OrderController.createOrder(message, request2);

        assertTrue("Order Creation should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Order Creation error is incorrect", message.getErrorMessage().contains("Please submit your existing order before starting a new order."));
        assertTrue("Order should have returned as null", order2 == null);
       

    }


}
        