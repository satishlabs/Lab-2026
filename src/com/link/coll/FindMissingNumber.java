package com.link.coll;
/*
#Delloite.  👀
𝗣𝗿𝗼𝗯𝗹𝗲𝗺 𝗦𝘁𝗮𝘁𝗲𝗺𝗲𝗻𝘁:- Find the missing number(s) from an integer array considering the minimum and maximum numbers in that array, the array is not guaranteed to be sorted.
𝗧𝗲𝘀𝘁𝗰𝗮𝘀𝗲𝘀:-
𝗜𝗻𝗽𝘂𝘁 - { 2, 3, 3, 3, 4, 4, 5, 7, 8, 9, 1 }
𝗢𝘂𝘁𝗽𝘂𝘁 - 6
𝗘𝘅𝗽𝗹𝗮𝗻𝗮𝘁𝗶𝗼𝗻 - 1 is the min, 9 is the max, so the range we should be checking is 1 to 9, all numbers between 1 to 9 are present except 6
*/

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingNumber {
    public static void main(String[] args) {
        int array[] = {2, 3, 3, 3, 4, 4, 5, 7, 8, 9, 1};
        Set<Integer> set = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet());
        //Check if the set contains all elements in the range
        List<Integer> list = IntStream.rangeClosed(1, 9)
                .filter(i -> !set.contains(i))
                .boxed().toList();

        list.forEach(System.out::println);
    }
}
