package com.meddium.sse.infosys;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindSecondLargestNumberInArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 9, 20, 18};
        int result = secondLargest(arr);
        System.out.println(result);

        System.out.println("\n=================");
        OptionalInt first = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();
        first.ifPresentOrElse(
                value -> System.out.println("Second Largest: "+value),
                () -> System.out.println("No second largest")
        );
    }

    private static Integer secondLargest(int[] arr) {
        Integer largest = null;
        Integer secondLargest = null;
        for(int num : arr){
            if(largest == null || num > largest){
                secondLargest = largest;
                largest = num;
            }else if(num != largest && (secondLargest == null || num >secondLargest)){
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
