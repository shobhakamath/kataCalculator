package com.kata;

import com.kata.exception.CalculatorException;
import com.kata.util.CalculatorUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    static final String SEPARATOR = ",|\n";


    /**
     * @param numbers : numbers is the string being passed
     * @return int : returns an int which is the addition of utmost 2 int values
     */
    public static int Add(String numbers) throws CalculatorException{
        float sum = 0;
        if (numbers != null && numbers.length() > 0) {
            String newDelimiter = CalculatorUtil.getNewDelimiter(numbers);
            String[] split = CalculatorUtil.getFinalString(numbers, newDelimiter).split(SEPARATOR +
                    (newDelimiter != null && newDelimiter.length() > 0 ? "|" + newDelimiter : ""));

            List<Float> lstFloat=new ArrayList<>();
            //The method can take any number of numbers and count them
            for (String str : split) {
                if (CalculatorUtil.isNumeric(str)) {
                    float floatVal=Float.parseFloat(str);
                    if(floatVal<0){
                        lstFloat.add(floatVal);
                    }
                    if(lstFloat.size()==0)
                         sum +=floatVal;

                }
            }
            if(lstFloat.size()>0){
                throw new CalculatorException(String.valueOf(lstFloat));
            }

        }
        return (int) sum;
    }


}
