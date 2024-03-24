package utils;

import java.util.regex.Pattern;

public class Validate {

    public boolean ValidatePhoneNumber(String phoneNumber){
        String phoneNumberPattern = "^[0-9]{10}$";
        return Pattern.matches(phoneNumberPattern, phoneNumber);
    }

    public boolean ValidateEmail(String email){
        String emailPattern = "^[\\w]+@([a-z]+\\.[a-z]{3})$";
        return Pattern.matches(emailPattern, email);
    }

    public boolean ValidatePassword(String password){
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[.,_;-@])(?=\\S+$).{7,15}$";
        return Pattern.matches(passwordPattern, password);
    }
}
