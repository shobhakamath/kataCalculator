package com.kata.util;

import com.kata.exception.CalculatorException;

import java.text.MessageFormat;
import java.util.Arrays;
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
    public static String[] getNewDelimiter(String string) {

        if (string.startsWith("//[")) {
            int indexOfSlashN = string.indexOf("\n");
            if (indexOfSlashN != -1) {

                String s = string.substring(2, indexOfSlashN);
                String[] splits = s.split("\\]\\[");
                int i=0;
                String[] str = new String[splits.length];
                for (String split : splits) {
                    if(split.startsWith("["))
                        str[i++]=(split.substring(1));
                        else if(split.endsWith("]"))
                        str[i++]=split.substring(0,split.length()-1);
                        else
                        str[i++]=split;

                }
                return str;
            }

        } else if (string.startsWith("//")) {
            String[] str = new String[1];
            int indexOfSlashN = string.indexOf("\n");
            if (indexOfSlashN != -1) {
                str[0] = string.substring(2, indexOfSlashN);
                return str;
            }
        }
        return null;
    }

    /**
     * Returns the string removing the new delimiter string at the start of the string
     *
     * @param string       : the string of numbers
     * @param newDelimiter : the new delimiter found
     * @return substring after removal of the new delimiter expression from the start if exists else
     * return the old string
     */
    public static String getFinalString(String string, String newDelimiter[]) {
        if (newDelimiter != null && string != null) {
            int strLength = string.length();
            int indexOfSlashN = string.indexOf("\n");
            if (indexOfSlashN != -1)
                return string.substring(indexOfSlashN+1, strLength);
        }
        return string;
    }

    /**
     * Utility for formatting the dangling metacharacters
     *
     * @param newDelimiter the delimiter
     * @return the formatted delimiter
     */
    public static String formatDelimiter(String[] newDelimiter) {

        StringBuilder finalFormat = new StringBuilder();
        for (String delimiter : newDelimiter) {
            if(finalFormat.length()>0){
                finalFormat.append("|");
            }
            for (String s : delimiter.split("")) {

                if ("+*^".contains(s)) {
                    finalFormat.append("\\").append(s);
                } else {
                    finalFormat.append(delimiter);

                }
            }

        }
        return finalFormat.toString();
    }

}
