package store.entities.customer;

public class ProductAddToCart {
    private static int autoId;
    private int id;
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private String description;

    public ProductAddToCart(int idProduct, String nameProduct, double priceProduct, String description) {
        this.id = ++autoId;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{ product's id: " + idProduct +
                ", product's name: " + nameProduct +
                ", product's price: " + priceProduct + '$' +
                ", product's description: " + description +
                " }\n";
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        ProductAddToCart.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
