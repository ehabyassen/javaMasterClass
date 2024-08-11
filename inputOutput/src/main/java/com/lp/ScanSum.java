package com.lp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScanSum {

    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        double sum = 0;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            sc.useLocale(Locale.US);
            while (sc.hasNext()) {
                if (sc.hasNextDouble()) {
                    sum += sc.nextDouble();
                } else {
                    sc.next();
                }
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        System.out.println("Sum: " + sum);
    }
}
