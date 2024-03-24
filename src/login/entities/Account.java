package login.entities;

public class Account {
    private String username;
    private String email;
    private String password;
    private AccountType role;
    private String name;
    private String phone;
    private String address;

    public Account(String username, String email, String password, AccountType role, String name, String phone, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String accountView() {
        return "Account's information{" +
                " username: " + username +
                ", email: " + email +
                ", password: " + password +
                ", account type: " + role +
                ", name: " + name +
                ", phone: " + phone +
                ", address: " + address +
                " }\n";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getRole() {
        return role;
    }

    public void setRole(AccountType role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
