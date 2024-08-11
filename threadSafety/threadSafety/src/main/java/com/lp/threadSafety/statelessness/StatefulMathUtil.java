package com.lp.threadSafety.statelessness;

public class StatefulMathUtil {

    private int sum;

    public Integer sum(int num) {
        sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    //sum(10000) -> 50005000
    //sum(20000) -> 200010000
    //sum(30000) -> 450015000
    public static void main(String[] args) {
        StatefulMathUtil util = new StatefulMathUtil();
        Thread t1 = new Thread(() -> System.out.println("Sum of 10000: " + util.sum(10000)));
        Thread t2 = new Thread(() -> System.out.println("Sum of 20000: " + util.sum(20000)));
        Thread t3 = new Thread(() -> System.out.println("Sum of 30000: " + util.sum(30000)));

        t1.start();
        t2.start();
        t3.start();
    }
}
