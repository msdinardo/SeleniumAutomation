package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage {

    private WebDriver driver;
    private By dropdown = By.cssSelector("#dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDropDownOption(String option)
    {
        Select dropDownElement = new Select(driver.findElement(dropdown));
        dropDownElement.selectByVisibleText(option);
    }

    public List<String> getSelectedOptions()
    {
        Select dropDownElement = new Select(driver.findElement(dropdown));
        List<WebElement> selectedOptions = dropDownElement.getAllSelectedOptions();
        List<String> returnValues = new ArrayList<String>();
        for(WebElement element : selectedOptions)
        {
            returnValues.add(element.getText());
        }
        return returnValues;
    }
}
