package store.entities.store;

import java.time.LocalDate;
import java.util.Map;

public class Order {
    private static int autoId=0;
    private int id;
    private LocalDate orderDate;
    private Map<Integer,OrderDetail> orderDetails;
    private String status;
    private double total;
    private String customerUsername;
    private String customerName;
    private String customerPhone;
    private String customerAddress;

    public Order(Map<Integer, OrderDetail> orderDetails, double total, String customerUsername, String customerName, String customerPhone, String customerAddress) {
        this.id = ++autoId;
        this.orderDate = LocalDate.now();
        this.orderDetails = orderDetails;
        this.status = "Waiting for customer to confirm the order!";
        this.total = total;
        this.customerUsername = customerUsername;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "{ order's id: " + id +
                ", order date: " + orderDate +
                ", order details: \n" + orderDetails +
                "\n, status: " + status +
                ", total: " + total + '$' +
                ", customer's name: " + customerName +
                ", customer's phone: " + customerPhone +
                ", customer's address: " + customerAddress +
                " }\n \n";
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Order.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Map<Integer, OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<Integer, OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
