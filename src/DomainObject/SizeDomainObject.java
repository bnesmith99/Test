package DomainObject;

public class SizeDomainObject {

    //Data Objects
	public int sizeId;
    public String name;
    public String description;
    public int price;


    //Domain Objects
    //None

    
    public SizeDomainObject (int sizeId, String name, String description, int price) {
        this.sizeId = sizeId;
        this.name = name;
        this.description = description; 
        this.price = price;
    }

}
