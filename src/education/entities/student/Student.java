package education.entities.student;

import login.entities.Account;
import login.entities.AccountType;

public class Student extends Account {
    private double avgScore;
    private String teacherUsername;

    public Student(String username, String email, String password, AccountType role, String name, String phone, String address, double avgScore, String teacherUsername) {
        super(username, email, password, role, name, phone, address);
        this.avgScore = avgScore;
        this.teacherUsername = teacherUsername;
    }

    @Override
    public String toString() {
        return "Student's information{" +
                " username: " + super.getUsername() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                ", avg score: " + avgScore +
                " }\n";
    }

    public String studentInfoStudentView() {
        return "Student's information{" +
                " username: " + super.getUsername() +
                ", email: " + super.getEmail() +
                ", password: " + super.getPassword() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                ", avg score: " + avgScore +
                " }\n";
    }

    public String studentInfoAdminEduView() {
        return "Student's information{" +
                " username: " + super.getUsername() +
                ", email: " + super.getEmail() +
                ", password: " + super.getPassword() +
                ", type: " + super.getRole() +
                ", name: " + super.getName() +
                ", phone: " + super.getPhone() +
                ", address: " + super.getAddress() +
                ", avg score: " + avgScore +
                ", teacher's username: " + teacherUsername +
                " }\n";
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }
}
