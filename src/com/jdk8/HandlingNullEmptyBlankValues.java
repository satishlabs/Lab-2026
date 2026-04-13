package com.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HandlingNullEmptyBlankValues {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Satish","Kumar","Prasad",null,"");
       List<String> words =  list.stream()
                .filter(Objects::nonNull)
                .filter(word -> !word.isBlank())
                .toList();
        System.out.println(words);
    }
}
