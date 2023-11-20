package Controller;

import DomainObject.MenuDomainObject;
import DomainObject.OrderPriceDomainObject;
import Model.OrderModel;
import restService.Message;
import restService.Request.OrderPriceRequest;
import restService.Response.MenuResponse;
import restService.Response.OrderPriceResponse;

public class MenuController {
	//The MenuController will convert the request from the REST Request and the Domain Model.
	//Then it will call the Model or Service, and convert the response from the Domain model
	//to the REST Response.

	public static MenuResponse getMenu(Message message) {
		try {
            MenuDomainObject domain = new MenuDomainObject();
			MenuResponse response = new MenuResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}
	}


	public static OrderPriceResponse OrderPrice(Message message, OrderPriceRequest request) {
		try {
			OrderPriceDomainObject domainToPrice = new OrderPriceDomainObject(request);
            OrderPriceDomainObject domain = OrderModel.PriceOrder(message, domainToPrice);

            if (domain == null)
                return null;

			OrderPriceResponse response = new OrderPriceResponse(domain);
			return response;
		} catch (Exception ex) {
			message.addErrorMessage(ex.getMessage());
			return null;
		}

	}


}
