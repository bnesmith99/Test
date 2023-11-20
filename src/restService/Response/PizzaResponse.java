package restService.Response;

import java.util.ArrayList;
import DomainObject.OrderDomainObject;
import DomainObject.PizzaDomainObject;


public class PizzaResponse {

    private final int pizzaId;
    private final String status;

	private final int orderId;
    private final int crustId;
    private final int sauceId;
    private final int sizeId;
    private final int toppingId;

    private final String crust;
    private final String sauce;
    private final String size;
    private final String topping;



	public PizzaResponse(int pizzaId, int orderId, String status, int crustId, int sauceId, int sizeId, int toppingId, String crust, String sauce, String size, String topping) {
		this.pizzaId = pizzaId;
		this.orderId = orderId;
        this.status = status;
        this.crustId = crustId;
        this.sauceId = sauceId;
        this.sizeId = sizeId;
        this.toppingId = toppingId;
        this.crust = crust;
        this.sauce = sauce;
        this.size = size;
        this.topping = topping;
	}

	public PizzaResponse(PizzaDomainObject domainObject) {
		this.pizzaId = domainObject.pizzaId;
        this.orderId = domainObject.orderId;
        this.status = domainObject.status;
        this.crustId = domainObject.crustId;
        this.crust = domainObject.getCrust().name;
        this.sauceId = domainObject.sauceId;
        this.sauce = domainObject.getSauce().name;
        this.sizeId = domainObject.sizeId;
        this.size = domainObject.getSize().name;

        this.toppingId = domainObject.toppingId;
        this.topping = domainObject.getTopping().name;

/*        if (domainObject.Customer != null)
            this.customerName = domainObject.Customer.name;
        else
            this.customerName = "";
*/
	}

	public static ArrayList<PizzaResponse> MapList(ArrayList<PizzaDomainObject> domainList) {
		ArrayList<PizzaResponse> responseList = new ArrayList<PizzaResponse>();
		
		for (int i=0; i<domainList.size(); i++) {
			PizzaResponse response = new PizzaResponse(domainList.get(i));
			responseList.add(response);
		}

		return responseList;
	}

	public int getPizzaId() {
		return pizzaId;
	}

    public int getOrderId() {
		return orderId;
	}

	public String getStatus() {
		return status;
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
