package taudemo.HorizontalSlider;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HSliderPage;
import pages.HomePage;
import taudemo.BaseTest;

public class HorizontalSlider extends BaseTest {

    @BeforeMethod
    public void resetTest()
    {
        driver.get("https://the-internet.herokuapp.com");
    }


    @Test
    public void testFive()
    {
        HomePage homePage = new HomePage(driver);
        HSliderPage hSliderPage = homePage.clickHorizontalSlider();
        hSliderPage.moveUntilNumber(5);
        Assert.assertEquals(hSliderPage.getRangeValue(),5);
    }

    @Test
    public void testFour()
    {
        HomePage homePage = new HomePage(driver);
        HSliderPage hSliderPage = homePage.clickHorizontalSlider();
        hSliderPage.moveUntilNumber(4);
        Assert.assertEquals(hSliderPage.getRangeValue(),4);
    }

}
