package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver webdriver;
    private By messageRibbon = By.cssSelector("#flash");

    public SecureAreaPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public String getAlertText() {
        return webdriver.findElement(messageRibbon).getText();
    }

}
