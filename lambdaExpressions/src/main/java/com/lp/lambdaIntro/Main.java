package com.lp.lambdaIntro;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee johnDoe = new Employee("John Doe", 30);
        Employee timBuchalka = new Employee("Tim Buchalka", 21);
        Employee jackHill = new Employee("Jack Hill", 40);
        Employee snowWhite = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(johnDoe);
        employees.add(timBuchalka);
        employees.add(jackHill);
        employees.add(snowWhite);

        employees.forEach(employee -> {
            System.out.print(employee.getName() + " ");
            System.out.println(employee.getAge());
        });

    }

    public static String upperConcat(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {


    public String doSomething() {
        int i = 0;
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            return s1.toUpperCase() + s2.toUpperCase();
        };

        System.out.println("AnotherClass name is: " + getClass().getSimpleName());
        return Main.upperConcat(uc, "String1", "String2");
    }

    public void printValue() {
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
    }
}
