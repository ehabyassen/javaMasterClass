package com.concurrencyJJ.locks.reentrantLock;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Calculation> calculations = List.of(new Addition(5), new Addition(3), new Subtraction(6));
        calculator.calculate(calculations);
        System.out.println(calculator.getResult());
    }
}
