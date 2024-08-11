package com.learnprogramming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App1 {

    public static void main(String[] args) {
    }

    private static void openFile() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("File Name: ");
        String fileName = sc.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw e;
        }

    }
}
