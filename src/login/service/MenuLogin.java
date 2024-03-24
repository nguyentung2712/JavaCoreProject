package login.service;

import education.entities.classroom.Classroom;
import education.entities.student.Student;
import education.entities.subject.Subject;
import education.entities.subject.SubjectList;
import education.entities.teacher.Teacher;
import login.entities.Account;
import login.entities.AccountList;
import login.entities.AccountType;
import login.view.View;
import store.entities.customer.Customer;
import store.entities.staff.Staff;
import store.entities.store.Order;
import store.entities.store.Product;
import store.entities.store.ProductList;
import store.entities.store.Store;
import utils.Utils;

import java.util.*;

public class MenuLogin {
    Scanner scanner = new Scanner(System.in);
    View view = new View();
    Utils utils = new Utils();

    // Education
    SubjectList subjectList = new SubjectList();
    Map<Integer, Subject> subjects = new HashMap<>();
    LinkedHashMap<String,Teacher> teachers = new LinkedHashMap<>();
    LinkedHashMap<String,Student> students = new LinkedHashMap<>();
    Classroom classroom = new Classroom(subjects,teachers,students);

    // Store
    ProductList productList = new ProductList();
    Map<Integer, Product> products = new HashMap<>();
    Map<Integer,Order> orders = new HashMap<>();
    LinkedHashMap<String,Customer> customers = new LinkedHashMap<>();
    LinkedHashMap<String,Staff> staffs = new LinkedHashMap<>();
    Store store = new Store(products,orders,staffs,customers);

    // Account
    AccountList accountList = new AccountList();
    LinkedHashMap<String,Account> accounts = new LinkedHashMap<>();

    // User object
    MenuUserObject menuUserObject = new MenuUserObject();

    // === Menu select field to sign in ===
    public void menuSelectField(MenuLogin menuLogin){

        if(accounts.isEmpty()){
            accountList.accountList(accounts,classroom,store);
        }
        if(store.getProducts().isEmpty()){
            productList.productList(store);
        }
        if(classroom.getSubjects().isEmpty()){
            subjectList.subjectList(classroom);
        }

        while (true){
            view.menuSelectFieldView();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> menuStoreSystem(menuLogin);
                case 2 -> menuEducationSystem(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // A. Menu store system
    public void menuStoreSystem(MenuLogin menuLogin){
        while (true){
            view.menuStoreSystem();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> signInStoreSystem(menuLogin);
                case 2 -> signUpCustomerAccount(menuLogin);
                case 3 -> menuSelectField(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // A-Staff. Announce store when have new orders
    public void announceNewOrders(){
        int count = 0;
        for(Map.Entry<Integer,Order> order : orders.entrySet()){
            if(order.getValue().getStatus().equals("Order was confirmed by customer! Waiting for be confirmed by staffs!")){
                count++;
            }
        }
        if(count>0) System.out.println("Store have " + count + " new orders! Please check!");
    }

    // A-Customer. Announce customer when orders were accepted
    public void announceOrdersAccepted(Account account){
        int count = 0;
        for(Map.Entry<Integer, Order> order : orders.entrySet()){
            if(order.getValue().getStatus().equals("Order was accepted! Product is being delivered!") && order.getValue().getCustomerUsername().equals(account.getUsername())){
                count++;
            }
        }
        if(count>0) System.out.println("You have " + count + " orders was accepted! Please check to receive the delivery!");

    }

    // A-1. Sign in store system
    public void signInStoreSystem(MenuLogin menuLogin){
        while (true){
            System.out.println("=== Sign In ===");
            System.out.println("Enter username");
            String username = scanner.nextLine();
            if(accounts.containsKey(username)){
                while (true){
                    System.out.println("Enter password");
                    String password = scanner.nextLine();
                    if(accounts.get(username).getPassword().equals(password)){
                        if(accounts.get(username).getRole().equals(AccountType.Staff)){
                            announceNewOrders();
                            menuUserObject.menuStaff((Staff) accounts.get(username), accounts, menuLogin, store);
                            break;
                        }else if(accounts.get(username).getRole().equals(AccountType.Customer)){
                            announceOrdersAccepted(accounts.get(username));
                            menuUserObject.menuCustomer((Customer) accounts.get(username), accounts, menuLogin, store);
                            break;
                        }else {
                            System.out.println("This account doesn't belong to STORE system! Try again!");
                            menuStoreSystem(menuLogin);
                            break;
                        }
                    }
                    else {
                        while (true){
                            view.wrongPasswordView();
                            int choose = utils.inputInt(scanner);
                            switch (choose) {
                                case 1 -> menuStoreSystem(menuLogin);
                                case 2 -> forgotPasswordStoreSystem(menuLogin);
                                default -> {
                                    System.out.println("That is not an option! Try again!");
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
                break;
            }
            else {
                System.out.println("Don't have account has username is: "+username+"! Try again!");
            }
        }
    }

    // A-2. Return store system after change password
    public void forgotPasswordStoreSystem(MenuLogin menuLogin){

        forgotPasswordService();

        menuStoreSystem(menuLogin);
    }

    // A-3. Create new customer account
    public void signUpCustomerAccount(MenuLogin menuLogin){
        // username
        String username = utils.usernameCheck(accounts);
        // email
        String email = utils.emailStoreCheck(accounts);
        // password
        String password = utils.passwordCheck();
        // name
        String name = utils.nameCheck();
        // phone
        String phone = utils.phoneStoreCheck(accounts);
        // address
        String address = utils.addressCheck();
        // balance
        double balance = utils.balanceCheck();

        Customer customer = new Customer(username,email,password,AccountType.Customer,name,phone,address,balance);
        System.out.println(customer.customerInfoCustomerView());
        store.getCustomers().put(customer.getUsername(),customer);
        accounts.put(customer.getUsername(),customer);
        System.out.println("Account sign up success! Please sign in!");

        menuStoreSystem(menuLogin);
    }

    // B. Menu education system
    public void menuEducationSystem(MenuLogin menuLogin){
        while (true){
            view.menuEduSystem();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> signInEduSystem(menuLogin);
                case 2 -> menuSelectField(menuLogin);
                case 0 -> System.exit(0);
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // B-1. Sign in education system
    public void signInEduSystem(MenuLogin menuLogin){
        while (true){
            System.out.println("=== Sign In ===");
            System.out.println("Enter username");
            String username = scanner.nextLine();
            if(accounts.containsKey(username)){
                while (true){
                    System.out.println("Enter password");
                    String password = scanner.nextLine();
                    if(accounts.get(username).getPassword().equals(password)){
                        if(accounts.get(username).getRole().equals(AccountType.Student)){
                            menuUserObject.menuStudents((Student) accounts.get(username), menuLogin, classroom);
                            break;
                        }
                        else if(accounts.get(username).getRole().equals(AccountType.Teacher)){
                            menuUserObject.menuTeacher((Teacher) accounts.get(username), menuLogin,classroom);
                            break;
                        }
                        else if(accounts.get(username).getRole().equals(AccountType.AdminEdu)){
                            menuUserObject.menuEduAdmin(accounts.get(username), accounts, menuLogin,classroom);
                            break;
                        }else {
                        System.out.println("This account doesn't belong to EDUCATION system! Try again!");
                        menuEducationSystem(menuLogin);
                        break;
                        }
                    }else {
                        while (true){
                            view.wrongPasswordView();
                            int choose = utils.inputInt(scanner);
                            switch (choose) {
                                case 1 -> menuEducationSystem(menuLogin);
                                case 2 -> forgotPasswordEduSystem(menuLogin
                                );
                                default -> {
                                    System.out.println("That is not an option! Try again!");
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
                break;
            }else {
                System.out.println("Don't have user has username is: "+username+"! Try again!");
            }
        }
    }

    // B-2. Return education system after change password
    public void forgotPasswordEduSystem(MenuLogin menuLogin){

        forgotPasswordService();

        menuEducationSystem(menuLogin);
    }

    // Change password
    public void changePassword(Account account){
        String password = utils.passwordCheck();
        account.setPassword(password);
        System.out.println(account.accountView());
    }

    // Forgot password service
    public void forgotPasswordService(){
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        int count = 0;
        for(Map.Entry<String,Account> account : accounts.entrySet()){
            if(account.getValue().getEmail().equals(email)){
                count++;
                String password = utils.passwordCheck();
                account.getValue().setPassword(password);
                System.out.println("Change password success! Please sign in!");
                System.out.println(account);
                break;
            }
        }
        if(count<=0) System.out.println("Don't have account has email is: "+email);
    }

}