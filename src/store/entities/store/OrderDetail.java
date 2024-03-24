package store.entities.store;

public class OrderDetail {
    private static int autoId=0;
    private int id;
    private int idProduct;
    private String nameProduct;
    private int quantity;
    private double total;

    public OrderDetail(int idProduct, String nameProduct, int quantity, double total) {
        this.id = ++autoId;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {
        return "{ order detail's id: " + id +
                ", product's id: " + idProduct +
                ", product's name: " + nameProduct +
                ", quantity add to order: " + quantity +
                ", total: " + total + '$' +
                " }\n";
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        OrderDetail.autoId = autoId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
