package taudemo;

import Util.ConfigReader;
import Util.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.net.MalformedURLException;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String baseURL = ConfigReader.getProperty("baseURL");
        //driver = new ChromeDriver();
        driver = DriverFactory.getDriver();
        driver.get(baseURL);

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
