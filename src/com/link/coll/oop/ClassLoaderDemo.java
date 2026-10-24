package com.link.coll.oop;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        // Bootstrap ClassLoader
        System.out.println("String: "+String.class.getClassLoader());

        // Platform ClassLoader
        System.out.println("Platform: "+ ClassLoader.class.getClassLoader());

        // Application/System ClassLoader
        System.out.println("Application: "+ClassLoader.getSystemClassLoader());

        // ClassLoader that loaded this application class
        System.out.println(
                "ClassLoaderDemo: " +
                        ClassLoaderDemo.class.getClassLoader()
        );

        // Parent of the application class loader
        System.out.println(
                "Application parent: " +
                        ClassLoader.getSystemClassLoader().getParent()
        );

    }
}
