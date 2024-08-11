package com.lp.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesApp {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("HR");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        List<Employee> allEmployees = departments.stream()
                .flatMap(Department::getEmployees)
                .toList();

        Map<Integer, List<Employee>> employeesGroupedByAge = departments.stream()
                .flatMap(Department::getEmployees)
                .collect(Collectors.groupingBy(Employee::getAge));

        System.out.println("-".repeat(40));

        departments.stream()
                .flatMap(Department::getEmployees)
                .reduce((e1, e2) -> (e1.getAge() <= e2.getAge()) ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();


    }
}
