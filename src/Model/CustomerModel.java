package Model;
import java.util.ArrayList;

import DomainObject.CustomerDomainObject;

public class CustomerModel {
	
	private static ArrayList<CustomerDomainObject> customers;
    private static boolean initialized = false;

	public CustomerModel() {
		if (!initialized)
            initialize();
	}

	private void initialize() {
		customers = new ArrayList<CustomerDomainObject>();
	
		//Default Data  
		customers.add( new CustomerDomainObject (1, "Ryan Florin", "rflorin@email.com"));
		customers.add( new CustomerDomainObject (2, "Kenneth Findley", "kfindley@email.com"));		
		customers.add( new CustomerDomainObject (3, "Amy Zion", "azion@email.com"));		
		customers.add( new CustomerDomainObject (4, "Chris Gammill", "cgammill@email.com"));		
		customers.add( new CustomerDomainObject (5, "Lauren Dodd", "ldodd@email.com"));	
        customers.add( new CustomerDomainObject (6, "Story 2.1", "newcustomer2.1@email.com"));	
        customers.add( new CustomerDomainObject (7, "Story 2.1", "newcustomer2.1@email.com"));	
        customers.add( new CustomerDomainObject (8, "Story 2.1", "newcustomer2.1@email.com"));	
        customers.add( new CustomerDomainObject (9, "Story 2.1", "newcustomer2.1@email.com"));	
        customers.add( new CustomerDomainObject (10, "Story 2.4", "newcustomer2.4@email.com"));	
        customers.add( new CustomerDomainObject (11, "Story 2.5", "newcustomer2.5@email.com"));	
        customers.add( new CustomerDomainObject (12, "Story 2.5", "newcustomer2.5@email.com"));	
        customers.add( new CustomerDomainObject (13, "Story 2.5", "newcustomer2.5@email.com"));	
        	

        initialized = true;
	}

	public static ArrayList<CustomerDomainObject> GetAllCustomers() {
		return customers;
	}

	public static CustomerDomainObject GetCustomerById(int customerId) {
		
		for (CustomerDomainObject customer : customers) {
			if (customer.customerId == customerId) {
				return customer;
			}
		}
		
		return null;
	}

}
