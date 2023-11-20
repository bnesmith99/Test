package restService.Response;

import java.util.ArrayList;

import DomainObject.ToppingDomainObject;

public class ToppingResponse {
    private final int toppingId;
    private final String name;
    private final String description;
    private final int price;

    public ToppingResponse(ToppingDomainObject domainObject) {
        this.toppingId = domainObject.toppingId;
        this.name = domainObject.name;
        this.description = domainObject.description;
        this.price = domainObject.price;
    }

    public static ArrayList<ToppingResponse> MapList(ArrayList<ToppingDomainObject> domainList) {
        ArrayList<ToppingResponse> responseList = new ArrayList<ToppingResponse>();
        
        for (int i=0; i<domainList.size(); i++) {
            ToppingResponse response = new ToppingResponse(domainList.get(i));
            responseList.add(response);
        }

        return responseList;
    }

    public int getToppingId() {
        return toppingId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

}