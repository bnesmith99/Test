package DomainObject;

public class ToppingDomainObject {

    //Data Objects
	public int toppingId;
    public String name;
    public String description;
    public int price;


    //Domain Objects
    //None

    
    public ToppingDomainObject (int toppingId, String name, String description, int price) {
        this.toppingId = toppingId;
        this.name = name;
        this.description = description; 
        this.price = price;
    }

}
