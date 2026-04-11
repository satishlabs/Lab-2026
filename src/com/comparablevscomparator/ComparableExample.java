package com.comparablevscomparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> employeeList = new java.util.ArrayList<>(List.of(
                new Employee(3, "Alice"),
                new Employee(1, "Bob"),
                new Employee(2, "Charlie")
        ));

        Collections.sort(employeeList);//Uses compareTo() method
        employeeList.forEach(System.out::println);

        System.out.println("\n================");
        employeeList.sort((e1,e2)->e1.getName().compareTo(e2.getName()));
        System.out.println("Sorted by Name: " + employeeList);
        System.out.println("\n================");
        employeeList.sort(Comparator.comparing(Employee::getName));
        System.out.println("Sorted by Name (Method Reference): " + employeeList);
        System.out.println("\n================");
        employeeList.sort(Comparator.comparingInt(Employee::getId));
        System.out.println("Sorted by ID: " + employeeList);

    }
}
