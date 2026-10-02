package com.link.coll;

import java.util.TreeMap;

public class HeadMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(11, "A");
        treeMap.put(25, "B");
        treeMap.put(33, "C");
        System.out.println(treeMap);
        System.out.println(treeMap.headMap(32));
    }
}
