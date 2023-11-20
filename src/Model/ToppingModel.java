package Model;
import java.util.ArrayList;

import DomainObject.ToppingDomainObject;

public class ToppingModel {
	
	private static ArrayList<ToppingDomainObject> toppings;
    private static boolean initialized = false;

	public ToppingModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		toppings = new ArrayList<ToppingDomainObject>();
	
		//Default Data  
		toppings.add( new ToppingDomainObject (1, "Extra Cheese", "", 75));
		toppings.add( new ToppingDomainObject (2, "Onion", "", 100));
		toppings.add( new ToppingDomainObject (3, "Tomato", "", 100));
		toppings.add( new ToppingDomainObject (4, "Mushroom", "", 100));

        initialized = true;
	}

	public static ArrayList<ToppingDomainObject> GetAllToppings() {
		return toppings;
	}

	public static ToppingDomainObject GetToppingById(int toppingId) {
		
		for (ToppingDomainObject topping : toppings) {
			if (topping.toppingId == toppingId) {
				return topping;
			}
		}
		return null;
	}	
}
