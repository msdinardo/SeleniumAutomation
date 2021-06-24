package taudemo.keypress;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.KeyPressPage;

import java.security.Key;

public class KeyPressTest {

    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        System.getProperty("webdriver.chrome.driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    public void testEnter()
    {
        HomePage homePage = new HomePage(driver);
        KeyPressPage keyPressPage = homePage.clickKeyPressPage();
        keyPressPage.enterText("This is a Test" + Keys.ENTER);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
