package com.lp;

import com.lp.util.QueryItem;
import com.lp.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printMoreList(students);

        System.out.println("=".repeat(50));

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printMoreList(lpaStudents);

        System.out.println("=".repeat(50));

        testList(List.of("Able", "Barry", "Charlie"));
        testList(List.of(1, 2, 3));
        testList(List.of(1, "Ehab", 3));

        System.out.println("=".repeat(50));

        QueryList<LPAStudent> queryList = new QueryList<>(lpaStudents);
        List<LPAStudent> matches = queryList.getMatches("Course", "Python");
        printMoreList(matches);

        System.out.println("=".repeat(50));

//        QueryList<Employee> empoyeeList = new QueryList<Employee>();
    }

    public static void printMoreList(List<? extends Student> students) {
        students.forEach(student -> System.out.println(student.getYearStarted() + ": " + student));
        System.out.println();
    }

    public static void testList(List<?> list) {
        for (Object element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

//    public static void testList(List<String> list) {
//        for (var element : list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println("String: " + element.floatValue());
//        }
//    }

//    public static <T extends Student> void printList(List<T> students) {
//        students.forEach(student -> System.out.println(student.getYearStarted() + ": " + student));
//        System.out.println();
//    }
}
