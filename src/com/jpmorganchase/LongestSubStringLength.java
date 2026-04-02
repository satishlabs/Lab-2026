package com.jpmorganchase;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLength {
    public static void main(String[] args) {
        System.out.println(longestSubsStringLength("aaa"));
        System.out.println("\n================");
        System.out.println(longestSubsStringLength("abcdefacbb"));
    }

    private static int longestSubsStringLength(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength=0;
        for(int i=0; i<str.length(); i++){
            while (set.contains(str.charAt(i))){
                set.remove(str.charAt(i));
                left++;
            }
            set.add(str.charAt(i));
            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;
    }
}
