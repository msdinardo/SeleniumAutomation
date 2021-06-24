package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage {

    WebDriver driver;
    By targetField = By.id("target");
    By resultLabel = By.id("result");

    public KeyPressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text)
    {
        driver.findElement(targetField).sendKeys(text);
    }

    public String getResult()
    {
        return driver.findElement(resultLabel).getText();
    }
}
