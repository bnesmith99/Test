package restService.Response;

import java.util.ArrayList;

import DomainObject.CrustDomainObject;

public class CrustResponse {
    private final int crustId;
    private final String name;
    private final String description;
    private final int price;

    public CrustResponse(CrustDomainObject domainObject) {
        this.crustId = domainObject.crustId;
        this.name = domainObject.name;
        this.description = domainObject.description;
        this.price = domainObject.price;
    }

    public static ArrayList<CrustResponse> MapList(ArrayList<CrustDomainObject> domainList) {
        ArrayList<CrustResponse> responseList = new ArrayList<CrustResponse>();
        
        for (int i=0; i<domainList.size(); i++) {
            CrustResponse response = new CrustResponse(domainList.get(i));
            responseList.add(response);
        }

        return responseList;
    }

    public int getCrustId() {
        return crustId;
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