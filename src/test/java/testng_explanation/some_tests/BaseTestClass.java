package testng_explanation.some_tests;

import org.testng.annotations.*;

public class BaseTestClass {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BEFORE  SUIT");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BEFORE  CLASS");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BEFORE  METHOD");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After  SUIT");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After  CLASS");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After  METHOD");
    }
}
