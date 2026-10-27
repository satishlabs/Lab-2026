package com.meddium.sse.infosys;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 10, 30, 20, 40, 30};

        int[] array = Arrays.stream(numbers)
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(array));
    }
}
