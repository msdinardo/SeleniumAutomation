package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormatSymbols;

public class HSliderPage {

    WebDriver driver;
    By range = By.cssSelector("input[type='range']");
    By rangeValue = By.id("range");

    public HSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveUntilNumber(int number)
    {
        number = number < 0 ? 0 : number;
        number = number > 5 ? 5 : number;
        //DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        //symbols.setDecimalSeparator('.');

        float value = Float.parseFloat(driver.findElement(rangeValue).getText());
        while(value < number)
        {
            driver.findElement(range).sendKeys(Keys.ARROW_RIGHT);
            value = Float.parseFloat(driver.findElement(rangeValue).getText());
        }
    }

    public float getRangeValue()
    {
        return Float.parseFloat(driver.findElement(rangeValue).getText());
    }

    public void refresh()
    {
        driver.navigate().refresh();
    }



}
