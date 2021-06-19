package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver webdriver;
    private By formAuthenticationLink = By.xpath("//a[contains(text(),'Form Authentication')]");
    private By dropDownLink = By.xpath("//a[contains(text(),'Dropdown')]");

    public HomePage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public LoginPage clickFormAuthenticationLink()
    {
        //webdriver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(webdriver);
    }

    public DropDownPage clickDropDownLink() {
        //webdriver.findElement(dropDownLink).click();
        clickLink("Dropdown");
        return new DropDownPage(webdriver);
    }

    private void clickLink(String linkText)
    {
        By genericLink = By.linkText(linkText);
        webdriver.findElement(genericLink).click();
    }
}
