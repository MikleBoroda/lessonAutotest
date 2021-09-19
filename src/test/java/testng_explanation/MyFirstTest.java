package testng_explanation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng_examples.Calculator;

public class MyFirstTest {


    @Test(expectedExceptions = ArithmeticException.class, description = "room")
    public void divideByZeroTest() {
        int a = 4;
        int b = 0;
        Calculator.divide(a, b);
    }

    @DataProvider(name = "calculationsSumDataProvider")
    public static Object[][] calculationSumDataProvider() {
        return new Object[][]{
                {2, 3, 5}, //первоезначние, второе значение, ожидаемый результат
                {-4, 4, 0},
                {7, 8, 15},
                {10, 10, 20}
        };
    }

    @Test(dataProvider = "calculationsSumDataProvider")
    public void simpleCalculationTest(int a, int b, int expectedValue) {

        int actualValue = Calculator.sum(a, b);
        Assert.assertEquals(actualValue, expectedValue, "Проверка суммы чисел 3 + 4 = 7");
    }

}
