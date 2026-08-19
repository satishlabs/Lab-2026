package com.memoryleak;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * REALTIME: batch job opens streams and never closes them; wrappers stay reachable.
 * VALIDATE: list of open streams grows; after GC, streams + buffers remain.
 *
 * Note: this demo deliberately keeps stream refs in a list to show "forgot to close
 * AND kept references". In production, even without a list, native/cleaner delays
 * and other retained wrappers can pressure memory — always use try-with-resources.
 */
public final class UnclosedStreamLeak {
    private static final List<InputStream> OPEN = new ArrayList<>();

    public static void run() throws Exception {
        System.out.println("UnclosedStreamLeak: open streams, never close, keep in static list");
        int i = 0;
        while (true) {
            byte[] data = new byte[1024 * 1024]; // 1 MB payload per "file"
            InputStream in = new ByteArrayInputStream(data);
            // pretend we read a little then abandon without close
            in.read();
            OPEN.add(in); // retained + unclosed
            i++;
            if (i % 10 == 0) {
                HeapStats.print("openStreams=" + OPEN.size());
                System.gc();
            }
            Thread.sleep(50);
        }
    }
}
