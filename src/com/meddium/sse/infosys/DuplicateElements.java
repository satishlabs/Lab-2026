package com.meddium.sse.infosys;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 20, 40, 10, 20, 50};

        Set<Integer> duplicates = findDuplicates(arr);
        System.out.println("Duplicate elements: " + duplicates);
        System.out.println("\n===================");
        duplicates = findDuplicates1(arr);
        System.out.println("Duplicate elements: " + duplicates);
        System.out.println("\n===================");
        duplicates = findDuplicates2(arr);
        System.out.println("Duplicate elements: " + duplicates);
    }

    private static Set<Integer> findDuplicates2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        if(arr == null){
            return new HashSet<>();
        }

        for(int num : arr){
            map.merge(num, 1, Integer::sum);
        }
        return map.entrySet()
                .stream()
                .filter(entry ->entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

    }

    private static Set<Integer> findDuplicates1(int[] arr) {
        if(arr == null){
            return new HashSet<>();
        }

        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(arr)
                .filter(num -> !seen.add(num))
                .boxed()
                .collect(Collectors.toSet());
    }

    private static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        if(arr == null){
            return  duplicates;
        }

        for(int num : arr){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }
        return duplicates;
    }
}
