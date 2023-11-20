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
import restService.Request.AddPizzaToOrderRequest;
import restService.Response.OrderResponse;
import restService.Response.PizzaResponse;

public class Story_2_5_PizzaOrderService_AddPizzaToOrder {
  
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
    public void Test_AddPizzaToOrder_Successful_1pizza() {

        int orderId = 10;
        int crustId = 1;
        int sauceId = 2;
        int sizeId = 3;
        int toppingId = 4;

        Message message = new Message();
        AddPizzaToOrderRequest request = new AddPizzaToOrderRequest(orderId, crustId, sauceId, sizeId, toppingId);
        
        OrderResponse order = OrderController.AddPizzaToOrder(message, request);
        

        assertTrue("Add Pizza to Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order.getOrderId() == orderId);

        assertTrue("Service should have returned the pizza for the order", order.getPizzas().size() == 1);

        assertTrue("Service did not return proper crust", order.getPizzas().get(0).getCrustId() == crustId);
        assertTrue("Service did not return proper sauce", order.getPizzas().get(0).getSauceId() == sauceId);
        assertTrue("Service did not return proper size", order.getPizzas().get(0).getSizeId() == sizeId);
        assertTrue("Service did not return proper topping", order.getPizzas().get(0).getToppingId() == toppingId);


      
    }

    @Test
    public void Test_AddPizzaToOrder_Successful_2pizza() {

       int orderId = 11;
        int p1crustId = 1;
        int p1sauceId = 2;
        int p1sizeId = 3;
        int p1toppingId = 4;

        int p2crustId = 4;
        int p2sauceId = 3;
        int p2sizeId = 2;
        int p2toppingId = 1;



        Message message = new Message();
        AddPizzaToOrderRequest request1 = new AddPizzaToOrderRequest(orderId, p1crustId, p1sauceId, p1sizeId, p1toppingId);
        
        OrderResponse order1 = OrderController.AddPizzaToOrder(message, request1);
        
        assertTrue("Add Pizza to Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order1.getOrderId() == orderId);

        assertTrue("Service should have returned the pizza for the order", order1.getPizzas().size() == 1);

        assertTrue("Service did not return proper crust", order1.getPizzas().get(0).getCrustId() == p1crustId);
        assertTrue("Service did not return proper sauce", order1.getPizzas().get(0).getSauceId() == p1sauceId);
        assertTrue("Service did not return proper size", order1.getPizzas().get(0).getSizeId() == p1sizeId);
        assertTrue("Service did not return proper topping", order1.getPizzas().get(0).getToppingId() == p1toppingId);
        assertTrue("Service did not return proper status", order1.getPizzas().get(0).getStatus().equals("Not Submitted"));
        int pizza1Id = order1.getPizzas().get(0).getPizzaId();

        AddPizzaToOrderRequest request2 = new AddPizzaToOrderRequest(orderId, p2crustId, p2sauceId, p2sizeId, p2toppingId);
        
        OrderResponse order2 = OrderController.AddPizzaToOrder(message, request2);
        
        assertTrue("Add Pizza to Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper order", order2.getOrderId() == orderId);

        assertTrue("Service should have returned the pizza for the order", order2.getPizzas().size() == 2);

        boolean pizza1Included = false;
        for (PizzaResponse pizza : order2.getPizzas()) {
            if (pizza.getPizzaId() == pizza1Id) {
                pizza1Included = true;
            } else {
                assertTrue("Service did not return proper crust", pizza.getCrustId() == p2crustId);
                assertTrue("Service did not return proper sauce", pizza.getSauceId() == p2sauceId);
                assertTrue("Service did not return proper size", pizza.getSizeId() == p2sizeId);
                assertTrue("Service did not return proper toppiong", pizza.getToppingId() == p2toppingId);
                assertTrue("Service did not return proper Status", pizza.getStatus().equals("Not Submitted"));

            }
        }

        assertTrue("Original Order is not inlcuded in the service", pizza1Included);


    }

    @Test
    public void Test_AddPizzaToOrder_InvalidOrderId() {

        int orderId = 1000;
        int crustId = 2;
        int sauceId = 2;
        int sizeId = 2;
        int toppingId = 2;

        Message message = new Message();
        AddPizzaToOrderRequest request = new AddPizzaToOrderRequest(orderId, crustId, sauceId, sizeId, toppingId);
        
        OrderResponse order = OrderController.AddPizzaToOrder(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("OrderId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
       
    }

    
    @Test
    public void Test_AddPizzaToOrder_InvalidCrustId() {

        int orderId = 12;
        int crustId = 1000;
        int sauceId = 2;
        int sizeId = 2;
        int toppingId = 2;

        Message message = new Message();
        AddPizzaToOrderRequest request = new AddPizzaToOrderRequest(orderId, crustId, sauceId, sizeId, toppingId);
        
        OrderResponse order = OrderController.AddPizzaToOrder(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("CrustId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
       
    }

    @Test
    public void Test_AddPizzaToOrder_InvalidSauceId() {

        int orderId = 12;
        int crustId = 2;
        int sauceId = 1000;
        int sizeId = 2;
        int toppingId = 2;

        Message message = new Message();
        AddPizzaToOrderRequest request = new AddPizzaToOrderRequest(orderId, crustId, sauceId, sizeId, toppingId);
        
        OrderResponse order = OrderController.AddPizzaToOrder(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("SauceId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
       
    }

    @Test
    public void Test_AddPizzaToOrder_InvalidSizeId() {

        int orderId = 12;
        int crustId = 2;
        int sauceId = 2;
        int sizeId = 1000;
        int toppingId = 2;

        Message message = new Message();
        AddPizzaToOrderRequest request = new AddPizzaToOrderRequest(orderId, crustId, sauceId, sizeId, toppingId);
        
        OrderResponse order = OrderController.AddPizzaToOrder(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("SizeId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
       
    }

    @Test
    public void Test_AddPizzaToOrder_InvalidToppingId() {

        int orderId = 12;
        int crustId = 2;
        int sauceId = 2;
        int sizeId = 2;
        int toppingId = 1000;

        Message message = new Message();
        AddPizzaToOrderRequest request = new AddPizzaToOrderRequest(orderId, crustId, sauceId, sizeId, toppingId);
        
        OrderResponse order = OrderController.AddPizzaToOrder(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("ToppingId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", order == null);
       
    }


    @Test
    public void Test_AddPizzaToOrder_SequentialOrder() {

        int orderId = 12;
        int p1crustId = 1;
        int p1sauceId = 2;
        int p1sizeId = 3;
        int p1toppingId = 4;

        int p2crustId = 4;
        int p2sauceId = 3;
        int p2sizeId = 2;
        int p2toppingId = 1;


        Message message = new Message();
        AddPizzaToOrderRequest request1 = new AddPizzaToOrderRequest(orderId, p1crustId, p1sauceId, p1sizeId, p1toppingId);
        OrderResponse order1 = OrderController.AddPizzaToOrder(message, request1);
        int pizza1Id = order1.getPizzas().get(0).getPizzaId();

        AddPizzaToOrderRequest request2 = new AddPizzaToOrderRequest(orderId, p2crustId, p2sauceId, p2sizeId, p2toppingId);
        OrderResponse order2 = OrderController.AddPizzaToOrder(message, request2);
        
        boolean pizza1Included = false;
        for (PizzaResponse pizza : order2.getPizzas()) {
            if (pizza.getPizzaId() == pizza1Id) {
                pizza1Included = true;
            } else {
                assertTrue("PizzaId should be sequential", pizza.getPizzaId() == pizza1Id + 1);
            }
        }
    }


}
        