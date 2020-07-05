package com.kata.tests;

import com.kata.Calculator;
import com.kata.exception.CalculatorException;
import org.junit.Assert;
import org.junit.Test;

/**
 * The main test class for the step 1 of the test
 */
public class CalculatorTest {
    @Test
    public void testEmptyString() throws CalculatorException {
        Assert.assertEquals(0, Calculator.Add(""));
    }

    @Test
    public void test_StringLength1() throws CalculatorException {
        Assert.assertEquals(1, Calculator.Add("1"));
    }

    @Test
    public void test_StringLength2() throws CalculatorException {
        Assert.assertEquals(3, Calculator.Add("1,2"));
    }

    @Test
    public void test_StringLength3() throws CalculatorException {
        Assert.assertEquals(6, Calculator.Add("1,2,3"));
    }

    @Test
    public void test_passString() throws CalculatorException {
        Assert.assertEquals(5, Calculator.Add("A,2,3"));
    }

    @Test
    public void test_passFloat() throws CalculatorException {
        Assert.assertEquals(5, Calculator.Add("A,2.5,3"));
    }

    @Test
    public void test_passNull() throws CalculatorException {
        Assert.assertEquals(2, Calculator.Add("A,2.5,null"));
    }

    @Test(expected = CalculatorException.class)
    public void test_passNegative() throws CalculatorException {
        Assert.assertEquals(0, Calculator.Add("0,-2.5,3"));
        Assert.assertEquals(9, Calculator.Add("09\n-2.5\n3"));
        Assert.assertEquals(0, Calculator.Add("09\\n-2.5\\n3"));
        Assert.assertEquals(3, Calculator.Add("09/\n-2.5/\n3"));
    }

    @Test(expected = CalculatorException.class)
    public void test_passLeading0() throws CalculatorException {
        Assert.assertEquals(9, Calculator.Add("09,-2.5,3"));
    }

    @Test(expected = CalculatorException.class)
    public void test_passManyNumbers() throws CalculatorException {
        Assert.assertEquals(2959488, Calculator.Add("09,-2.5,3,6,7,4,09,87,233,2334234,565,567567,56767"));
    }

    @Test(expected = CalculatorException.class)
    public void test_SmallestNumberAnIntegerCanHold() throws CalculatorException {
        Assert.assertEquals(-2147483648, Calculator.Add("-2147483647,-7,-90,-89"));
    }

    @Test
    public void test_BiggestNumberAnIntegerCanHold() throws CalculatorException {
        Assert.assertEquals(849, Calculator.Add("2147483647,78,89,34"));
    }


    @Test
    public void testAllowNewDelimiter() throws CalculatorException {
        Assert.assertEquals(6, Calculator.Add("1\n2,3"));
    }

    @Test
    public void testNewLineNumbers() throws CalculatorException {
        Assert.assertEquals(1, Calculator.Add("1,\n"));
        Assert.assertEquals(3, Calculator.Add("1,\n2"));
        Assert.assertEquals(2, Calculator.Add("1;,\n2"));

    }

    @Test
    public void testNewDelimiter() throws CalculatorException {
        Assert.assertEquals(0, Calculator.Add("//;\n"));
        Assert.assertEquals(3, Calculator.Add("//;\n1;2"));
        Assert.assertEquals(9, Calculator.Add("//;\n1;2\n6"));
        Assert.assertEquals(99, Calculator.Add("//;\n091;2\n6"));
    }

    @Test
    public void tesException() {
        try {
            Calculator.Add("//;\n-5;-10");
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals("negatives not allowed [-5.0, -10.0]", e.getMessage());
        }

    }

    @Test
    public void tesGreaterThan1000() throws CalculatorException{
        Assert.assertEquals(99, Calculator.Add("//;\n091;2\n1006"));
    }
}
