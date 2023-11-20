package DomainObject;

import java.util.ArrayList;

import Model.CrustModel;
import Model.SauceModel;
import Model.SizeModel;
import Model.ToppingModel;
import restService.Request.PizzaPriceRequest;

public class PizzaPriceDomainObject {

    //Data Objects
    public int price;
    public int crustId; 
    public int sauceId;
    public int sizeId;
    public int toppingId;


    //Domain Objects
    //private CrustDomainObject crust;
    //private SauceDomainObject sauce; 
    //private SizeDomainObject size;
    //private ToppingDomainObject topping;


    public PizzaPriceDomainObject(PizzaPriceRequest data) {

        this.crustId = data.getCrustId(); 
        this.sauceId = data.getSauceId();
        this.sizeId = data.getSizeId();
        this.toppingId = data.getToppingId();
    }

	public static ArrayList<PizzaPriceDomainObject> MapList(ArrayList<PizzaPriceRequest> request) {
		ArrayList<PizzaPriceDomainObject> pizzas = new ArrayList<PizzaPriceDomainObject>();
		
        for (PizzaPriceRequest pizza : request) {
            pizzas.add(new PizzaPriceDomainObject(pizza));
        }

		return pizzas;
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
