package DomainObject;

public class SauceDomainObject {

    //Data Objects
	public int sauceId;
    public String name;
    public String description;
    public int price;


    //Domain Objects
    //None

    
    public SauceDomainObject (int sauceId, String name, String description, int price) {
        this.sauceId = sauceId;
        this.name = name;
        this.description = description; 
        this.price = price;
    }

}
