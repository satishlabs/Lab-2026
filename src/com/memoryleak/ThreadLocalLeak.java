package com.memoryleak;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * REALTIME: web filter sets ThreadLocal user; pool threads reuse; no remove().
 * VALIDATE: after tasks finish + GC, heap stays high; histogram shows LeakyUser.
 */
public final class ThreadLocalLeak {
    private static final ThreadLocal<LeakyUser> CURRENT = new ThreadLocal<>();

    public static void run() throws InterruptedException {
        System.out.println("ThreadLocalLeak: 8 pool threads keep ThreadLocal users forever");
        ExecutorService pool = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 200; i++) {
            final int req = i;
            pool.submit(() -> {
                // simulate request start
                CURRENT.set(new LeakyUser("user-" + req, new byte[1024 * 1024])); // 1 MB
                // BUG: missing CURRENT.remove() in finally
                // work...
            });
        }

        pool.shutdown();
        pool.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println("All tasks done. Forcing GC — leaked ThreadLocals remain on pool threads.");
        for (int t = 0; t < 20; t++) {
            System.gc();
            HeapStats.print("post-tasks tick=" + t);
            Thread.sleep(500);
        }
        // keep process alive so you can jcmd histogram
        System.out.println("Still alive for inspection. Ctrl+C to stop.");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static final class LeakyUser {
        final String name;
        final byte[] profileBlob;

        LeakyUser(String name, byte[] profileBlob) {
            this.name = name;
            this.profileBlob = profileBlob;
        }
    }
}
