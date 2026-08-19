package com.memoryleak;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * REALTIME: open/close dashboard; forget to unsubscribe.
 * VALIDATE: even after "close", Dashboard + 2MB payload stay reachable via EventBus.
 */
public final class ListenerLeak {
    public static void run() throws InterruptedException {
        EventBus bus = new EventBus();
        System.out.println("ListenerLeak: open+close dashboards without unsubscribe");

        int n = 0;
        while (true) {
            Dashboard d = new Dashboard(bus, n++);
            d.open();
            d.closeBroken(); // forgot unsubscribe — LEAK
            if (n % 5 == 0) {
                HeapStats.print("opened=" + n + " listeners=" + bus.listenerCount());
                System.gc();
            }
            Thread.sleep(100);
        }
    }

    static final class EventBus {
        private final List<Consumer<String>> listeners = new ArrayList<>();

        void subscribe(Consumer<String> c) {
            listeners.add(c);
        }

        void unsubscribe(Consumer<String> c) {
            listeners.remove(c);
        }

        int listenerCount() {
            return listeners.size();
        }
    }

    static final class Dashboard {
        private final EventBus bus;
        private final int id;
        private final byte[] screenState = new byte[2 * 1024 * 1024]; // 2 MB
        private final Consumer<String> listener = this::onEvent;

        Dashboard(EventBus bus, int id) {
            this.bus = bus;
            this.id = id;
        }

        void open() {
            bus.subscribe(listener);
        }

        /** Bug: does not unsubscribe */
        void closeBroken() {
            // bus.unsubscribe(listener); // FIX
        }

        private void onEvent(String e) {
            // would refresh UI using screenState
        }
    }
}
