package com.dsa.list;

import java.util.*;

public class RemoveDuplicateInList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 1, 5);
        List<Integer> result = new ArrayList<>();
        for(Integer num : list){
            if(!result.contains(num)){//Time: O(n²) (because contains() is O(n))
                result.add(num);
            }
        }
        System.out.println(result);

        System.out.println("\n=========================");
        Collections.sort(list);
        result = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(i==0 || !list.get(i).equals(list.get(i-1))){
                result.add(list.get(i));
            }
        }
        System.out.println(result);
        System.out.println("\n=========================");
        Map<Integer, Boolean> map = new HashMap<>();
        result = new ArrayList<>();
        for(Integer num : list){
            if(!map.containsKey(num)){
                map.put(num, true);
                result.add(num);
            }
        }
        System.out.println(result);
        System.out.println("\n=========================");
        list.stream()
                .distinct()
                .toList()
                .forEach(System.out::println);
    }
}
