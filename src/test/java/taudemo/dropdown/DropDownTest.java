package taudemo.dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.HomePage;
import taudemo.BaseTest;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTest extends BaseTest{

    WebDriver driver;

    @Test
    public void testSelectDropDown()
    {
        String optionToSelect = "Option 1";
        DropDownPage dropPage = homePage.clickDropDownLink();
        dropPage.selectDropDownOption(optionToSelect);
        List<String> selectedOptions = dropPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1,"Incorrect Number of selections");
        //assertEquals(selectedOptions.get(0),optionToSelect,"Incorrect Selection Item");
        assertTrue(selectedOptions.contains(optionToSelect));
    }

}
