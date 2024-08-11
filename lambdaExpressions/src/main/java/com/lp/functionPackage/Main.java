package com.lp.functionPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = getData();

        printEmployeesByAge(employees, (employee) -> employee.getAge() > 30, "Employees over 30:");
        System.out.println("-".repeat(100));
        printEmployeesByAge(employees, (employee) -> employee.getAge() <= 30, "Employees are or younger than 30:");
        System.out.println("-".repeat(100));
        printEmployeesByAge(employees, new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        }, "Employees are younger than 25:");

        IntPredicate greaterThanFifteen = i -> i > 15;
        IntPredicate lessThanTwenty = i -> i < 20;

        System.out.println(greaterThanFifteen.and(lessThanTwenty).test(14));
        System.out.println(greaterThanFifteen.and(lessThanTwenty).test(17));

        System.out.println("-".repeat(50));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        Function<Employee, String> getLastName = employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1);
        Function<Employee, String> getFirstName = employee -> employee.getName().substring(0, employee.getName().indexOf(' '));
        employees.forEach(employee -> System.out.println(getAName(getLastName, employee)));

        System.out.println("-".repeat(50));

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
        Function<Employee, String> chainedFunction = upperCase.andThen(firstName);
        employees.forEach(employee -> System.out.println(chainedFunction.apply(employee)));

        System.out.println("-".repeat(50));

        BiFunction<String, Integer, String> nameAndAge = (name, age) -> name + " " + age;
        employees.forEach(employee -> System.out.println(nameAndAge.apply(upperCase.apply(employee), employee.getAge())));

        System.out.println("-".repeat(50));

        BiPredicate<String, Integer> isJohnDoe30 = (name, age) -> name.equals("John Doe") && age == 30;
        employees.forEach(employee -> System.out.println(isJohnDoe30.test(employee.getName(), employee.getAge())));

        System.out.println("-".repeat(50));

        BiConsumer<String, Integer> printNameAndAge = (name, age) -> System.out.println(name + " " + age);
        employees.forEach(employee -> printNameAndAge.accept(employee.getName(), employee.getAge()));

        System.out.println("-".repeat(50));

        IntUnaryOperator incByFive = i -> i+5;
        System.out.println(incByFive.applyAsInt(3));


        UnaryOperator<Integer> x = integer -> integer - 3;
        System.out.println("xxxxx -> " + x.apply(3));

        System.out.println("-".repeat(50));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("hello, world!");
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition, String ageText) {
        System.out.println(ageText);
        System.out.println("=".repeat(18));
        employees.forEach(employee -> {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName() + " - " + employee.getAge());
            }
        });
    }

    private static List<Employee> getData() {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Riding", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        return employees;
    }
}
