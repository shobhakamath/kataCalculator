package com.kata.tests;

import com.kata.CalculatorUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class to check the isNumeric utility function
 */
public class CalculatorUtilTest {
    @Test
    public void testIsNumeric(){
        Assert.assertTrue(CalculatorUtil.isNumeric("25"));
        Assert.assertTrue(CalculatorUtil.isNumeric("2.5"));
        Assert.assertTrue(CalculatorUtil.isNumeric("-12"));
        Assert.assertTrue(CalculatorUtil.isNumeric("09"));

        //non numbers check
        Assert.assertFalse(CalculatorUtil.isNumeric(null));
        Assert.assertFalse(CalculatorUtil.isNumeric("25 "));
        Assert.assertFalse(CalculatorUtil.isNumeric("12 3"));
        Assert.assertFalse(CalculatorUtil.isNumeric("12abc"));
        Assert.assertFalse(CalculatorUtil.isNumeric(" "));
        Assert.assertFalse(CalculatorUtil.isNumeric(""));
        Assert.assertFalse(CalculatorUtil.isNumeric("12L"));
        Assert.assertFalse(CalculatorUtil.isNumeric("0xFF"));
        Assert.assertFalse(CalculatorUtil.isNumeric("1.2e+8"));
    }

    @Test
    public void testNewDelimiter(){
        //Checking for length=1 delimiter
        Assert.assertEquals(";",CalculatorUtil.getNewDelimiter("//;\n"));
        Assert.assertEquals(",",CalculatorUtil.getNewDelimiter("//,\n"));
        Assert.assertEquals("~",CalculatorUtil.getNewDelimiter("//~\n"));
        Assert.assertEquals("~",CalculatorUtil.getNewDelimiter("//~\n123"));
    }
}
