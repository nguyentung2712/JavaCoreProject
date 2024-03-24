package store.entities.store;

public class ProductList {
    public void productList(Store store){
        Product product1 = new Product(1,"ASUS TUF GAMING FX505DT",178,"Asus Gaming Laptop",20);
        Product product2 = new Product(2,"IphoneXr",135,"Apple twelfth generation Iphone",10);
        Product product3 = new Product(3,"AirPod2",55,"Apple second generation AirPod",30);

        store.getProducts().put(product1.getId(),product1);
        store.getProducts().put(product2.getId(),product2);
        store.getProducts().put(product3.getId(),product3);
    }
}
