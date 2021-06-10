package taudemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manuel\\IdeaProjects\\SeleniumAutomation\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        System.getProperty("webdriver.chrome.driver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public void afterAll() {
        driver.close();
    }

    @Test
    public void openThePageAndCheckTheTitleFail() {
        String expectedValue = "Expected Value";
        driver.get("https:www.amazon.com");
        String pageTitle = driver.getTitle();
        assertNotEquals(pageTitle, expectedValue);
    }

    @Test
    public void openThePageAndCheckTheTitlePass() {
        String expectedValue = "Amazon.com. Spend less. Smile more.";
        driver.get("https:www.amazon.com");
        String pageTitle = driver.getTitle();
        assertEquals(pageTitle, expectedValue);
    }
}
