import Model.CrustModel;
import Model.CustomerModel;
import Model.OrderModel;
import Model.PizzaModel;
import Model.SauceModel;
import Model.SizeModel;
import Model.ToppingModel;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Application is running");


        CrustModel crustModel = new CrustModel();
        SauceModel sauceModel = new SauceModel();
        SizeModel sizeModel = new SizeModel();
        ToppingModel toppingModel = new ToppingModel();
        PizzaModel pizzaModel = new PizzaModel();
		CustomerModel customerModel = new CustomerModel();
		OrderModel orderModel = new OrderModel();
    }
}
