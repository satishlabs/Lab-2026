package com.meddium.sse.infosys;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCountInString {
    public static void main(String[] args) {
        String str ="abbcbba";
        Map<Character, Integer> result = charCountString(str);
        System.out.println(result);
        System.out.println("\n===========");
        Map<Character, Long> result1 = charCountString1(str);
        System.out.println(result1);
    }

    private static Map<Character, Long> charCountString1(String str) {
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    private static Map<Character, Integer>  charCountString(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : str.toCharArray()){
            map.merge(ch, 1, Integer::sum);
        }
        return map;
    }
    /*private static Map<Character, Integer>  charCountString(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for(char ch :  str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        return map;
    }*/
}
