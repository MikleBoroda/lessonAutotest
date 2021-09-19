package testng_explanation.some_tests;

import org.testng.annotations.Test;

public class TestClassA extends BaseTestClass {
    @Test
    public void testMethod1(){
        System.out.println("CLASS_A METHOD_1");
    }
    @Test
    public void testMethod2(){
        System.out.println("CLASS_A METHOD_2");
    }

    @Test
    public void testMethod3(){
        System.out.println("CLASS_A METHOD_3");
    }

}
