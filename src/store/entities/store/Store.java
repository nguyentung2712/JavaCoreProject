package store.entities.store;

import store.entities.customer.Customer;
import store.entities.staff.Staff;

import java.util.LinkedHashMap;
import java.util.Map;

public class Store {
    private static int autoId=0;
    private int id;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;
    private LinkedHashMap<String, Staff> staffs;
    private LinkedHashMap<String, Customer> customers;

    public Store(Map<Integer, Product> products, Map<Integer, Order> orders, LinkedHashMap<String, Staff> staffs, LinkedHashMap<String, Customer> customers) {
        this.id = ++autoId;
        this.products = products;
        this.orders = orders;
        this.staffs = staffs;
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Store's information{" +
                " id: " + id +
                ", products: " + products +
                ", orderCustomers list: " + orders +
                ", staffs: " + staffs +
                ", customers: " + customers +
                " }";
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Store.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public LinkedHashMap<String, Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(LinkedHashMap<String, Staff> staffs) {
        this.staffs = staffs;
    }

    public LinkedHashMap<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(LinkedHashMap<String, Customer> customers) {
        this.customers = customers;
    }
}
