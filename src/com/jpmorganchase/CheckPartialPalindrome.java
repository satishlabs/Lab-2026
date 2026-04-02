package com.jpmorganchase;

public class CheckPartialPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca")); // true
        System.out.println(validPalindrome("abc"));  // false
    }

    private static boolean validPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                return isPalindrome(str, left+1, right) || isPalindrome(str, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
