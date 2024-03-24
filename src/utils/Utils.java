package utils;

import education.entities.classroom.Classroom;
import education.entities.subject.Type;
import login.entities.Account;
import login.entities.AccountType;
import login.view.View;
import store.entities.customer.Customer;
import store.entities.store.Store;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);
    Validate validate = new Validate();
    View view = new View();

    // Check condition input INT values
    public int inputInt(Scanner scanner){
        while (true){
            try{
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("ERROR! Try again!");
            }
        }
    }

    // Check condition input DOUBLE values
    public double inputDouble(Scanner scanner){
        while (true){
            try{
                return Double.parseDouble(scanner.nextLine());
            }catch (Exception e){
                System.out.println("ERROR! Try again!");
            }
        }
    }

    // Check condition account
    public String usernameCheck(LinkedHashMap<String, Account> accounts){
        while (true){
            System.out.println("Enter username want to create: ");
            String username = scanner.nextLine();
            if(accounts.containsKey(username)){
                System.out.println("This username is already existed! Try another one!");
            }else {
                return username;
            }
        }
    }
    public String passwordCheck(){
        while (true){
            view.passwordCondition();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            if(validate.ValidatePassword(password)){
                return password;
            }else {
                System.out.println("Password incorrect form! Password need to contain at least 7 to 15 characters, 1 uppercase characters and 1 special character on this list: . , _ ; - @");
            }
        }
    }
    public String nameCheck(){
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }
    public String addressCheck(){
        System.out.println("Enter address: ");
        return scanner.nextLine();
    }

    // Check condition account EDUCATION SYSTEM
    public String emailEduCheck(LinkedHashMap<String, Account> accounts){
        while (true){
            int count = 0;
            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            if(validate.ValidateEmail(email)){
                for(Map.Entry<String, Account> account : accounts.entrySet()){
                    if( (account.getValue().getEmail().equals(email) && account.getValue().getRole().equals(AccountType.Student))
                            || (account.getValue().getEmail().equals(email) && account.getValue().getRole().equals(AccountType.Teacher)) ){
                        count++;
                        System.out.println("This email has been used! Try another one!");
                    }
                }
                if(count<=0){
                    return email;
                }
            }else {
                System.out.println("Email incorrect form! Example: user@gmail.com.vn, user@gmail.com, ...");
            }
        }
    }
    public String phoneEduCheck(LinkedHashMap<String, Account> accounts){
        while (true){
            int count = 0;
            System.out.println("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            if(validate.ValidatePhoneNumber(phoneNumber)){
                for(Map.Entry<String,Account> account : accounts.entrySet()){
                    if( (account.getValue().getPhone().equals(phoneNumber) && account.getValue().getRole().equals(AccountType.Student))
                            || (account.getValue().getPhone().equals(phoneNumber) && account.getValue().getRole().equals(AccountType.Teacher)) ){
                        count++;
                        System.out.println("This phone number has been used! Try another one!");
                    }
                }
                if(count<=0){
                    return phoneNumber;
                }
            }else {
                System.out.println("Phone number must have 10 number! Try again!");
            }
        }
    }
    public double avgScoreCheck(){
        while (true){
            System.out.println("Enter student avgScore: ");
            double avgScore = inputDouble(scanner);
            if(avgScore >= 0 && avgScore <= 10){
                return avgScore;
            }else {
                System.out.println("0 <= avgScore <= 10");
            }
        }
    }
    public String teacherUsernameExistedCheck(Classroom classroom){
        while (true){
            System.out.println("Enter teacher username: ");
            String username = scanner.nextLine();
            if(classroom.getTeachers().containsKey(username)){
                return username;
            }else {
                System.out.println("Don't have teacher has username is: "+username+" on education system! Try again!");
            }
        }
    }
    public String studentUsernameExistedCheck(Classroom classroom){
        while (true){
            System.out.println("Enter student username: ");
            String username = scanner.nextLine();
            if(classroom.getStudents().containsKey(username)){
                return username;
            }else {
                System.out.println("Don't have student account has username is: "+username+" on education system! Try again!");
            }
        }
    }

    // Check condition account STORE SYSTEM
    public String emailStoreCheck(LinkedHashMap<String, Account> accounts){
        while (true){
            int count = 0;
            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            if(validate.ValidateEmail(email)){
                for(Map.Entry<String,Account> account : accounts.entrySet()){
                    if( (account.getValue().getEmail().equals(email) && account.getValue().getRole().equals(AccountType.Customer))
                            || (account.getValue().getEmail().equals(email) && account.getValue().getRole().equals(AccountType.Staff)) ){
                        count++;
                        System.out.println("This email has been used! Try another one!");
                    }
                }
                if(count<=0){
                    return email;
                }
            }else {
                System.out.println("Email incorrect form! Example: user@gmail.com.vn, user@gmail.com, ...");
            }
        }
    }
    public String phoneStoreCheck(LinkedHashMap<String, Account> accounts){
        while (true){
            int count = 0;
            System.out.println("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            if(validate.ValidatePhoneNumber(phoneNumber)){
                for(Map.Entry<String,Account> account : accounts.entrySet()){
                    if( (account.getValue().getPhone().equals(phoneNumber) && account.getValue().getRole().equals(AccountType.Customer))
                            || (account.getValue().getPhone().equals(phoneNumber) && account.getValue().getRole().equals(AccountType.Staff)) ){
                        count++;
                        System.out.println("This phone number has been used! Try another one!");
                    }
                }
                if(count<=0){
                    return phoneNumber;
                }
            }else {
                System.out.println("Phone number must have 10 number! Try again!");
            }
        }
    }
    public double balanceCheck(){
        while (true){
            System.out.println("Enter balance: ");
            double balance = inputDouble(scanner);
            if(balance<=0){
                System.out.println("balance set > 0");
            }else {
                return balance;
            }
        }
    }
    public String customerUsernameExistedCheck(Store store){
        while (true){
            System.out.println("Enter customer's username want to edit information");
            String username = scanner.nextLine();
            for(Map.Entry<String, Customer> customer : store.getCustomers().entrySet()){
                if(customer.getKey().equals(username)){
                    return username;
                }
            }
            System.out.println("Don't have customer has username is: "+username+" on system! Try again!");
        }
    }

    // Check condition subject EDUCATION SYSTEM
    public int idSubjectExistedCheck(Classroom classroom){
        while (true){
            System.out.println("Enter id subject: ");
            int id = inputInt(scanner);
            if(classroom.getSubjects().containsKey(id)){
                return id;
            }else {
                System.out.println("Don't have subject has id: "+id+" on system! Try again!");
            }
        }
    }
    public int idSubjectNoExistedCheck(Classroom classroom){
        while (true){
            System.out.println("Enter id subject: ");
            int id = inputInt(scanner);
            if(classroom.getSubjects().containsKey(id)){
                System.out.println("This id subject is already existed! Try again!");
            }else {
                return id;
            }
        }
    }
    public String nameSubjectCheck(){
        System.out.println("Enter name subject: ");
        return scanner.nextLine();
    }
    public int numberOfCreditSubjectCheck(){
        while (true){
            System.out.println("Enter number of credit subject: ");
            int numberOfCredit = inputInt(scanner);
            if(numberOfCredit<=0){
                System.out.println("Number of credit > 0! Try again!");
            }else {
                return numberOfCredit;
            }
        }
    }
    public Type typeSubjectOrMajorCheck(){
        while (true){
            System.out.println("Choose type of subject/major: ");
            System.out.println("1. TECH");
            System.out.println("2. BUSINESS");
            System.out.println("3. LANGUAGE");
            int chooseType = inputInt(scanner);
            switch (chooseType){
                case 1 -> {
                    return Type.TECH;
                }
                case 2 -> {
                    return Type.BUSINESS;
                }
                case 3 -> {
                    return Type.LANGUAGE;
                }
                default -> System.out.println("That is not an option! Try again!");
            }
        }
    }

    // Check condition product STORE SYSTEM
    public int findProductExistedById(Store store) {
        while (true) {
            System.out.println("Enter product's id");
            int id = inputInt(scanner);
            if (store.getProducts().containsKey(id)) {
                return id;
            } else {
                System.out.println("Don't have product has id is: " + id + "! Try again!");
            }
        }
    }
    public int inputOrderProductQuantityCheck(Store store,int id){
        int quantityProductMax = store.getProducts().get(id).getQuantity();
        while (true){
            System.out.println("Enter product's quantity");
            int quantity = inputInt(scanner);
            if(quantity <= 0){
                System.out.println("Product's quantity > 0! Try again!");
            }else if(quantity > quantityProductMax){
                System.out.println("Quantity exceeded the quantity in stock! Try again!");
            } else return quantity;
        }
    }
    public int inputAddIdProductCheck(Store store){
        while (true){
            System.out.println("Enter product's id");
            int id = Integer.parseInt(scanner.nextLine());
            if(store.getProducts().containsKey(id)){
                System.out.println("This product's id already existed! Try again!");
            }
            else {
                return id;
            }
        }
    }
    public double inputAddPriceProductCheck(){
        while (true){
            System.out.println("Enter product's price want to add");
            double price = inputDouble(scanner);
            if(price>0){
                return price;
            }else {
                System.out.println("Product's price > 0");
            }
        }
    }
    public int inputAddQuantityProductCheck(){
        while (true){
            System.out.println("Enter product's quantity want to add");
            int quantity = inputInt(scanner);
            if(quantity>0){
                return quantity;
            }else {
                System.out.println("Product's quantity > 0");
            }
        }
    }
    public int editOrderExistedCheck(Store store){
        while (true){
            System.out.println("Enter order's id want to edit status:");
            int id = inputInt(scanner);
            if(store.getOrders().containsKey(id) && store.getOrders().get(id).getStatus().equals("Order was confirmed by customer! Waiting for be confirmed by staffs!")){
                return id;
            }else if(store.getOrders().containsKey(id) && store.getOrders().get(id).getStatus().equals("Order was accepted! Product is being delivered!")){
                System.out.println("This order was accepted already!");
            } else {
                System.out.println("Don't have order has id is: "+id+"! Try again!");
            }
        }
    }

}