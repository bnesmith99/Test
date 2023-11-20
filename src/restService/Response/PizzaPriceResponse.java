package restService.Response;

import java.util.ArrayList;
import DomainObject.PizzaPriceDomainObject;


public class PizzaPriceResponse {


    private final int price;
    private final int crustId;
    private final int sauceId;
    private final int sizeId;
    private final int toppingId;

    private final String crust;
    private final String sauce;
    private final String size;
    private final String topping;



	public PizzaPriceResponse(int price, int crustId, int sauceId, int sizeId, int toppingId, String crust, String sauce, String size, String topping) {
        this.price = price;
        this.crustId = crustId;
        this.sauceId = sauceId;
        this.sizeId = sizeId;
        this.toppingId = toppingId;
        this.crust = crust;
        this.sauce = sauce;
        this.size = size;
        this.topping = topping;
	}


    public PizzaPriceResponse(PizzaPriceDomainObject domainObject) {
        this.price = domainObject.price;
        this.crustId = domainObject.crustId;
        this.crust = domainObject.getCrust().name;
        this.sauceId = domainObject.sauceId;
        this.sauce = domainObject.getSauce().name;
        this.sizeId = domainObject.sizeId;
        this.size = domainObject.getSize().name;
        this.toppingId = domainObject.toppingId;
        this.topping = domainObject.getTopping().name;
}
      
	


    public static ArrayList<PizzaPriceResponse> MapList(ArrayList<PizzaPriceDomainObject> domainList) {
		ArrayList<PizzaPriceResponse> responseList = new ArrayList<PizzaPriceResponse>();
		
		for (PizzaPriceDomainObject pizza : domainList) {
			PizzaPriceResponse response = new PizzaPriceResponse(pizza);
			responseList.add(response);
		}

		return responseList;
	}

	public int gerPrice() {
		return price;
	}

	public int getCrustId() {
		return crustId;
	}

	public int getSauceId() {
		return sauceId;
	}

   	public int getSizeId() {
		return sizeId;
	}

   	public int getToppingId() {
		return toppingId;
	}

    public String getCrust() {
		return crust;
	}

    public String getSauce() {
		return sauce;
	}

    public String getSize() {
		return size;
	}

    public String getTopping() {
		return topping;
	}
}
