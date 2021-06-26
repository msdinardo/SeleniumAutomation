package taudemo.alert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.HomePage;
import taudemo.BaseTest;

import static org.testng.Assert.*;

public class AlertTest extends BaseTest {

    @BeforeMethod
    public void initializeTests()
    {
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    public void validateAlert()
    {
        HomePage homePage = new HomePage(driver);
        AlertPage alertPage = homePage.clickAlertPage();
        alertPage.clickAlertButton();
        String alertText = alertPage.getAlertGetText();
        assertEquals(alertText,"I am a JS Alert");
        alertPage.acceptAlert();
        String resultMessage = alertPage.getResult();
        assertEquals(resultMessage,"You successfully clicked an alert");
    }

    @Test
    public void validateConfirm()
    {
        String expectedResult = "You clicked: Ok";
        HomePage homePage = new HomePage(driver);
        AlertPage alertPage = homePage.clickAlertPage();
        alertPage.clickConfirmButton();
        String alertText = alertPage.getAlertGetText();
        assertEquals(alertText,"I am a JS Confirm");
        alertPage.acceptAlert();
        String resultMessage = alertPage.getResult();
        assertEquals(resultMessage,expectedResult);
    }

    @Test
    public void cancelConfirm()
    {
        String expectedResult = "You clicked: Cancel";
        HomePage homePage = new HomePage(driver);
        AlertPage alertPage = homePage.clickAlertPage();
        alertPage.clickConfirmButton();
        String alertText = alertPage.getAlertGetText();
        assertEquals(alertText,"I am a JS Confirm");
        alertPage.dismissAlert();
        String resultMessage = alertPage.getResult();
        assertEquals(resultMessage,expectedResult);
    }

    @Test
    public void typePrompt()
    {
        String textToType = "This is a new test";
        HomePage homePage = new HomePage(driver);
        AlertPage alertPage = homePage.clickAlertPage();
        alertPage.clickPromptButton();
        String alertText = alertPage.getAlertGetText();
        assertEquals(alertText,"I am a JS prompt");
        alertPage.typePrompt(textToType);
        alertPage.acceptAlert();
        String resultMessage = alertPage.getResult();
        boolean resultValue = resultMessage.contains(textToType) ? true : false;
        assertTrue(resultValue);
    }
}
