package Model;
import java.util.ArrayList;

import DomainObject.SauceDomainObject;

public class SauceModel {
	
	private static ArrayList<SauceDomainObject> sauces;
    private static boolean initialized = false;

	public SauceModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		sauces = new ArrayList<SauceDomainObject>();
	
		//Default Data  
		sauces.add( new SauceDomainObject (1, "Spicy", "", 100));
		sauces.add( new SauceDomainObject (2, "Sweet Marzano", "", 125));
		sauces.add( new SauceDomainObject (3, "Alfredo", "", 175));

        initialized = true;
	}

	public static ArrayList<SauceDomainObject> GetAllSauces() {
		return sauces;
	}

	public static SauceDomainObject GetSauceById(int sauceId) {
		
		for (SauceDomainObject sauce : sauces) {
			if (sauce.sauceId == sauceId) {
				return sauce;
			}
		}

		return null;
	}
	
}
