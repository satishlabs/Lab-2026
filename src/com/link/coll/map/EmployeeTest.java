package com.link.coll.map;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {
    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee e1 = new Employee(101, "Satish");
        Employee e2 = new Employee(102, "Updated Satish");
        Employee e3 = new Employee(101, "Satish");
        map.put(e1, "Developer");
        map.put(e2, "Team Lead");
        map.put(e3, "Sr Developer");

        System.out.println("Size: "+map.size());
        System.out.println("Value: "+map.get(e1));
        System.out.println("Value using e2: "+map.get(e2));
        System.out.println("Value: "+map.get(e3));
    }
}
