package DomainObject;

import restService.Request.RegisterCustomerRequest;

public class CustomerDomainObject {

    //Data Objects
	public int customerId;
	public String name;
	public String email;


    //Domain Objects
    //None

    
    public CustomerDomainObject(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }


	public CustomerDomainObject(RegisterCustomerRequest request) {
		this.name = request.getName();
		this.email = request.getEmail();
	}

}
