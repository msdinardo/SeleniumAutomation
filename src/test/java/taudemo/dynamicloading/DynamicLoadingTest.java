package taudemo.dynamicloading;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.HomePage;
import taudemo.BaseTest;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testDynamicLoagingHidden()
    {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample1();
        //Validate Start Visible
        assertEquals(dynamicLoadingPage.visibleStart(),true);

        //Click Start and Validate Status
        dynamicLoadingPage.clickStartButton();
        assertEquals(dynamicLoadingPage.visibleStart(),false);
        assertEquals(dynamicLoadingPage.visibleLoading(),true);
        assertEquals(dynamicLoadingPage.visibleFinish(),false);

        //Wait for the Button to Dissapear
        dynamicLoadingPage.invisibilityLoading();

        assertEquals(dynamicLoadingPage.visibleStart(),false);
        assertEquals(dynamicLoadingPage.visibleLoading(),false);
        assertEquals(dynamicLoadingPage.visibleFinish(),true);

        assertEquals(dynamicLoadingPage.getFinish(),"Hello World!");
    }

    @Test
    public void testDynamicLoadingRender()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        dynamicLoadingPage.clickExample2();
        //Validate Start Visible
        assertEquals(dynamicLoadingPage.visibleStart(),true);
        dynamicLoadingPage.clickStartButton();

        driver.findElement(By.cssSelector("#finish"));

        assertEquals(dynamicLoadingPage.visibleStart(),false);
        assertEquals(dynamicLoadingPage.visibleLoading(),false);
        assertEquals(dynamicLoadingPage.visibleFinish(),true);
    }

    @BeforeMethod
    public void beforeMethod()
    {
        driver.get("https://the-internet.herokuapp.com");
    }
}
