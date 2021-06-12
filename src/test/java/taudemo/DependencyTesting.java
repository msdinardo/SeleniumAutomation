package taudemo;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DependencyTesting {
    @Test(groups = "smoke")
    public void test3_firstTest()
    {
        assertEquals(1,1);
    }

    @Test(groups = "smoke")
    public void test4_secondTest()
    {
        assertEquals(1,2);
    }

    @Test(dependsOnGroups = "smoke",groups = "regression")
    public void test1_thirdTest()
    {
        assertEquals(1,1);
    }

    @Test(dependsOnGroups = "smoke",groups = "regression")
    public void test2_fourthTest()
    {
        assertEquals(1,1);
    }
}
