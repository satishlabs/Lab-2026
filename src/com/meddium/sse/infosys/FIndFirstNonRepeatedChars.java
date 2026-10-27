package com.meddium.sse.infosys;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FIndFirstNonRepeatedChars {
    public static void main(String[] args) {
        String str = "abbcbba";

        Character result = findFirstNonRepeatedChar(str);

        System.out.println("First non-repeated character: " + result);

        System.out.println("\n==================");
         result = findFirstRepeatedChar(str);

        System.out.println("First repeated character: " + result);

        System.out.println("\n==================");
        result = findFirstRepeatedChar2(str);

        System.out.println("First non-repeated character: " + result);
    }

    private static Character findFirstRepeatedChar2(String str) {
        LinkedHashMap<Character, Long> collect = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        return collect.entrySet().stream()
                .filter(enrty -> enrty.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private static Character findFirstRepeatedChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.merge(ch, 1, Integer::sum);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }
        return null;
    }

    private static Character findFirstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
