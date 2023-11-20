package restService.Response;


import java.util.ArrayList;


import DomainObject.MenuDomainObject;


public class MenuResponse {

	private final ArrayList<CrustResponse> crusts;
	private final ArrayList<SauceResponse> sauces;
	private final ArrayList<SizeResponse> sizes;
	private final ArrayList<ToppingResponse> toppings;


	public MenuResponse(MenuDomainObject domainObject) {
		crusts = CrustResponse.MapList(domainObject.getCrusts());
		sauces = SauceResponse.MapList(domainObject.getSauces());
		sizes = SizeResponse.MapList(domainObject.getSizes());
		toppings = ToppingResponse.MapList(domainObject.getToppings());
    }

	public ArrayList<CrustResponse> getCrusts() {
		return crusts;
	}

	public ArrayList<SauceResponse> getSauces() {
		return sauces;
	}
    
    public ArrayList<SizeResponse> getSizes() {
		return sizes;
	}

    public ArrayList<ToppingResponse> getToppings() {
		return toppings;
	}





}
