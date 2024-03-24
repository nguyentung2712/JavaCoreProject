package login.service;

import education.entities.classroom.Classroom;
import education.entities.student.Student;
import education.entities.teacher.Teacher;
import education.service.AdminEduService;
import education.service.StudentService;
import education.service.TeacherService;
import login.entities.Account;
import login.view.View;
import store.entities.customer.Customer;
import store.entities.staff.Staff;
import store.entities.store.*;
import store.service.CustomerService;
import store.service.StaffService;
import utils.Utils;

import java.util.*;

public class MenuUserObject {
    Scanner scanner = new Scanner(System.in);
    View view = new View();
    Utils utils = new Utils();

    // User service
    TeacherService teacherService = new TeacherService();
    StudentService studentService = new StudentService();
    CustomerService customerService = new CustomerService();
    StaffService staffService = new StaffService();
    AdminEduService adminEduService = new AdminEduService();

    // Menu admin education
    public void menuEduAdmin(Account account, LinkedHashMap<String,Account> accounts, MenuLogin menuLogin, Classroom classroom){
        while (true){
            view.menuEduAdmin();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> adminEduService.viewAllSubject(classroom);
                case 2 -> adminEduService.findSubjectById(classroom);
                case 3 -> adminEduService.subjectManagement(classroom);
                case 4 -> adminEduService.viewAllStudentAccount(classroom);
                case 5 -> adminEduService.findStudentAccountByUsername(classroom);
                case 6 -> adminEduService.studentManagement(accounts,classroom);
                case 7 -> adminEduService.viewAllTeacherAccount(classroom);
                case 8 -> adminEduService.findTeacherAccountByUsername(classroom);
                case 9 -> adminEduService.teacherManagement(accounts,classroom);
                case 10 -> menuLogin.changePassword(account);
                case 11 -> menuLogin.menuEducationSystem(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // Menu teacher
    public void menuTeacher(Teacher teacher, MenuLogin menuLogin, Classroom classroom){
        while (true){
            view.menuTeacher();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> teacherService.viewAllSubject(classroom);
                case 2 -> teacherService.findSubjectById(classroom);
                case 3 -> teacherService.viewTeacherInfo(teacher);
                case 4 -> teacherService.getAllStudentTeach(teacher,classroom);
                case 5 -> teacherService.editGradeStudent(teacher,classroom);
                case 6 -> menuLogin.changePassword(teacher);
                case 7 -> menuLogin.menuEducationSystem(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // Menu student
    public void menuStudents(Student student, MenuLogin menuLogin, Classroom classroom){
        while (true){
            view.menuStudent();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> studentService.viewAllSubject(classroom);
                case 2 -> studentService.findSubjectById(classroom);
                case 3 -> studentService.viewStudentInfo(student);
                case 4 -> studentService.showTeacherTeach(student,classroom);
                case 5 -> menuLogin.changePassword(student);
                case 6 -> menuLogin.menuEducationSystem(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // Menu customer
    public void menuCustomer(Customer customer, LinkedHashMap<String,Account> accounts, MenuLogin menuLogin, Store store){
        while (true){
            view.menuCustomer();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> customerService.viewAllProduct(store);
                case 2 -> customerService.findProductById(store);
                case 3 -> customerService.viewCustomerInfo(customer);
                case 4 -> customerService.viewCustomerOwnCart(customer);
                case 5 -> customerService.editProductInCart(customer,store);
                case 6 -> customerService.orderProduct(customer,store);
                case 7 -> customerService.viewOrders(customer,store);
                case 8 -> customerService.editCustomerOwnInfo(accounts,customer);
                case 9 -> menuLogin.changePassword(customer);
                case 10 -> menuLogin.menuStoreSystem(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // Menu staff
    public void menuStaff(Staff staff, LinkedHashMap<String,Account> accounts, MenuLogin menuLogin, Store store){
        while (true){
            view.menuStaff();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> staffService.viewAllProduct(store);
                case 2 -> staffService.findProductById(store);
                case 3 -> staffService.productManagement(store);
                case 4 -> staffService.viewStaffInfo(staff);
                case 5 -> staffService.viewAllOrder(store);
                case 6 -> staffService.findOrderById(store);
                case 7 -> staffService.editOrderStatus(store);
                case 8 -> staffService.viewAllCustomer(store);
                case 9 -> staffService.editCustomerInfo(store,accounts);
                case 10 -> menuLogin.changePassword(staff);
                case 11 -> menuLogin.menuStoreSystem(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

}