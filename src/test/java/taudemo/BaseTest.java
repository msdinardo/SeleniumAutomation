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

    /*public void setUpOld() throws InterruptedException
    {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manuel\\IdeaProjects\\SeleniumAutomation\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        System.getProperty("webdriver.chrome.driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        System.out.println(driver.getTitle());
        WebElement inputLink = driver.findElement(By.xpath("//a[contains(text(),'Inputs')]"));
        inputLink.click();
        Thread.sleep(2000);
        driver.quit();
    }*/

    @BeforeClass
    public void setUp()
    {
        System.getProperty("webdriver.chrome.driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    /*public static void main(String[] args) throws InterruptedException
    {
        BaseTest base = new BaseTest();
        base.setUp();
    }*/
}
