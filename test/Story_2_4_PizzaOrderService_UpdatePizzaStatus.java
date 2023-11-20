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
import restService.Request.UpdatePizzaStatusRequest;
import restService.Response.OrderResponse;
import restService.Response.PizzaResponse;

public class Story_2_4_PizzaOrderService_UpdatePizzaStatus {
  
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
    public void Test_UpdatePizzaStatus_Successful_1pizza() {

        int orderId = 8;
        int pizzaId = 8;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Preparing");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
        

        assertTrue("Update Pizza Status should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order.getOrderId() == orderId);
        assertTrue("The Order Status should have changed to 'Preparing'", order.getOrderStatus().equals("Preparing"));

        assertTrue("Service should have returned the pizza for the order", order.getPizzas().size() == 1);

        for (PizzaResponse pizza : order.getPizzas()) {
            if (pizza.getPizzaId() == pizzaId)
                assertTrue("The Pizza Status of the pizza should be 'Preparing'", pizza.getStatus().equals("Preparing"));
        }
    }

    @Test
    public void Test_UpdatePizzaStatus_Successful_2pizza() {

        int orderId = 9;
        int pizzaId = 9;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Preparing");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
        

        assertTrue("Update Pizza Status should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order.getOrderId() == orderId);
        assertTrue("The Order Status should have changed to 'Preparing'", order.getOrderStatus().equals("Preparing"));

        assertTrue("Service should have returned the pizza for the order", order.getPizzas().size() == 2);

        for (PizzaResponse pizza : order.getPizzas()) {
            if (pizza.getPizzaId() == pizzaId)
                assertTrue("The Pizza Status of the pizza should be 'Preparing'", pizza.getStatus().equals("Preparing"));
        }
    }

    
    @Test
    public void Test_UpdatePizzaStatus_Successful_2pizza_Baking() {

        int orderId = 13;
        int pizzaId = 12;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Baking");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
        

        assertTrue("Update Pizza Status should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order.getOrderId() == orderId);
        assertTrue("The Order Status should have changed to 'Preparing'", order.getOrderStatus().equals("Preparing"));

        assertTrue("Service should have returned the pizza for the order", order.getPizzas().size() == 2);

        for (PizzaResponse pizza : order.getPizzas()) {
            if (pizza.getPizzaId() == pizzaId)
                assertTrue("The Pizza Status of the pizza should be 'Preparing'", pizza.getStatus().equals("Baking"));
        }
    }

    
    @Test
    public void Test_UpdatePizzaStatus_Successful_1pizza_Boxed() {

        int orderId = 14;
        int pizzaId = 13;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Boxed");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
        

        assertTrue("Update Pizza Status should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order.getOrderId() == orderId);
        assertTrue("The Order Status should have changed to 'Boxed'", order.getOrderStatus().equals("Ready For Pickup"));

        assertTrue("Service should have returned the pizza for the order", order.getPizzas().size() == 1);

        for (PizzaResponse pizza : order.getPizzas()) {
            if (pizza.getPizzaId() == pizzaId)
                assertTrue("The Pizza Status of the pizza should be 'Preparing'", pizza.getStatus().equals("Boxed"));
        }
    }


    @Test
    public void Test_UpdatePizzaStatus_Successful_2pizza_Boxed() {

        int orderId = 15;
        int p1pizzaId = 14;
        int p2pizzaId = 15;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, p1pizzaId, "Boxed");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
        

        assertTrue("Update Pizza Status should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("The Order Status should have changed to 'Preparing'", order.getOrderStatus().equals("Preparing"));
        assertTrue("Service should have returned the pizza for the order", order.getPizzas().size() == 2);

        for (PizzaResponse pizza : order.getPizzas()) {
            if (pizza.getPizzaId() == p1pizzaId)
                assertTrue("The Pizza Status of the pizza should be 'Preparing'", pizza.getStatus().equals("Boxed"));
        }


        UpdatePizzaStatusRequest request2 = new UpdatePizzaStatusRequest(orderId, p2pizzaId, "Boxed");
        
        OrderResponse order2 = OrderController.UpdatePizzaStatus(message, request2);
        

        assertTrue("Update Pizza Status should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("The Order Status should have changed to 'Preparing'", order2.getOrderStatus().equals("Ready For Pickup"));
        assertTrue("Service should have returned the pizza for the order", order2.getPizzas().size() == 2);

        for (PizzaResponse pizza : order2.getPizzas()) {
            if (pizza.getPizzaId() == p2pizzaId)
                assertTrue("The Pizza Status of the pizza should be 'Preparing'", pizza.getStatus().equals("Boxed"));
        }


    }


    @Test
    public void Test_UpdatePizzaStatus_InvalidOrderId() {

        int orderId = 1000;
        int pizzaId = 1000;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Preparing");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
    
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("OrderId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
       

    }

    @Test
    public void Test_UpdatePizzaStatus_InvalidPizzaForOrderId() {

        int orderId = 9;
        int pizzaId = 1000;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Preparing");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
    
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("PizzaId is not valid for the order"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
    }


    @Test
    public void Test_UpdatePizzaStatus_InvalidPizzaStatus() {

        int orderId = 9;
        int pizzaId = 9;

        Message message = new Message();
        UpdatePizzaStatusRequest request = new UpdatePizzaStatusRequest(orderId, pizzaId, "Freezing");
        
        OrderResponse order = OrderController.UpdatePizzaStatus(message, request);
    
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("Status is not a valid status"));
        assertTrue("Update Pizza Status should have returned as null", order == null);

    }
}
        