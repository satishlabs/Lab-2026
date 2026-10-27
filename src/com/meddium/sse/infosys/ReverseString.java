package com.meddium.sse.infosys;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello World"));
        System.out.println(reverseString("Java"));
        System.out.println(reverseString(""));
        System.out.println(reverseString("  Java  "));
        System.out.println("\n====================");
        System.out.println(reverseString1("Hello World"));
        System.out.println(reverseString1("Java"));
        System.out.println(reverseString1(""));
        System.out.println(reverseString1("  Java  "));
    }

    private static String reverseString1(String input) {
        if(input == null || input.isEmpty()){
            return input;
        }

        char[] chars = input.toCharArray();

        int left = 0;
        int right = input.length()-1;
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    public static String reverseString(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return str.toString();
    }
}
