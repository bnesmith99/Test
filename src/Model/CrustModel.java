package Model;
import java.util.ArrayList;

import DomainObject.CrustDomainObject;


public class CrustModel {
	
	private static ArrayList<CrustDomainObject> crusts;
    private static boolean initialized = false;

	public CrustModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		crusts = new ArrayList<CrustDomainObject>();
	
		//Default Data  
		crusts.add( new CrustDomainObject (1, "Thin", "", 1000));
		crusts.add( new CrustDomainObject (2, "Hand Tossed", "", 1200));
		crusts.add( new CrustDomainObject (3, "Pan", "", 1400));
		crusts.add( new CrustDomainObject (4, "Chicago Style", "", 1800));

        initialized = true;
	}

	public static ArrayList<CrustDomainObject> GetAllCrusts() {
		return crusts;
	}

	public static CrustDomainObject GetCrustById(int id) {
		
		for (CrustDomainObject crust : crusts) {
			if (crust.crustId == id) {
				return crust;
			}
		}

		return null;
	}
	
}
