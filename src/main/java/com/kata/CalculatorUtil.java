package com.kata;

import java.text.MessageFormat;
import java.util.regex.Pattern;

public class CalculatorUtil {

    /**
     * @param strNum : the string "number" is checked if its a numeric
     * @return true or false
     */
    public static boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    /**
     * Utility method to return the new delimiter
     *
     * @param string : the string to find the delimiter matching the condition
     * @return string : the new delimiter if it matches otherwise null
     */
    public static String getNewDelimiter(String string) {
        if (string.startsWith("//") && string.substring(3, 4).equalsIgnoreCase("\n")) {
            return string.substring(2, 3);
        }
        return null;
    }

    /**
     * Returns the string removing the new delimiter string at the start of the string
     * @param string : the string of numbers
     * @param newDelimiter : the new delimiter found
     * @return substring after removal of the new delimiter expression from the start if exists else
     * return the old string
     */
    public static String getFinalString(String string, String newDelimiter) {
        if (newDelimiter != null && string!=null) {
            int strLength = string.length();
            String newString = MessageFormat.format("//{0}\n", newDelimiter);
            if(strLength>=newString.length())
            return string.substring(newString.length(),strLength);
        }
        return string;

    }
}
