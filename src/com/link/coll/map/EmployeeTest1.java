package com.link.coll.map;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest1 {
    //Different keys with the same hash code
    public static void main(String[] args) {
        Map<Employee1, String> map = new HashMap<>();

        map.put(new Employee1(101, "Satish"), "Developer");
        map.put(new Employee1(102, "Rahul"), "Tester");
        map.put(new Employee1(103, "Priya"), "Architect");

        System.out.println("Size: " + map.size());
        System.out.println(
                map.get(new Employee1(102, "Rahul"))
        );
    }
}
