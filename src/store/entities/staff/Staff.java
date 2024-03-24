package store.entities.staff;

import login.entities.Account;
import login.entities.AccountType;

public class Staff extends Account {
    public Staff(String username, String email, String password, AccountType role, String name, String phone, String address) {
        super(username, email, password, role, name, phone, address);
    }

    @Override
    public String toString() {
        return "Staff's information{" +
                " username: " + super.getUsername() +
                ", email: " + super.getEmail() +
                ", password: " + super.getPassword() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", email: " + super.getEmail() +
                ", address: " + super.getAddress() +
                " }\n";
    }
}
