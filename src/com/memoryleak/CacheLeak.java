package com.memoryleak;

import java.util.HashMap;
import java.util.Map;

/**
 * REALTIME: product API caches every id forever.
 * VALIDATE: heap MB climbs; after GC, LeakyProduct / byte[] stay in histogram.
 */
public final class CacheLeak {
    private static final Map<String, LeakyProduct> CACHE = new HashMap<>();

    public static void run() throws InterruptedException {
        System.out.println("CacheLeak: adding ~1MB products forever into static CACHE");
        int i = 0;
        while (true) {
            String id = "p-" + (i++);
            CACHE.put(id, new LeakyProduct(id, new byte[1024 * 1024])); // 1 MB each
            if (i % 10 == 0) {
                HeapStats.print("cache size=" + CACHE.size());
                System.gc(); // proves GC cannot free CACHE contents
            }
            Thread.sleep(50);
        }
    }

    public static final class LeakyProduct {
        final String id;
        final byte[] payload;

        LeakyProduct(String id, byte[] payload) {
            this.id = id;
            this.payload = payload;
        }
    }
}
