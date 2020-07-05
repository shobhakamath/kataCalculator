package com.kata.exception;

public class CalculatorException extends Exception{
    public CalculatorException(String s) {
        super("negatives not allowed " + s);
    }
}
