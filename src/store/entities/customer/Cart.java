package store.entities.customer;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static int autoId=0;
    private int id;
    private Map<Integer, ProductAddToCart> productAddToCarts;

    public Cart() {
        this.id = ++autoId;
        this.productAddToCarts = new HashMap<>();
    }

    @Override
    public String toString() {
        return "{ Cart's id: " + id +
                ", product add to carts: \n" + productAddToCarts +
                " }\n";
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Cart.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, ProductAddToCart> getProductAddToCarts() {
        return productAddToCarts;
    }

    public void setProductAddToCarts(Map<Integer, ProductAddToCart> productAddToCarts) {
        this.productAddToCarts = productAddToCarts;
    }
}
