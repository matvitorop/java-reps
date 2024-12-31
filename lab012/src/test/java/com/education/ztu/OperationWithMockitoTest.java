package com.education.ztu;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OperationWithMockitoTest {

    @Spy
    private Operation operationSpy = new Operation();

    @Mock
    private Operation mockOperation;

    @InjectMocks
    private Operation operationInjectMocks;

    @Captor
    private ArgumentCaptor<int[]> captor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdditionWithSpy() {
        int[] numbers = {1, 2, 3, 4};
        int expectedSum = 10;

        int result = operationSpy.addition(numbers);

        assertEquals(expectedSum, result);

        verify(operationSpy, times(2)).addition(numbers);
    }

    @Test
    public void testSubtractionWithMock() {
        int[] numbers = {10, 5, 2};
        when(mockOperation.subtraction(numbers)).thenReturn(3);

        int result = mockOperation.subtraction(numbers);

        assertEquals(3, result);

        verify(mockOperation, times(1)).subtraction(numbers);
    }

    @Test
    public void testMultiplication() {
        int[] numbers = {2, 3, 4};
        doReturn(24).when(operationSpy).multiplication(numbers);

        int result = operationSpy.multiplication(numbers);

        assertEquals(24, result);

        verify(operationSpy, atLeastOnce()).multiplication(numbers);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        int[] numbers = {10, 0};
        when(mockOperation.division(numbers)).thenThrow(new ArithmeticException("Division by zero is not allowed."));

        mockOperation.division(numbers);

        verify(mockOperation, times(1)).division(numbers);
    }

    @Test
    public void testAverageWithCaptor() {
        int[] numbers = {10, 20, 30, 40};

        when(mockOperation.average(numbers)).thenReturn(25.0);

        double result = mockOperation.average(numbers);

        assertEquals(25.0, result, 0.01);

        verify(mockOperation).average(captor.capture());
        int[] capturedNumbers = captor.getValue();

        assertEquals(4, capturedNumbers.length);
        assertEquals(10, capturedNumbers[0]);
        assertEquals(40, capturedNumbers[3]);
    }

    @Test
    public void testMaximumWithSpy() {
        int[] numbers = {1, 2, 5, 4};
        doReturn(5).when(operationSpy).maximum(numbers);

        int max = operationSpy.maximum(numbers);

        assertEquals(5, max);

        verify(operationSpy, times(1)).maximum(numbers);
    }

    @Test
    public void testMinimumWithMock() {
        int[] numbers = {5, 2, 1, 3};
        when(mockOperation.minimum(numbers)).thenReturn(1);

        int min = mockOperation.minimum(numbers);

        assertEquals(1, min);

        verify(mockOperation, times(1)).minimum(numbers);
    }
}
