package com.example.bist.mycalc;

/**
 * Created by bist on 26.03.2015.
 */
public class CalcOperations {

    public static double add (double a, double b) {
        return a + b;
    }

    public static double substract (double a, double b) {
        return a - b;
    }

    public static double multiply (double a, double b) {
        return a * b;
    }

    public static double divide (double a, double b) {
        if (b == 0){
            throw new DivisionByZeroException();
        }
        return a / b;
    }

}
