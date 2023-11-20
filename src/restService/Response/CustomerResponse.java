package restService.Response;


import java.util.ArrayList;

import DomainObject.CustomerDomainObject;

public class CustomerResponse {

	private final int customerId;
	private final String name;
	private final String email;

	public CustomerResponse(int customerId, String name, String email) {
		this.customerId = customerId;
		this.name = name;
        this.email = email;
	}

	public CustomerResponse(CustomerDomainObject domainObject) {
		this.customerId = domainObject.customerId;
        this.name = domainObject.name;
        this.email = domainObject.email;
    }

	public static ArrayList<CustomerResponse> MapList(ArrayList<CustomerDomainObject> domainList) {
		ArrayList<CustomerResponse> responseList = new ArrayList<CustomerResponse>();
		
		for (int i=0; i<domainList.size(); i++) {
			CustomerResponse response = new CustomerResponse(domainList.get(i));
			responseList.add(response);
		}

		return responseList;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

}
