package Model;
import java.util.ArrayList;

import DomainObject.PizzaDomainObject;
import restService.Message;


public class PizzaModel {
	
	private static ArrayList<PizzaDomainObject> pizzas;
    private static boolean initialized = false;

	public PizzaModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		pizzas = new ArrayList<PizzaDomainObject>();
	
		//Default Data  
        //Used in Test 2.2
		pizzas.add( new PizzaDomainObject (1, 1, "Complete", 4, 2, 3, 2));
		pizzas.add( new PizzaDomainObject (2, 1, "Complete", 2, 2, 4, 1));
		pizzas.add( new PizzaDomainObject (3, 2, "Not Submitted", 1, 1, 4, 4));
		pizzas.add( new PizzaDomainObject (4, 3, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (5, 3, "Submitted", 1, 1, 1, 1));
		
        //Used in Test 2.3
        pizzas.add( new PizzaDomainObject (5, 4, "Not Submitted", 1, 1, 1, 1));
        pizzas.add( new PizzaDomainObject (5, 5, "Not Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (6, 5, "Not Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (7, 6, "Complete", 1, 1, 1, 1));
        //No Pizza for order 7

        //Used in Test 2.4
		pizzas.add( new PizzaDomainObject (8, 8, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (9, 9, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (10, 9, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (11, 13, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (12, 13, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (13, 14, "Submitted", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (14, 15, "Baking", 1, 1, 1, 1));
		pizzas.add( new PizzaDomainObject (15, 15, "Baking", 1, 1, 1, 1));


        //Not used in any tests yet
        //		pizzas.add( new PizzaDomainObject (8, 1, "Ordered", 1, 1, 1, 1));
	
        initialized = true;
	}


	private static int getNextId() {
		return pizzas.size()+1;
	}

	public static ArrayList<PizzaDomainObject> GetAllPizzas() {
		return pizzas;
	}

	public static PizzaDomainObject GetPizzaById(int pizzaId) {
		
		for (PizzaDomainObject pizza : pizzas) {
			if (pizza.pizzaId == pizzaId)
                return pizza;
		}
		return null;
	}

	public static ArrayList<PizzaDomainObject> GetPizzasForOrderId(int orderId) {
		ArrayList<PizzaDomainObject> pizzasForOrder = new ArrayList<PizzaDomainObject>();
		for (PizzaDomainObject pizza : pizzas) {
			if (pizza.orderId == orderId)
                pizzasForOrder.add(pizza);
		}
		return pizzasForOrder;
	}


   

    public static PizzaDomainObject CreatePizza(Message message, PizzaDomainObject data) {
		//This needs to be implemented.
        return null;
	}


    public static ArrayList<PizzaDomainObject> CancelPizzasByOrderId(Message message, int orderId) {
        //This needs to be implemented
        return null;
    }

}
