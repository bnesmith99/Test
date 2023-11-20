package restService.Response;

import java.util.ArrayList;

import DomainObject.SizeDomainObject;

public class SizeResponse {
    private final int sizeId;
    private final String name;
    private final String description;
    private final int price;

    public SizeResponse(SizeDomainObject domainObject) {
        this.sizeId = domainObject.sizeId;
        this.name = domainObject.name;
        this.description = domainObject.description;
        this.price = domainObject.price;
    }

    public static ArrayList<SizeResponse> MapList(ArrayList<SizeDomainObject> domainList) {
        ArrayList<SizeResponse> responseList = new ArrayList<SizeResponse>();
        
        for (int i=0; i<domainList.size(); i++) {
            SizeResponse response = new SizeResponse(domainList.get(i));
            responseList.add(response);
        }

        return responseList;
    }

    public int getSizeId() {
        return sizeId;
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