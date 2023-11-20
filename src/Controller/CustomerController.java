package Controller;

import java.util.ArrayList;

import DomainObject.CustomerDomainObject;
import Model.CustomerModel;
import restService.Message;
import restService.Response.CustomerResponse;

public class CustomerController {
	//The CustomerController will convert the request from the REST Request and the Domain Model.
	//Then it will call the Model or Service, and convert the response from the Domain model
	//to the REST Response.
	
	public static ArrayList<CustomerResponse> getAllCustomers(Message message) {
		try{
			ArrayList<CustomerDomainObject> domain = CustomerModel.GetAllCustomers();

            if (domain == null)
            return null;

			ArrayList<CustomerResponse> response = CustomerResponse.MapList(domain);
			return response;				
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}  
}
