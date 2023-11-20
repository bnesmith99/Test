package restService.Response;

import java.util.ArrayList;

import DomainObject.SauceDomainObject;

public class SauceResponse {
    private final int sauceId;
    private final String name;
    private final String description;
    private final int price;

    public SauceResponse(SauceDomainObject domainObject) {
        this.sauceId = domainObject.sauceId;
        this.name = domainObject.name;
        this.description = domainObject.description;
        this.price = domainObject.price;
    }

    public static ArrayList<SauceResponse> MapList(ArrayList<SauceDomainObject> domainList) {
        ArrayList<SauceResponse> responseList = new ArrayList<SauceResponse>();
        
        for (int i=0; i<domainList.size(); i++) {
            SauceResponse response = new SauceResponse(domainList.get(i));
            responseList.add(response);
        }

        return responseList;
    }

    public int getSauceId() {
        return sauceId;
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