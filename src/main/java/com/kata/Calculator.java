package com.kata;

public class Calculator {
    static final String SEPARATOR = ",";

    /**
     * @param numbers : numbers is the string being passed
     * @return int : returns an int which is the addition of utmost 2 int values
     */
    public static int Add(String numbers) {
        int sum = 0;
        if (numbers != null && numbers.length() > 0) {
            String[] split = numbers.split(SEPARATOR);
            //The method can take up to two numbers;hence i<2
            for (int i = 0, j = 0; i < split.length && j < 2; i++) {
                if (CalculatorUtil.isNumeric(split[i])) {
                    sum += Float.parseFloat(split[i]);
                    j++;
                }
            }

        }
        return sum;
    }


}
