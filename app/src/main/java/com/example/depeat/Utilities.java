package com.example.depeat;

import android.util.Patterns;
import android.widget.Toast;

public class Utilities {
    public static boolean controlEmail(String mail){
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }
    public static  boolean controlPhone(String phone){
        return Patterns.PHONE.matcher(phone).matches();
    }
    public static  boolean controlPassword(String password){
        if (password.length() > 6)
            return true;
        else
            return false;
    }

}
