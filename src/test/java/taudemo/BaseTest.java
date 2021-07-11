package taudemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        String propertyDriver = System.getProperty("webdriver.chrome.driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
