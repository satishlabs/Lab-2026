package com.meddium.sse.infosys;

import static com.meddium.sse.infosys.CheckIsNumberPrime.isPrime;

public class PrintAllPrime {
    public static void main(String[] args) {
        int m=2, n= 15;
        for(int i=m; i<=n; i++){
           if(isPrime(i)){
               System.out.println(i+" ");
           }
        }
    }
}
