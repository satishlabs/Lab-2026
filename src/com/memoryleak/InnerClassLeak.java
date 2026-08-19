package com.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 * REALTIME: metrics registry keeps Reporter; non-static inner class pins OrderService.
 * VALIDATE: after "discarding" OrderService references, heap still holds bigConfig via registry.
 */
public final class InnerClassLeak {
    private static final List<Runnable> REGISTRY = new ArrayList<>();

    public static void run() throws InterruptedException {
        System.out.println("InnerClassLeak: registry retains non-static Reporter -> OrderService");
        int i = 0;
        while (true) {
            OrderService svc = new OrderService(i++);
            svc.start(); // registers inner Reporter
            // local svc goes out of scope — but REGISTRY keeps Reporter -> outer instance
            if (i % 5 == 0) {
                HeapStats.print("servicesStarted=" + i + " reporters=" + REGISTRY.size());
                System.gc();
            }
            Thread.sleep(150);
        }
    }

    static final class OrderService {
        private final int id;
        private final byte[] bigConfig = new byte[3 * 1024 * 1024]; // 3 MB

        OrderService(int id) {
            this.id = id;
        }

        void start() {
            REGISTRY.add(new Reporter()); // non-static inner class
        }

        class Reporter implements Runnable {
            @Override
            public void run() {
                System.out.println("report " + id + " cfgBytes=" + bigConfig.length);
            }
        }
    }
}
