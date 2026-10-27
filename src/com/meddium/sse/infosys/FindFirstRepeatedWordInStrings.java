package com.meddium.sse.infosys;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFirstRepeatedWordInStrings {
    public static void main(String[] args) {
        String str = "ab abc abc ab  xyz abcd";
        String result = findFirstRepeatedWord(str);
        System.out.println("First Repeated word: "+ result);
        System.out.println("\n=====================");
         result = findFirstNonRepeatedWord(str);
        System.out.println("First Non-Repeated word: "+ result);
        System.out.println("\n=====================");
        System.out.println("\n=====================");
        result = findFirstRepeatedAndNonRepeatedWord(str);
        System.out.println("First Repeated and Non-Repeated word: "+ result);
        System.out.println("\n=====================");
    }

    private static String findFirstRepeatedAndNonRepeatedWord(String str) {
        String[] wrods = str.toLowerCase().trim().split("\\s+");
        LinkedHashMap<String, Long> collect = Arrays.stream(wrods)
                .collect(Collectors.groupingBy(
                        w -> w,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
       String firstNonRepeated =  Arrays.stream(wrods)
                .filter(word -> collect.get(word) == 1)
                .findFirst()
                .orElse(null);

        String firstRepeated =  Arrays.stream(wrods)
                .filter(word -> collect.get(word) > 1)
                .findFirst()
                .orElse(null);
        return "First repeated word: " + firstRepeated
                + ", First non-repeated word: " + firstNonRepeated;
    }

    private static String findFirstNonRepeatedWord(String str) {
        String[] words = str.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                return  entry.getKey();
            }
        }
        return null;
    }

    private static String findFirstRepeatedWord(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = str.split("\\s+");
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for(Map.Entry<String , Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
    }
}
