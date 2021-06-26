package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {

    WebDriver driver;
    By triggerAlertButton = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    By triggerConfirmButton = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    By triggerPromptButton = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    By result = By.id("result");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAlertButton()
    {
        driver.findElement(triggerAlertButton).click();
    }

    public void clickConfirmButton()
    {
        driver.findElement(triggerConfirmButton).click();
    }

    public void clickPromptButton()
    {
        driver.findElement(triggerPromptButton).click();
    }

    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert()
    {
        driver.switchTo().alert().dismiss();
    }

    public void typePrompt(String text)
    {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getAlertGetText()
    {
        return driver.switchTo().alert().getText();
    }

    public String getResult()
    {
        return driver.findElement(result).getText();
    }
}
