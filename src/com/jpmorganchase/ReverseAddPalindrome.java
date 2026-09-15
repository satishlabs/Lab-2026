package com.jpmorganchase;
/*
Reverse-add palindrome problem.
The Reverse-and-Add Palindrome problem is a common programming/interview problem.

Problem

Given a positive integer:

Reverse its digits.
Add the reversed number to the original number.
Check whether the result is a palindrome.
If not, repeat the process until a palindrome is obtained
Example

Take 87:

87 + reverse(87)
87 + 78 = 165

165 + reverse(165)
165 + 561 = 726

726 + reverse(726)
726 + 627 = 1353

1353 + reverse(1353)
1353 + 3531 = 4884

4884 is a palindrome.
* */

public class ReverseAddPalindrome {
    public static void main(String[] args) {
        long number = 87;

        long result = reverseAndAdd(number);

        System.out.println("Palindrome: " + result);
    }

    private static long reverseAndAdd(long number) {
        while(!isPalindrome(number)){
            number = number + reverse(number);
        }
        return number;
    }

    private static boolean isPalindrome(long number) {
        return  number == reverse(number);
    }

    private static long reverse(long number) {
        long reversed = 0;
        while (number > 0){
            reversed = reversed*10 + number%10;
            number /= 10;
        }
        return  reversed;
    }
}
