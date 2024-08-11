package com.lp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer num : others) {
            int cmp = five.compareTo(num);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (cmp == 0) ? "=" : (cmp > 0) ? ">" : "<", num, cmp);
        }

        System.out.println("=".repeat(50));

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        for (String s : fruit) {
            int cmp = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana, (cmp == 0) ? "=" : (cmp > 0) ? ">" : "<", s, cmp);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("A:" + (int) 'A' + ", a:" + (int) 'a');
        System.out.println("B:" + (int) 'B' + ", b:" + (int) 'b');
        System.out.println("P:" + (int) 'P' + ", p:" + (int) 'p');


        System.out.println("=".repeat(50));

        Student tim = new Student("Tim");
        Student[] studnets = {new Student("Zach"), new Student("Tim"), new Student("Ann")};

        Arrays.sort(studnets, new StudentGPAComparator().reversed());
//        Arrays.sort(studnets);
        System.out.println(Arrays.toString(studnets));

        System.out.println("result = " + tim.compareTo(new Student("TIM")));
    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();
    String name;
    private final int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(id, o.id);
    }

//    @Override
//    public int compareTo(Object o) {
//        Student st = (Student) o;
//        return name.compareTo(st.name);
//    }
}

