package com.kata;

import java.util.regex.Pattern;

public class CalculatorUtil {
    static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    /**
     * @param strNum : the string "number" is checked if its a numeric
     * @return true or false
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
