package store.service;

import login.entities.Account;
import store.service.impl.StoreService;
import login.view.View;
import store.entities.customer.Customer;
import store.entities.customer.ProductAddToCart;
import store.entities.store.*;
import utils.Utils;

import java.util.*;

public class CustomerService implements StoreService<Store> {
    Scanner scanner = new Scanner(System.in);
    View view = new View();
    Utils utils = new Utils();

    Map<Integer,Order> ordersCancel = new HashMap<>();

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

    // 3. View customer's own information
    public void viewCustomerInfo(Customer customer){
        System.out.println(customer.customerInfoCustomerView());
    }

    // 4. See customer's own cart
    public void viewCustomerOwnCart(Customer customer){
        if(customer.getCart().getProductAddToCarts().isEmpty()){
            System.out.println("Your cart is empty!");
        }else {
            System.out.println(customer.getCart());
        }
    }

    // 5. Edit product in customer's owner cart
    public void editProductInCart(Customer customer, Store store){
        while (true){
            // print products have in stock
            viewAllProduct(store);

            // print customer's cart on console screen
            viewCustomerOwnCart(customer);

            // find product's id want to add to cart
            int id = utils.findProductExistedById(store);

            store.getProducts().get(id);

            // command edit product in cart
            while (true){
                view.chooseCommandEditInCart();
                int commandEditProductInCart = utils.inputInt(scanner);
                switch (commandEditProductInCart){
                    case 1 -> addProductToCart(customer, store, id);
                    case 2 -> removeProductFromCart(customer,id);
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println("That is not option! Try again!");
                        continue;
                    }
                }
                break;
            }

            view.confirmEditProductInCart();
            int choose = utils.inputInt(scanner);
            switch (choose){
                case 1 -> {
                    continue;
                }
                case 2 -> viewCustomerOwnCart(customer);
                default -> {
                    System.out.println("That is not options! Try again!");
                    continue;
                }
            }
            break;
        }
    }
    // 5.1. Add product to cart
    public void addProductToCart(Customer customer, Store store, int id){
        int count = 0;
        for(Map.Entry<Integer, ProductAddToCart> productAddToCart : customer.getCart().getProductAddToCarts().entrySet()) {
            // if product is existed will announce product already has
            if(productAddToCart.getValue().getIdProduct() == id){
                count++;
                System.out.println("This product already has in your cart!");
            }
        }
        // if not will create new product's info then add to cart
        if(count<=0) {
            ProductAddToCart productAddToCart = new ProductAddToCart(id,store.getProducts().get(id).getName(),store.getProducts().get(id).getPrice(),store.getProducts().get(id).getDescription());
            customer.getCart().getProductAddToCarts().put(productAddToCart.getId(),productAddToCart);
        }
    }
    // 5.2. Remove product from cart
    public void removeProductFromCart(Customer customer, int id){
        int count = 0;
        for(Map.Entry<Integer, ProductAddToCart> productAddToCart : customer.getCart().getProductAddToCarts().entrySet()){
            // if product is existed will remove immediately
            if(productAddToCart.getValue().getIdProduct() == id){
                count++;
                customer.getCart().getProductAddToCarts().remove(productAddToCart.getKey());
            }
        }
        // if not will announce don't have product in cart
        if(count<=0) {
            System.out.println("Don't have this product in your cart!");
        }
    }

    // 6. Order product existed in customer's owner cart
    public void orderProduct(Customer customer, Store store){

        double totalPriceAllProduct = 0;
        int count = 0;

        // create new order detail list when ever customer order
        Map<Integer,OrderDetail> orderDetails = new HashMap<>();

        if(customer.getCart().getProductAddToCarts().isEmpty()){
            System.out.println("You don't have any product in your cart");
        }else {
            while (true){
                // print products have in stock
                viewAllProduct(store);

                // print products were added to cart
                viewCustomerOwnCart(customer);

                // enter product's id want to order
                System.out.println("Choose product's id want to order");
                int id = utils.findProductExistedById(store);

                // product's quantity have in stock
                int quantityProductMax = store.getProducts().get(id).getQuantity();

                // check product is existed in your cart or not
                for(Map.Entry<Integer,ProductAddToCart> productAddToCart : customer.getCart().getProductAddToCarts().entrySet()){

                    // if product is existed, enter quantity want to order
                    if(productAddToCart.getValue().getIdProduct() == id){
                        count++;
                        if(store.getProducts().get(id).getQuantity() == 0){
                            System.out.println("You can order this product because it's quantity is out of stock!");
                        }else {
                            // enter quantity want to order and check quantity not over product's quantity in stock
                            int quantity = utils.inputOrderProductQuantityCheck(store,id);

                            // calculate total price of one product
                            double totalPriceOneProduct = store.getProducts().get(id).getPrice() * quantity;

                            // create new order detail of one product
                            OrderDetail orderDetail = new OrderDetail(id,store.getProducts().get(id).getName(),quantity,totalPriceOneProduct);

                            // decrease product quantity in stock after order
                            store.getProducts().get(id).setQuantity( quantityProductMax - quantity );

                            // put order detail of 1 product to order detail list
                            orderDetails.put(orderDetail.getId(),orderDetail);

                            // calculate price all product
                            totalPriceAllProduct += totalPriceOneProduct;

                            // print order detail list to console screen
                            System.out.println(orderDetails);
                        }
                        break;
                    }
                }
                // if not, try again
                if(count<=0) {
                    System.out.println("Don't have product has id: " + id + " in your cart!");
                }

                view.confirmOrderMoreProduct();
                int choose = utils.inputInt(scanner);
                switch (choose){
                    case 1 -> {
                        continue;
                    }
                    case 2 -> {
                        if(orderDetails.isEmpty()){
                            System.out.println("You don't order anything yet!");
                        }else {
                            // create new order
                            Order order = new Order(orderDetails,totalPriceAllProduct,customer.getUsername(),customer.getName(),customer.getPhone(),customer.getAddress());

                            while (true){
                                // print order to console screen
                                System.out.println(order);

                                // confirm order
                                view.confirmOrder();
                                int confirmOrder = utils.inputInt(scanner);
                                switch (confirmOrder){
                                    case 1 -> {
                                        // check balance
                                        if(customer.getBalance() >= order.getTotal()){
                                            // decrease customer balance
                                            customer.setBalance( customer.getBalance() - order.getTotal());

                                            // edit order status after confirm order
                                            order.setStatus("Order was confirmed by customer! Waiting for be confirmed by staffs!");

                                            // put new order to order list of store
                                            store.getOrders().put(order.getId(),order);

                                            // print order to console screen
                                            System.out.println(order);
                                        }
                                        else {
                                            System.out.println("You don't have enough money to pay for the order! This order will be canceled!");

                                            // increase product's quantity because customer don't have enough money to pay
                                            store.getProducts().get(id).setQuantity(quantityProductMax);

                                            // move order to cancel order list and delete
                                            ordersCancel.put(order.getId(),order);
                                            order.getOrderDetails().clear();
                                            ordersCancel.clear();
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("This order will be canceled!");

                                        // increase product's quantity when customer cancel order
                                        store.getProducts().get(id).setQuantity(quantityProductMax);

                                        // move order has been canceled to cancel order list and delete
                                        ordersCancel.put(order.getId(),order);
                                        order.getOrderDetails().clear();
                                        ordersCancel.clear();
                                    }
                                    default -> {
                                        System.out.println("That is not option! Try again!");
                                        continue;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    default -> {
                        System.out.println("That is not options! Try again!");
                        continue;
                    }
                }
                break;
            }
        }
    }

    // 7. View customer's own order
    public void viewOrders(Customer customer, Store store){

        System.out.println("1. Order was confirmed by staff: ");
        int countConfirmed = 0;
        for(Map.Entry<Integer,Order> order : store.getOrders().entrySet()){
            if( (order.getValue().getCustomerUsername().equals(customer.getUsername()))
                    && (order.getValue().getStatus().equals("Order was accepted! Product is being delivered!")) ){
                countConfirmed++;
                System.out.println(order);
            }
        }
        if(countConfirmed<=0){
            System.out.println("Empty!");
        }

        System.out.println("2. Order wasn't confirmed by staff: ");
        int countNotConfirmed = 0;
        for(Map.Entry<Integer,Order> order : store.getOrders().entrySet()){
            if( (order.getValue().getCustomerUsername().equals(customer.getUsername()))
                    && (order.getValue().getStatus().equals("Order was confirmed by customer! Waiting for be confirmed by staffs!")) ){
                countNotConfirmed++;
                System.out.println(order);
            }
        }
        if(countNotConfirmed<=0){
            System.out.println("Empty!");
        }
    }

    // 8. Edit customer's own information
    public void editCustomerOwnInfo(LinkedHashMap<String,Account> accounts,Customer customer){

        while (true){
            view.menuEditCustomerOwnInfo();
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1 -> editCustomerName(customer);
                case 2 -> editCustomerPhoneNumber(accounts,customer);
                case 3 -> editCustomerAddress(customer);
                case 4 -> editCustomerBalance(customer);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("That is not an option! Try again!");
                    continue;
                }
            }
            System.out.println(customer.customerInfoCustomerView());
            break;
        }
    }
    // 8.1. Edit customer's name
    public void editCustomerName(Customer customer){
        String name = utils.nameCheck();
        customer.setName(name);
    }
    // 8.2. Edit customer's phone
    public void editCustomerPhoneNumber(LinkedHashMap<String, Account> accounts, Customer customer){
        String phone = utils.phoneStoreCheck(accounts);
        customer.setPhone(phone);
    }
    // 8.3. Edit customer's address
    public void editCustomerAddress(Customer customer){
        String address = utils.addressCheck();
        customer.setAddress(address);
    }
    // 8.4. Edit customer's balance
    public void editCustomerBalance(Customer customer){
        double balance = utils.balanceCheck();
        customer.setBalance(balance);
    }

}