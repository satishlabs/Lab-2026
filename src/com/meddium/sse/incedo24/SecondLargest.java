package com.meddium.sse.incedo24;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10,5,20,8,20,15};
        System.out.println(secondLargest(arr));
        System.out.println("\n======================");
        System.out.println(
                secondLargestDistinct(new int[]{10, 5, 20, 8, 20, 15})
        ); // 15
        System.out.println("\n=======================");
        System.out.println(secondLargestAlternativeWay(arr));
        System.out.println("\n=======================");
        System.out.println(secondLargestOnePassMostEffecient(arr));
    }

    private static Integer secondLargestOnePassMostEffecient(int[] arr) {
        if(arr == null || arr.length < 2)
            return null;

        Integer largest = null;
        Integer second = null;

        for(int num : arr){
            if(largest == null || num > largest){
                second = largest;
                largest = num;
            } else if (num < largest && (second == null || num > second)) {
                second = num;
            }
        }
        return second;
    }

    private static Integer secondLargestAlternativeWay(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] < largest){
                return arr[i];
            }
        }
        return null;
    }

    private static Integer secondLargestDistinct(int[] arr) {
        /*
        Why does the duplicate-handling version work?
1. Remove the largest value, 20.
2. The next value is also 20, so skip it.
3. Continue until finding a value smaller than 20.
4. The first such value is 15, the second-largest distinct element.
5. If no smaller value exists, there is no second-largest distinct element.
        * */
        if(arr == null || arr.length < 2){
            return null;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr){
            maxHeap.offer(num);
        }

        if(maxHeap.isEmpty()){
            return null;
        }

        int largest = maxHeap.poll();
        while(!maxHeap.isEmpty()){
            int current = maxHeap.poll();

            if(current < largest){
                return current;
            }
        }

        return null;
    }

    private static Integer secondLargest(int[] arr) {
        if(arr == null || arr.length < 2){
            return null;
        }

        // Max-heap: largest element comes first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr){
            maxHeap.offer(num);
        }

        // Remove the largest element
        maxHeap.poll();

        return maxHeap.peek();
    }
}
