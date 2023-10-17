package ru.gb.homework03.task02;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MyCalc {

    public static <T extends Number> Number sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> Number subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number> Number multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> Number divide(T a, T b) {
        if (b.intValue() == 0) {
            throw new RuntimeException("Unacceptable division by zero");
        } else {
            return a.doubleValue() / b.doubleValue();
        }
    }

    private static <T extends Number> boolean isBigNum(T a, T b) {
        return  (a instanceof BigInteger || b instanceof BigInteger ||
                a instanceof BigDecimal || b instanceof BigDecimal);
    }
}
