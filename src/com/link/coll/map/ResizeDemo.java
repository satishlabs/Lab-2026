package com.link.coll.map;

import java.util.HashMap;
import java.util.Map;

public class ResizeDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(4);
        for(int i=1; i<=13; i++){
            map.put(i, "Value" +i);
            System.out.println("Inserted "+i+", size = "+map.size());
        }
    }
}
/*
Step-by-step resizing
Inserted key	Size after insertion	Capacity before resize	Threshold	What happens?
1	            1	                    4	                    3	        No resize
2	            2	                    4	                    3	        No resize
3	            3	                    4	                    3	        No resize
4	            4	                    4	                    3	        Resize: 4 → 8
5	5	8	6	No resize
6	6	8	6	No resize
7	7	8	6	Resize: 8 → 16
8–12	8–12	16	12	No resize
13	13	16	12	Resize: 16 → 32
Notes:

Why does resizing happen?
The threshold is calculated as:
\[
\text{Threshold} = \text{Capacity} \times 0.75
\]

For example, with capacity 4:
\[
4 \times 0.75 = 3
\]

- After inserting 3 entries, the size equals the threshold.
- When the fourth entry is inserted, the size becomes 4, which exceeds the threshold of 3.
- HashMap resizes the table to capacity 8.
The same logic applies at sizes 7 and 13.
* */
