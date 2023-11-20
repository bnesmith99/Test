package restService.Request;

public class PizzaPriceRequest {

    private final int crustId;
    private final int sauceId;
    private final int sizeId;
    private final int toppingId;

    public PizzaPriceRequest(int crustId, int sauceId, int sizeId, int toppingId) {
        this.crustId = crustId;
        this.sauceId = sauceId;
        this.sizeId = sizeId;
        this.toppingId = toppingId;
    }

    public int getCrustId() {
        return crustId;
    }

    public int getSauceId() {
        return sauceId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public int getToppingId() {
        return toppingId;
    }

}