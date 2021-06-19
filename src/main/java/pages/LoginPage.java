package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webdriver;
    private By usernameField = By.cssSelector("#username");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void typeUsername(String userName)
    {
        webdriver.findElement(usernameField).sendKeys(userName);
    }

    public void typePassword(String password)
    {
        webdriver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage submitForm()
    {
        webdriver.findElement(loginButton).click();
        return new SecureAreaPage(webdriver);
    }
}
