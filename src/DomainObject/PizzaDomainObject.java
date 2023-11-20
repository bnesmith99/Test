package DomainObject;

import Model.CrustModel;
import Model.OrderModel;
import Model.SauceModel;
import Model.SizeModel;
import Model.ToppingModel;
import restService.Request.AddPizzaToOrderRequest;

public class PizzaDomainObject {

    //Data Objects
    public int pizzaId;
    public int orderId;
    public int crustId; 
    public int sauceId;
    public int sizeId;
    public int toppingId;
    public String status;


    //Domain Objects
    //private OrderDomainObject order;
    //private CrustDomainObject crust;
    //private SauceDomainObject sauce; 
    //private SizeDomainObject size;
    //private ToppingDomainObject topping;

    
    public PizzaDomainObject (int pizzaId, int orderId, String status, int crustId, int sauceId, int sizeId, int toppingId) {
        this.pizzaId = pizzaId;
        this.orderId = orderId;
        this.status = status;
        this.crustId = crustId; 
        this.sauceId = sauceId;
        this.sizeId = sizeId;
        this.toppingId = toppingId;
    }

	public PizzaDomainObject(AddPizzaToOrderRequest data) {
        this.pizzaId = -1;
        this.status = "";
        this.orderId = data.getOrderId();
        this.crustId = data.getCrustId(); 
        this.sauceId = data.getSauceId();
        this.sizeId = data.getSizeId();
        this.toppingId = data.getToppingId();
    }

    public OrderDomainObject getOrder() {
        return OrderModel.GetOrderById(orderId);
    }

    public CrustDomainObject getCrust() {
        return CrustModel.GetCrustById(crustId);
    }

    public SauceDomainObject getSauce() {
        return SauceModel.GetSauceById(sauceId);
    }

    public SizeDomainObject getSize() {
        return SizeModel.GetSizeById(sizeId);
    }

    public ToppingDomainObject getTopping() {
        return ToppingModel.GetToppingById(toppingId);
    }
}
