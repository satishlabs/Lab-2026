package com.meddium.sse.infosys;

public class CheckStringPalindrome {
    public static void main(String[] args) {
        String str = "abbcbba";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome("madam")); // true
        System.out.println(isPalindrome("level")); // true
        System.out.println(isPalindrome("hello")); // false
        System.out.println(isPalindrome(""));      // true

        System.out.println("\n==================");
        /*
        Ignore uppercase, spaces, and punctuation
If the problem says "A man, a plan, a canal: Panama"
        * */
        System.out.println(isPalindromeCheck("A man, a plan, a canal: Panama")); // true

        System.out.println(isPalindromeCheck("RaceCar")); // true
        System.out.println(isPalindromeCheck("hello"));   // false
        System.out.println(isPalindromeCheck("No 'x' in Nixon")); // true
    }

    private static boolean isPalindromeCheck(String str) {
        if(str == null){
            return false;
        }

        int left = 0;
        int right = str.length()-1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }

            while (left< right && !Character.isLetterOrDigit(str.charAt(right))){
                right--;
            }

            char start = Character.toLowerCase(str.charAt(left));
            char end = Character.toLowerCase(str.charAt(right));

            if(start != end){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome(String str) {
        if(str == null || str.isEmpty()){
            return false;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(chars[left] != chars[right]){
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }
}
