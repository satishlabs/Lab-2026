package com.meddium.sse.infosys;

public class CheckIsNumberPrime {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 7, 9, 17, 1, 0, -5};

        for (int num : numbers) {
            System.out.println(
                    num + " is prime? " + isPrime(num)
            );
        }
    }

    public static boolean isPrime(int num) {
        if(num < 2){
            return false;
        }
         if(num == 2){
             return true;
         }

         if(num%2 == 0){
             return false;
         }
         for(int i = 3; i<= num/i; i+=2 ){
             if(num %i == 0){
                 return false;
             }
         }
         return true;
    }
}
