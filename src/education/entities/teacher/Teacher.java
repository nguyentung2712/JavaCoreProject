package education.entities.teacher;

import education.entities.subject.Type;
import login.entities.Account;
import login.entities.AccountType;

public class Teacher extends Account {
    private Type major;

    public Teacher(String username, String email, String password, AccountType role, String name, String phone, String address, Type major) {
        super(username, email, password, role, name, phone, address);
        this.major = major;
    }

    @Override
    public String toString() {
        return "Teacher's information{" +
                " name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", email: " + super.getEmail() +
                ", address: " + super.getAddress() +
                ", major: " + major + " }\n";
    }

    public String teacherInfoTeacherView(){
        return "Teacher's information{" +
                " username: " + super.getUsername() +
                ", email: " + super.getEmail() +
                ", password: " + super.getPassword() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                ", major: " + major +
                " }\n";
    }

    public String teacherInfoAdminEduView(){
        return "Teacher's information{" +
                " username: " + super.getUsername() +
                ", email: " + super.getEmail() +
                ", password: " + super.getPassword() +
                ", type: " + super.getRole() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                ", major: " + major +
                " }\n";
    }

    public Type getMajor() {
        return major;
    }

    public void setMajor(Type major) {
        this.major = major;
    }
}
