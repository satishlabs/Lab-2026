package com.link.coll;

public class IndexOfDemo {
    public static void main(String[] args) {
        String email = "developer@gmail.com";
        int position = email.indexOf('@');
        System.out.println(position);
        String emailPrefix = email.substring(0,position);
        System.out.println("Email Prefix: "+emailPrefix);
    }
}
