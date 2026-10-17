package com.link.coll.jdk8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMainTest {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Satish", "IT",      25, 80000),
                new Employee(2, "Rahul",  "IT",      32, 95000),
                new Employee(3, "Priya",  "HR",      28, 70000),
                new Employee(4, "Amit",   "HR",      35, 75000),
                new Employee(5, "Neha",   "IT",      29, 95000),
                new Employee(6, "Kiran",  "Finance", 42, 90000),
                new Employee(7, "Anu",    "Finance", 31, 85000),
                new Employee(8, "Vijay",  "IT",      40, 60000)
        );

        //Count employees per department
        long count = employees.stream().count();
        System.out.println(count);
        System.out.println("\n ===Count employees in each department====");
        Map<String, Long> result = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(result);
        System.out.println("\n===Get only employee names per department===");
        Map<String, List<String>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(collect);
        System.out.println("\n===Find the highest-paid employee in each department===");
        Map<String, Optional<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        collect1.forEach((department, employee) ->
                System.out.println(department+" -> "+employee.map(Employee::getName).orElse("None")));
        System.out.println("==========================");
        Map<String, Employee> collect2 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary
                                        )
                                ), Optional::get
                        )
                ));
        System.out.println(collect2);
        System.out.println("====================");
        Map<String, Employee> collect3 = employees.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (e1, e2) -> e1.getSalary() >= e2.getSalary() ? e1 : e2));
        System.out.println(collect3);
        System.out.println("\n===Sort by salary descending, then by name===");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName)
                )
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("====================");
        System.out.println("\n===Age ranges like 20–30 and 30–40 without hardcoding===");

    }
}
