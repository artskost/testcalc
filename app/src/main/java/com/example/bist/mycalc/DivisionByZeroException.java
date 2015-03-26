package com.example.bist.mycalc;

/**
 * Created by bist on 26.03.2015.
 */
public class DivisionByZeroException  extends  ArithmeticException {

        public DivisionByZeroException() {

        }
         public DivisionByZeroException(String message) {
            super(message);
        }

}
