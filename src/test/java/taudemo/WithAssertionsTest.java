package taudemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class WithAssertionsTest {

    @Test
    public void firstTest()
    {
        assertEquals(1,1);
    }

    @Test
    public void secondTest()
    {
        assertEquals(10,10);
    }

    @Test
    public void thirdTest()
    {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(10,10);

        sa.assertAll();
    }
}
