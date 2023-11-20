import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.MenuController;
import Model.CrustModel;
import Model.CustomerModel;
import Model.OrderModel;
import Model.PizzaModel;
import Model.SauceModel;
import Model.SizeModel;
import Model.ToppingModel;

import restService.Message;
import restService.Request.OrderPriceRequest;
import restService.Request.PizzaPriceRequest;
import restService.Response.OrderPriceResponse;

public class Story_3_2_GetPriceForPizza {
  
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
    public void Test_GetPriceForPizza_Successful_1pizza() {

        int crustId = 1; //Thin - 1000
        int sauceId = 2; //Sweet Marzano 125
        int sizeId = 3; //Large - 400
        int toppingId = 4; //Mushroom - 100

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        pizzasRequest.add(new PizzaPriceRequest(crustId, sauceId, sizeId, toppingId));
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Add Pizza to Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper TotalPrice", orderPrice.getTotalPrice() == 1625);

        assertTrue("Service should have returned the pizza for the order", orderPrice.getPizzas().size() == 1);

        assertTrue("Service did not return proper crust", orderPrice.getPizzas().get(0).getCrustId() == crustId);
        assertTrue("Service did not return proper sauce", orderPrice.getPizzas().get(0).getSauceId() == sauceId);
        assertTrue("Service did not return proper size", orderPrice.getPizzas().get(0).getSizeId() == sizeId);
        assertTrue("Service did not return proper topping", orderPrice.getPizzas().get(0).getToppingId() == toppingId);

      
    }

   @Test
    public void Test_GetPriceForPizza_Successful_2pizza() {

        int p1crustId = 2; //Hand Tossed - 1200
        int p1sauceId = 1; //Spicy - 100
        int p1sizeId = 2; //Medium - 250
        int p1toppingId = 1; //Extra Cheese - 75
        //  1625

        int p2crustId = 4; //Chicago Style - 1800
        int p2sauceId = 3; //Alfredo - 175
        int p2sizeId = 4; //Extra Large- 500
        int p2toppingId = 2; //Onion - 100
        //  2575
        // Total Price: 4200

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        pizzasRequest.add(new PizzaPriceRequest(p1crustId, p1sauceId, p1sizeId, p1toppingId));
        pizzasRequest.add(new PizzaPriceRequest(p2crustId, p2sauceId, p2sizeId, p2toppingId));
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Add Pizza to Order should not return any errors", message.getErrorMessage().size() == 0);
        assertTrue("Service should return the proper TotalPrice", orderPrice.getTotalPrice() == 4200);

        assertTrue("Service should have returned the pizza for the order", orderPrice.getPizzas().size() == 2);

        assertTrue("Service did not return proper crust", orderPrice.getPizzas().get(0).getCrustId() == p1crustId);
        assertTrue("Service did not return proper sauce", orderPrice.getPizzas().get(0).getSauceId() == p1sauceId);
        assertTrue("Service did not return proper size", orderPrice.getPizzas().get(0).getSizeId() == p1sizeId);
        assertTrue("Service did not return proper topping", orderPrice.getPizzas().get(0).getToppingId() == p1toppingId);

        assertTrue("Service did not return proper crust", orderPrice.getPizzas().get(1).getCrustId() == p2crustId);
        assertTrue("Service did not return proper sauce", orderPrice.getPizzas().get(1).getSauceId() == p2sauceId);
        assertTrue("Service did not return proper size", orderPrice.getPizzas().get(1).getSizeId() == p2sizeId);
        assertTrue("Service did not return proper topping", orderPrice.getPizzas().get(1).getToppingId() == p2toppingId);
      
    }


    @Test
    public void Test_GetPriceForPizza_InvalidCrustId() {

        int crustId = 1000; 
        int sauceId = 2; 
        int sizeId = 3; 
        int toppingId = 4; 

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        pizzasRequest.add(new PizzaPriceRequest(crustId, sauceId, sizeId, toppingId));
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("CrustId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", orderPrice == null);
    }


    @Test
    public void Test_GetPriceForPizza_InvalidSauceId() {

        int crustId = 1; 
        int sauceId = 1000;
        int sizeId = 3; 
        int toppingId = 4; 

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        pizzasRequest.add(new PizzaPriceRequest(crustId, sauceId, sizeId, toppingId));
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("SauceId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", orderPrice == null);      
    }
 

    @Test
    public void Test_GetPriceForPizza_InvalidSizeId() {

        int crustId = 1; 
        int sauceId = 2;
        int sizeId = 1000; 
        int toppingId = 4; 

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        pizzasRequest.add(new PizzaPriceRequest(crustId, sauceId, sizeId, toppingId));
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("SizeId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", orderPrice == null);      
    }

    
    @Test
    public void Test_GetPriceForPizza_InvalidToppingId() {

        int crustId = 1; 
        int sauceId = 2;
        int sizeId = 3; 
        int toppingId = 1000; 

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        pizzasRequest.add(new PizzaPriceRequest(crustId, sauceId, sizeId, toppingId));
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("ToppingId does not exist"));
        assertTrue("Update Pizza Status should have returned as null", orderPrice == null);      
    }


        @Test
    public void Test_GetPriceForPizza_EmptyPizza() {

        Message message = new Message();

        ArrayList<PizzaPriceRequest> pizzasRequest = new ArrayList<PizzaPriceRequest>();
        OrderPriceRequest request = new OrderPriceRequest(pizzasRequest);

        OrderPriceResponse orderPrice = MenuController.OrderPrice(message, request);
        
        assertTrue("Update Pizza Status should have returned an error", message.getErrorMessage().size() > 0);
        assertTrue("Update Pizza Status error is incorrect", message.getErrorMessage().contains("There must be at least one pizza"));
        assertTrue("Update Pizza Status should have returned as null", orderPrice == null);      
    }



}
        