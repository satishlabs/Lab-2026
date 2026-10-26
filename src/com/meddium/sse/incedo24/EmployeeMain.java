package com.meddium.sse.incedo24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Satish", "IT", 90000),
                new Employee("Rahul", "IT", 120000),
                new Employee("Priya", "HR", 80000),
                new Employee("Anita", "HR", 95000),
                new Employee("Vijay", "Finance", 110000),
                new Employee("Kiran", "Finance", 100000)
        );
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((department, employee) ->
                        System.out.println(department+" -> "+employee.orElse(null)));
    }
}
