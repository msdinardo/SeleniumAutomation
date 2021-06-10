package taudemo;

import org.testng.annotations.Test;

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
}
