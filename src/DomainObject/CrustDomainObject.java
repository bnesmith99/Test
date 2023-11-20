package DomainObject;

public class CrustDomainObject {

    //Data Objects
	public int crustId;
    public String name;
    public String description;
    public int price;
    
    
    //Domain Objects
    //None

    
    public CrustDomainObject (int crustId, String name, String description, int price) {
        this.crustId = crustId;
        this.name = name;
        this.description = description; 
        this.price = price;
    }

}
