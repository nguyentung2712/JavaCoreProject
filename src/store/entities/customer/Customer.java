package store.entities.customer;

import login.entities.Account;
import login.entities.AccountType;

public class Customer extends Account {
    private double balance;
    private Cart cart;

    public Customer(String username, String email, String password, AccountType role, String name, String phone, String address, double balance) {
        super(username, email, password, role, name, phone, address);
        this.balance = balance;
        this.cart = new Cart();
    }

    @Override
    public String toString() {
        return "Customer's information{" +
                " username: " + super.getUsername() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                " }\n";
    }

    public String customerInfoCustomerView(){
        return "Customer's information{" +
                " username: " + super.getUsername() +
                ", email: " + super.getEmail() +
                ", password: " + super.getPassword() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                ", balance: " + balance + '$' +
                ", cart: \n" + cart +
                " }\n";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
