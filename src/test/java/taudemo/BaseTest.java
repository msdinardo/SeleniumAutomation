package taudemo;

import Util.ConfigReader;
import Util.DriverFactory;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.File;
import java.net.MalformedURLException;

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

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                TakesScreenshot camera = (TakesScreenshot) driver;
                File screenshot = camera.getScreenshotAs(OutputType.FILE);
                File dest = new File("src/test/resources/screenshots/" + result.getName() + ".png");
                System.out.println("The screenshot has been saved in: " + screenshot.getAbsolutePath());
                System.out.println("The screenshot is going to be moved to: " + dest.getAbsolutePath());
                Files.move(screenshot, dest);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
