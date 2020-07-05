package com.kata;

public class Calculator {
    static final String SEPARATOR = ",|\n";

    /**
     * @param numbers : numbers is the string being passed
     * @return int : returns an int which is the addition of utmost 2 int values
     */
    public static int Add(String numbers) {
        float sum = 0;
        if (numbers != null && numbers.length() > 0) {
            String[] split = numbers.split(SEPARATOR);
            //The method can take any number of numbers and count them
            for (String str:split) {
                if (CalculatorUtil.isNumeric(str)) {
                    sum += Float.parseFloat(str);
                }
            }

        }
        return (int) sum;
    }


}
