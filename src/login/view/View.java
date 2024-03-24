package login.view;

public class View {
    public void menuSelectFieldView(){
        System.out.println("=== SELECT FIELD WANT TO LOG IN ===");
        System.out.println("1. STORE SYSTEM");
        System.out.println("2. EDUCATION SYSTEM");
        System.out.println("0. Exit");
    }
    public void menuStoreSystem(){
        System.out.println("=== STORE SYSTEM ===");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Return");
        System.out.println("0. Exit");
    }
    public void menuEduSystem(){
        System.out.println("=== EDUCATION SYSTEM ===");
        System.out.println("1. Sign In");
        System.out.println("2. Return");
        System.out.println("0. Exit");
    }
    public void passwordCondition(){
        System.out.println("1. password length at least 7 characters and maximum of 15.");
        System.out.println("2. password must contains one uppercase characters.");
        System.out.println("3. password create must contains one special symbol");
    }
    public void wrongPasswordView(){
        System.out.println("Choose options");
        System.out.println("1. Sign in again");
        System.out.println("2. Forgot password");
    }
    // Store view
    public void menuStaff(){
        System.out.println("======== Choose command ========");
        System.out.println("1. View all product's information");
        System.out.println("2. Find product by id");
        System.out.println("3. Product management");
        System.out.println("4. View staff's own information");
        System.out.println("5. View all order's information");
        System.out.println("6. Find order by id");
        System.out.println("7. Edit order's status");
        System.out.println("8. View all customer's information");
        System.out.println("9. Edit customer's information");
        System.out.println("10. Change password");
        System.out.println("11. Sign out");
        System.out.println("0. Exit");
    }
    public void menuCustomer(){
        System.out.println("======== Choose command ========");
        System.out.println("1. View all product's information");
        System.out.println("2. Find product by id");
        System.out.println("3. View customer's own information");
        System.out.println("4. View customer's own cart");
        System.out.println("5. Edit customer's own cart");
        System.out.println("6. Order product");
        System.out.println("7. View orders");
        System.out.println("8. Edit customer's own information");
        System.out.println("9. Change password");
        System.out.println("10. Sign out");
        System.out.println("0. Exit");
    }
    public void menuEditCustomerInfo(){
        System.out.println("Choose customer's information want to edit");
        System.out.println("1. Name");
        System.out.println("2. Phone");
        System.out.println("3. Address");
        System.out.println("0. Return menu");
    }
    public void menuEditCustomerOwnInfo(){
        System.out.println("Choose customer's information want to edit");
        System.out.println("1. Name");
        System.out.println("2. Phone");
        System.out.println("3. Address");
        System.out.println("4. Balance");
        System.out.println("0. Return menu");
    }
    public void chooseCommandEditInCart(){
        System.out.println("Choose command want to edit in cart");
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("0. Return menu");
    }
    public void confirmEditProductInCart(){
        System.out.println("Do you want to edit product in your cart?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }
    public void confirmOrderMoreProduct(){
        System.out.println("Do you want to order more product");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }
    public void confirmOrder(){
        System.out.println("You sure you want to order these product?");
        System.out.println("1. Confirm");
        System.out.println("2. Cancel");
    }
    public void productManagement(){
        System.out.println("Choose your command:");
        System.out.println("1. Add more product");
        System.out.println("2. Edit product information");
        System.out.println("0. Return menu");
    }
    public void editProductInfo(){
        System.out.println("Choose product information want to edit");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Description");
        System.out.println("4. Quantity");
        System.out.println("0. Return menu");
    }
    // Education view
    public void menuEduAdmin(){
        System.out.println("======== Choose command ========");
        System.out.println("1. View all subjects");
        System.out.println("2. Find subject by ID");
        System.out.println("3. Subject management");
        System.out.println("4. View all student accounts");
        System.out.println("5. Find student by username");
        System.out.println("6. Student management");
        System.out.println("7. View all teacher accounts");
        System.out.println("8. Find teacher by username");
        System.out.println("9. Teacher management");
        System.out.println("10. Change password");
        System.out.println("11. Sign out");
        System.out.println("0. Exit");
    }
    public void subjectManagementEduAdmin(){
        System.out.println("Choose your command: ");
        System.out.println("1. Add subject");
        System.out.println("2. Edit info subject");
        System.out.println("3. Delete subject");
        System.out.println("0. Return menu");
    }
    public void studentManagementEduAdmin(){
        System.out.println("Choose your command");
        System.out.println("1. Create new student account");
        System.out.println("2. Edit student account");
        System.out.println("3. Remove student account");
        System.out.println("0. Return menu");
    }
    public void teacherManagementEduAdmin(){
        System.out.println("Choose your command");
        System.out.println("1. Create new teacher account");
        System.out.println("2. Edit teacher account");
        System.out.println("3. Remove teacher account");
        System.out.println("0. Return menu");
    }
    public void menuTeacher(){
        System.out.println("======== Choose command ========");
        System.out.println("1. View all subject's information");
        System.out.println("2. Find subject by id");
        System.out.println("3. View teacher's own information");
        System.out.println("4. View student list");
        System.out.println("5. Edit student's grade");
        System.out.println("6. Change password");
        System.out.println("7. Sign out");
        System.out.println("0. Exit");
    }
    public void menuStudent(){
        System.out.println("======== Choose command ========");
        System.out.println("1. View all subject's information");
        System.out.println("2. Find subject by id");
        System.out.println("3. View student's own information");
        System.out.println("4. View teacher teach information");
        System.out.println("5. Change password");
        System.out.println("6. Sign out");
        System.out.println("0. Exit");
    }
    public void menuEditInfoSubject(){
        System.out.println("Choose your command: ");
        System.out.println("1. Edit name subject");
        System.out.println("2. Edit number of credit subject");
        System.out.println("3. Edit type subject");
        System.out.println("0. Return admin menu");
    }
    public void menuEditInfoStudent(){
        System.out.println("Choose your command: ");
        System.out.println("1. Change email");
        System.out.println("2. Change password");
        System.out.println("3. Change name");
        System.out.println("4. Change phone number");
        System.out.println("5. Change address");
        System.out.println("6. Change avgScore");
        System.out.println("7. Change teacher");
        System.out.println("0. Return menu");
    }
    public void menuEditInfoTeacher(){
        System.out.println("Choose your command: ");
        System.out.println("1. Change email");
        System.out.println("2. Change password");
        System.out.println("3. Change name");
        System.out.println("4. Change phone number");
        System.out.println("5. Change address");
        System.out.println("6. Change major");
        System.out.println("0. Return menu");
    }
}
