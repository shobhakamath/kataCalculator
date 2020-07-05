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

    /**
     * Utility method to return the new delimiter
     * @param string : the string to find the delimiter matching the condition
     * @return string:the new delimiter if it matches otherwise null
     */
    public static String getNewDelimiter(String string){
        if(string.startsWith("//") && string.substring(3,4).equalsIgnoreCase("\n")){
            return string.substring(2,3);
        }
        return null;
    }
}
