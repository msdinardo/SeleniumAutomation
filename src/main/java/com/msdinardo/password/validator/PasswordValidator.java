package com.msdinardo.password.validator;

public class PasswordValidator {

    public static boolean validate(String password)
    {
        boolean returnValue = false;
        if(password.length() > 5)
        {
            returnValue = true;
        }
        return returnValue;
    }
}
