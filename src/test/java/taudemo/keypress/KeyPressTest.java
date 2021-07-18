package taudemo.keypress;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.KeyPressPage;
import taudemo.BaseTest;

import java.security.Key;

public class KeyPressTest extends BaseTest {

    @Test
    public void testEnter()
    {
        KeyPressPage keyPressPage = homePage.clickKeyPressPage();
        keyPressPage.enterText("This is a Test" + Keys.ENTER);
    }
}
