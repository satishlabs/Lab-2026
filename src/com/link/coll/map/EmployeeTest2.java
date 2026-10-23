package com.link.coll.map;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest2 {
    //overriding equals() but not hashCode()
    public static void main(String[] args) {
        Map<Employee2, String> map = new HashMap<>();

        Employee2 e1 = new Employee2(101, "Satish");
        Employee2 e2 = new Employee2(101, "Rahul");

        System.out.println(e1.equals(e2)); // true

        map.put(e1, "Developer");

        System.out.println(map.get(e2));   // Usually null
    }
}
