package taudemo.hover;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoverPage;
import taudemo.BaseTest;

import static org.testng.Assert.*;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverUse1()
    {
        HoverPage hoverPage = homePage.clickHoverLink();
        HoverPage.FigureCaption caption = hoverPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(),"The caption is not displayed");
        //assertEquals(caption.getHeader(),"name: user1");
        //assertEquals(caption.getLinkText(),"View profile");
    }



}
