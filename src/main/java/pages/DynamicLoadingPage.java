package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

    WebDriver driver;
    By startButton = By.cssSelector("#start button");
    By loadingDiv = By.cssSelector("#loading");
    By startDiv = By.cssSelector("#start");
    By finishDiv = By.cssSelector("#finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExample1()
    {
        By genericLink = By.linkText("Example 1: Element on page that is hidden");
        driver.findElement(genericLink).click();
    }

    public void clickExample2()
    {
        By genericLink = By.linkText("Example 2: Element rendered after the fact");
        driver.findElement(genericLink).click();
    }

    public void clickStartButton()
    {
        driver.findElement(startButton).click();
    }

    public boolean visibleLoading()
    {
        return driver.findElement(loadingDiv).isDisplayed();
    }

    public boolean visibleStart()
    {
        return driver.findElement(startDiv).isDisplayed();
    }

    public boolean visibleFinish()
    {
        return driver.findElement(finishDiv).isDisplayed();
    }

    public String getFinish()
    {
        return driver.findElement(finishDiv).getText();
    }

    public void invisibilityLoading()
    {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingDiv)));
    }
}
