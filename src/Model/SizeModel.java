package Model;
import java.util.ArrayList;

import DomainObject.SizeDomainObject;


public class SizeModel {
	
	private static ArrayList<SizeDomainObject> sizes;
    private static boolean initialized = false;

	public SizeModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		sizes = new ArrayList<SizeDomainObject>();
	
		//Default Data  
		sizes.add( new SizeDomainObject (1, "Small", "", 100));
		sizes.add( new SizeDomainObject (2, "Medium", "", 250));
		sizes.add( new SizeDomainObject (3, "Large", "", 400));
		sizes.add( new SizeDomainObject (4, "Extra Large", "", 500));

        initialized = true;
	}

	public static ArrayList<SizeDomainObject> GetAllSizes() {
		return sizes;
	}

	public static SizeDomainObject GetSizeById(int sizeId) {
		
		for (SizeDomainObject size : sizes) {
			if (size.sizeId == sizeId) {
				return size;
			}
		}

		return null;
	}
	
}
