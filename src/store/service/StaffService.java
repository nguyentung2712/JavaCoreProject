package store.service;

import login.entities.Account;
import login.view.View;
import store.entities.staff.Staff;
import store.entities.store.*;
import store.service.impl.StoreService;
import utils.Utils;

import java.util.*;

public class StaffService implements StoreService<Store> {
    Scanner scanner = new Scanner(System.in);
    View view = new View();
    Utils utils = new Utils();

    // 1. View all products
    public void viewAllProduct(Store store){
        for(Map.Entry<Integer,Product> product : store.getProducts().entrySet()){
            if( product.getValue().getQuantity() == 0){
                product.getValue().setStatus("out of stock!");
            }
            else {
                product.getValue().setStatus("in stock");
            }
        }
        System.out.println(store.getProducts());
    }

    // 2. Find product by id
    public void findProductById(Store store){
        viewAllProduct(store);
        int id = utils.findProductExistedById(store);
        System.out.println(store.getProducts().get(id));
    }

    // 3. Management product
    public void productManagement(Store store){
        while (true){
            view.productManagement();
            int chooseCommand = utils.inputInt(scanner);
            switch (chooseCommand){
                case 1 -> addNewProduct(store);
                case 2 -> editProductInfo(store);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            break;
        }
    }
    // 3.1. Add new product
    public void addNewProduct(Store store){
        int id = utils.inputAddIdProductCheck(store);

        System.out.println("Enter product's name want to add");
        String name = scanner.nextLine();

        double price = utils.inputAddPriceProductCheck();

        System.out.println("Enter product's description");
        String description = scanner.nextLine();

        int quantity = utils.inputAddQuantityProductCheck();

        Product product = new Product(id,name,price,description,quantity);
        store.getProducts().put(product.getId(),product);
    }
    // 3.2. Edit product information
    public void editProductInfo(Store store){
        viewAllProduct(store);

        int id = utils.findProductExistedById(store);
        while (true){
            view.editProductInfo();
            int chooseCommand = utils.inputInt(scanner);
            switch (chooseCommand){
                case 1 -> editNameProduct(store,id);
                case 2 -> editPriceProduct(store,id);
                case 3 -> editDescriptionProduct(store,id);
                case 4 -> editQuantityProduct(store,id);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            System.out.println(store.getProducts().get(id));
            break;
        }
    }
    // 3.2.1. Edit name product existed
    public void editNameProduct(Store store, int id){
        System.out.println("Enter product's name want to edit");
        String name = scanner.nextLine();
        store.getProducts().get(id).setName(name);
    }
    // 3.2.2. Edit price product existed
    public void editPriceProduct(Store store, int id){
        while (true){
            System.out.println("Enter product's price want to edit");
            double price = utils.inputDouble(scanner);
            if(price>0){
                store.getProducts().get(id).setPrice(price);
                break;
            }else {
                System.out.println("product's price > 0");
            }
        }
    }
    // 3.2.3. Edit description product existed
    public void editDescriptionProduct(Store store, int id){
        System.out.println("Enter product's description want to edit");
        String description = scanner.nextLine();
        store.getProducts().get(id).setDescription(description);
    }
    // 3.2.4. Edit quantity product existed
    public void editQuantityProduct(Store store, int id){
        while (true){
            System.out.println("Enter product's quantity want to edit");
            int quantity = utils.inputInt(scanner);
            if(quantity>=0){
                store.getProducts().get(id).setQuantity( quantity );
                break;
            }else {
                System.out.println("Product's quantity >= 0");
            }
        }
    }

    // 4. View staff's own information
    public void viewStaffInfo(Staff staff){
        System.out.println(staff.toString());
    }

    // 5. View all orders
    public void viewAllOrder(Store store){
        if(store.getOrders().isEmpty()){
            System.out.println("Don't have order yet!");
        }else {
            System.out.println(store.getOrders());
        }
    }

    // 6. Find order by id
    public void findOrderById(Store store){
        if(store.getOrders().isEmpty()){
            System.out.println("Don't have order yet!");
        }else {
            viewAllOrder(store);
            System.out.println("Enter order's id:");
            int id = utils.inputInt(scanner);
            if(store.getOrders().containsKey(id)){
                System.out.println(store.getOrders().get(id));
            }else {
                System.out.println("Don't have order has id is: "+id+"! Try again!");
            }
        }
    }

    // 7. Edit order's status
    public void editOrderStatus(Store store){
        if(store.getOrders().isEmpty()){
            System.out.println("Don't have order to edit yet!");
        }else {
            int count = 0;
            for(Map.Entry<Integer,Order> order : store.getOrders().entrySet()){
                if(order.getValue().getStatus().equals("Order was confirmed by customer! Waiting for be confirmed by staffs!")){
                    count++;
                    System.out.println(order);
                }
            }
            if(count<=0){
                System.out.println("All order was accepted!");
            }else {
                int id = utils.editOrderExistedCheck(store);
                String status = "Order was accepted! Product is being delivered!";
                store.getOrders().get(id).setStatus(status);
                System.out.println(store.getOrders().get(id));
            }
        }
    }

    // 8. View all customers information
    public void viewAllCustomer(Store store){
        System.out.println(store.getCustomers());
    }

    // 9. Edit customer information
    public void editCustomerInfo(Store store, LinkedHashMap<String,Account> accounts){

        viewAllCustomer(store);

        String username = utils.customerUsernameExistedCheck(store);

        while (true){
            view.menuEditCustomerInfo();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> editCustomerName(store,username);
                case 2 -> editCustomerPhoneNumber(store,accounts,username);
                case 3 -> editCustomerAddress(store,username);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            System.out.println(store.getCustomers().get(username));
            break;
        }
    }
    // 9.1. Edit customer's name
    public void editCustomerName(Store store, String username){
        String name = utils.nameCheck();
        store.getCustomers().get(username).setName(name);
    }
    // 9.2. Edit customer's phone
    public void editCustomerPhoneNumber(Store store, LinkedHashMap<String,Account> accounts , String username){
        String phone = utils.phoneStoreCheck(accounts);
        store.getCustomers().get(username).setPhone(phone);
    }
    // 9.3. Edit customer's address
    public void editCustomerAddress(Store store, String username){
        String address = utils.addressCheck();
        store.getCustomers().get(username).setAddress(address);
    }

}