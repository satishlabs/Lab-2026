package com.memoryleak;

import java.util.Scanner;

/**
 * Menu to run each memory-leak demo.
 * Watch printed heap MB climb; GC will not reclaim the retained objects.
 */
public class LeakDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("""
                Java memory-leak demos (heap should grow; GC won't fully reclaim)
                  1) Unbounded static cache
                  2) Listener never unsubscribed
                  3) ThreadLocal on a thread pool (no remove)
                  4) Static session list (no remove on disconnect)
                  5) Non-static inner class held by registry
                  6) Unclosed InputStreams in a loop
                """);
        System.out.print("Choose 1-6: ");
        String choice = args.length > 0 ? args[0] : new Scanner(System.in).nextLine().trim();

        switch (choice) {
            case "1" -> CacheLeak.run();
            case "2" -> ListenerLeak.run();
            case "3" -> ThreadLocalLeak.run();
            case "4" -> SessionListLeak.run();
            case "5" -> InnerClassLeak.run();
            case "6" -> UnclosedStreamLeak.run();
            default -> System.out.println("Unknown choice: " + choice);
        }
    }
}
