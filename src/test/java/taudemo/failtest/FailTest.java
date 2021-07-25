package taudemo.failtest;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import taudemo.BaseTest;

import static org.testng.Assert.assertTrue;

public class FailTest extends BaseTest {

    @Test
    public void failOnPorpuseTest() {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.typeUsername("ItsNotMetomsmith");
        loginPage.typePassword("SuperSecretPassword!");
        SecureAreaPage saPage = loginPage.submitForm();
        String saMessage = saPage.getAlertText();
        //assertEquals(saMessage,"You logged into a secure area!");
        assertTrue(saMessage.contains("You logged into a secure area!"));
    }
}
