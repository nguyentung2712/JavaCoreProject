package login.entities;

import education.entities.classroom.Classroom;
import education.entities.student.Student;
import education.entities.subject.Type;
import education.entities.teacher.Teacher;
import store.entities.customer.Customer;
import store.entities.staff.Staff;
import store.entities.store.Store;

import java.util.LinkedHashMap;

public class AccountList {
    public void accountList(LinkedHashMap<String,Account> accounts, Classroom classroom, Store store){

        // Admin
        Account adminEdu = new Account(
                "adminEdu", "adminEdu@gmail.com", "adminEdu1.",AccountType.AdminEdu,
                "adminEdu","0000000000","Vietnam"
        );

        // Students
        Student student1 = new Student(
                "student1","student1@gmail.com","studentN1.",AccountType.Student,
                "student1","0234567891","Vietnam",8,"teacher1"
        );
        Student student2 = new Student(
                "student2","student2@gmail.com","studentN2.",AccountType.Student,
                "student2","0245678913","Vietnam",8,"teacher1"
        );
        Student student3 = new Student(
                "student3","student3@gmail.com","studentN3.",AccountType.Student,
                "student3","0256789134","Vietnam",8,"teacher2"
        );
        Student student4 = new Student(
                "student4","student4@gmail.com","studentN4.",AccountType.Student,
                "student4","0267891345","Vietnam",8,"teacher2"
        );
        Student student5 = new Student(
                "student5","student5@gmail.com","studentN5.",AccountType.Student,
                "student5","0278913456","Vietnam",8,"teacher3"
        );
        Student student6 = new Student(
                "student6","student6@gmail.com","studentN6.",AccountType.Student,
                "student6","0289134567","Vietnam",8,"teacher3"
        );

        // Teachers
        Teacher teacher1 = new Teacher(
                "teacher1","teacher1@gmail.com","teacherN1.",AccountType.Teacher,
                "teacher1","0123456789","Vietnam", Type.TECH
        );
        Teacher teacher2 = new Teacher(
                "teacher2","teacher2@gmail.com","teacherN2.",AccountType.Teacher,
                "teacher2","0134567892","Vietnam",Type.BUSINESS
        );
        Teacher teacher3 = new Teacher(
                "teacher3","teacher3@gmail.com","teacherN3.",AccountType.Teacher,
                "teacher3","0145678923","Vietnam",Type.LANGUAGE
        );

        // Customer
        Customer customer1 = new Customer(
                "customer1","customer1@gmail.com","customerN1.",AccountType.Customer,
                "customer1","0345678912","Vietnam",5000
        );
        Customer customer2 = new Customer(
                "customer2","customer2@gmail.com","customerN2.",AccountType.Customer,
                "customer2","0356789124","Vietnam",5000
        );
        Customer customer3 = new Customer(
                "customer3","customer3@gmail.com","customerN3.",AccountType.Customer,
                "customer3","0367891245","Vietnam",5000
        );

        // Staff
        Staff staff1 = new Staff(
                "staff1","staff1@gmail.com","staffN1.",AccountType.Staff,
                "staff1","0456789123","Vietnam"
        );
        Staff staff2 = new Staff(
                "staff2","staff2@gmail.com","staffN2.",AccountType.Staff,
                "staff2","0467891235","Vietnam"
        );

        accounts.put(adminEdu.getUsername(),adminEdu);

        accounts.put(student1.getUsername(),student1);
        accounts.put(student2.getUsername(),student2);
        accounts.put(student3.getUsername(),student3);
        accounts.put(student4.getUsername(),student4);
        accounts.put(student5.getUsername(),student5);
        accounts.put(student6.getUsername(),student6);

        accounts.put(teacher1.getUsername(),teacher1);
        accounts.put(teacher2.getUsername(),teacher2);
        accounts.put(teacher3.getUsername(),teacher3);

        accounts.put(customer1.getUsername(),customer1);
        accounts.put(customer2.getUsername(),customer2);
        accounts.put(customer3.getUsername(),customer3);

        accounts.put(staff1.getUsername(),staff1);
        accounts.put(staff2.getUsername(),staff2);

        classroom.getStudents().put(student1.getUsername(),student1);
        classroom.getStudents().put(student2.getUsername(),student2);
        classroom.getStudents().put(student3.getUsername(),student3);
        classroom.getStudents().put(student4.getUsername(),student4);
        classroom.getStudents().put(student5.getUsername(),student5);
        classroom.getStudents().put(student6.getUsername(),student6);

        classroom.getTeachers().put(teacher1.getUsername(),teacher1);
        classroom.getTeachers().put(teacher2.getUsername(),teacher2);
        classroom.getTeachers().put(teacher3.getUsername(),teacher3);

        store.getCustomers().put(customer1.getUsername(),customer1);
        store.getCustomers().put(customer2.getUsername(),customer2);
        store.getCustomers().put(customer3.getUsername(),customer3);

        store.getStaffs().put(staff1.getUsername(),staff1);
        store.getStaffs().put(staff2.getUsername(),staff2);

    }
}