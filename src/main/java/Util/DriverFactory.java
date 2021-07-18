package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getDriver() throws MalformedURLException {

        WebDriver driver;

        String implicitWait = ConfigReader.getProperty("implicitWait");
        String testEnvironment = ConfigReader.getProperty("testEnvironment");

        if (testEnvironment.equals("remote")) {
            driver = getRemoveDriver();
        } else {
            driver = getLocalDriver();
        }
        //Set Implicit Wait
        long implicitWaitSeconds = Long.parseLong(implicitWait);
        driver.manage().timeouts().implicitlyWait(implicitWaitSeconds, TimeUnit.SECONDS);

        //Maximize
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver getRemoveDriver() throws MalformedURLException {
        //Remote Environment using SeleniumGrid
        WebDriver driver;
        String browserType = ConfigReader.getProperty("browser");
        String seleniumHubURL = ConfigReader.getProperty("seleniumHubURL");
        DesiredCapabilities capabilities;
        switch (browserType) {
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "edge":
                capabilities = DesiredCapabilities.edge();
                break;
            default:
                capabilities = DesiredCapabilities.chrome();
        }
        capabilities.setBrowserName(browserType);
        driver = new RemoteWebDriver(new URL(seleniumHubURL), capabilities);
        return driver;
    }

    private static WebDriver getLocalDriver() {
        WebDriver driver;
        //Local Environment
        String browserType = ConfigReader.getProperty("browser");
        System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("driverChrome"));
        System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("driverFirefox"));
        System.setProperty("webdriver.edge.driver", ConfigReader.getProperty("driverEdge"));
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        return driver;
    }
}
