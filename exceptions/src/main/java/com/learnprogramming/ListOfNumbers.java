package com.learnprogramming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(i);
    }

    public static void main(String[] args) {
        new ListOfNumbers().readList();
    }

    public void readList() {
        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                list.add(Integer.parseInt(reader.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Could not cast the following entry to an integer. " + e.getMessage());
        }

        System.out.println(list);
    }

    public static void cat(File file) {
        RandomAccessFile input = null;
        String line;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not open of find file [" + file.getName() + "]. " + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}