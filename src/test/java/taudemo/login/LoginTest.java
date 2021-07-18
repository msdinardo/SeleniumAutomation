package taudemo.login;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import taudemo.BaseTest;

public class LoginTest extends BaseTest {


    @Test
    public void testSucessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.typeUsername("tomsmith");
        loginPage.typePassword("SuperSecretPassword!");
        SecureAreaPage saPage = loginPage.submitForm();
        String saMessage = saPage.getAlertText();
        //assertEquals(saMessage,"You logged into a secure area!");
        assertTrue(saMessage.contains("You logged into a secure area!"));
    }
}
