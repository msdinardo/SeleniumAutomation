package taudemo;

import org.testng.annotations.*;

public class DemoAnotations {

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("BeforeMethod");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("BeforeTest");
    }
    @Test(priority = 1)
    public void ZIamATest(){
        System.out.println("I´m the first test!!!");
    }

    @Test(priority = 2)
    public void AIamASecondTest(){
        System.out.println("I´m the second test!!!");
    }
}
