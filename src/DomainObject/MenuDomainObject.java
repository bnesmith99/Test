package DomainObject;

import java.util.ArrayList;

import Model.CrustModel;

import Model.SauceModel;
import Model.SizeModel;
import Model.ToppingModel;

public class MenuDomainObject {

    //Data Objects

    //Domain Objects
    
    public ArrayList<CrustDomainObject> getCrusts() {
        return CrustModel.GetAllCrusts();
    }

    public ArrayList<SauceDomainObject> getSauces() {
        return SauceModel.GetAllSauces();
    }

    public ArrayList<SizeDomainObject> getSizes() {
        return SizeModel.GetAllSizes();
    }

    public ArrayList<ToppingDomainObject> getToppings() {
        return ToppingModel.GetAllToppings();
    }




}
