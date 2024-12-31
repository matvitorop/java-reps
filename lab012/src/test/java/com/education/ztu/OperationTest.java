package com.education.ztu;

import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OperationTest {
    @Rule
    public TestName testName = new TestName();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public Timeout timeout = new Timeout(2000);

    private static int[] testNumbers;

    private Operation operator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before all tests.");
        testNumbers = new int[]{1, 2, 3, 4};
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After all tests.");
    }

    @Before
    public void setUp() {
        System.out.println("Running test: " + testName.getMethodName());
        operator = new Operation();
    }

    @After
    public void tearDown() {
        System.out.println("Finished test: " + testName.getMethodName());
    }

    @Test
    public void testAddition(){
        assertEquals(10, operator.addition(testNumbers));
    }


    @Test
    public void testSubtraction() {
        assertEquals(-8, operator.subtraction(testNumbers));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        operator.division(4,0);
    }

    @Test
    public void testMaximum() {
        assertEquals(4, operator.maximum(testNumbers));
    }

    @Test
    public void testMinimum() {
        assertEquals(1, operator.minimum(testNumbers));
    }

    @Test
    public void testAverage() {
        assertEquals(2.5, operator.average(testNumbers), 0.01);
    }

    @Test
    public void testFailExample() {
        if (operator.addition(testNumbers) != 10) {
            fail("Addition did not work correctly.");
        }
    }
}
