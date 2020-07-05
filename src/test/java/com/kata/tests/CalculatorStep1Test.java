package com.kata.tests;

import com.kata.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorStep1Test {
    @Test
    public void testEmptyString(){
        Assert.assertEquals(0, Calculator.Add(""));
    }

    @Test
    public void test_StringLength1(){
        Assert.assertEquals(1,Calculator.Add("1"));
    }
    @Test
    public void test_StringLength2(){
        Assert.assertEquals(3,Calculator.Add("1,2"));
    }
    @Test
    public void test_StringLength3(){
        Assert.assertEquals(3,Calculator.Add("1,2,3"));
    }
    @Test
    public void test_passString(){
        Assert.assertEquals(5,Calculator.Add("A,2,3"));
    }
    @Test
    public void test_passFloat(){
        Assert.assertEquals(3,Calculator.Add("A,2.5,3"));
    }
    @Test
    public void test_passNull(){
        Assert.assertEquals(0,Calculator.Add("A,2.5,"));
    }
}
