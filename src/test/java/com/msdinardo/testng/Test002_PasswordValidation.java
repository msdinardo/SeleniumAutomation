package com.msdinardo.testng;

import com.msdinardo.password.validator.PasswordValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;



public class Test002_PasswordValidation {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void ValidateShortPassword() {
        boolean valid = PasswordValidator.validate("12345");
        assertFalse(valid);
    }

    @Test
    public void ValidateRegularPassword() {
        boolean valid = PasswordValidator.validate("123456");
        assertTrue(valid);
    }

    @Test
    public void ValidateLongPassword() {
        boolean valid = PasswordValidator.validate("ajsdasdkjashdhashashduashuashuhayusays");
        assertTrue(valid);
    }
}