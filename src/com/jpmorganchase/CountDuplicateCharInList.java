package com.jpmorganchase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharInList {
    public static void main(String[] args) {
        List<String> list = List.of("a","b","c","d","a","d","a");
       Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
       map.forEach((k,v)-> System.out.println(k+" : "+v));
    }
}
