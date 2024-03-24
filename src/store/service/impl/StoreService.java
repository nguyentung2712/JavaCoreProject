package store.service.impl;

public interface StoreService<T> {
    void viewAllProduct(T T);
    void findProductById(T T);
}
