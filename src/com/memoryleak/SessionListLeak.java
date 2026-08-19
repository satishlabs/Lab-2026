package com.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 * REALTIME: chat clients connect then disconnect; list never removes them.
 * VALIDATE: SESSIONS size grows; ClientSession count in histogram grows after "disconnect".
 */
public final class SessionListLeak {
    private static final List<ClientSession> SESSIONS = new ArrayList<>();

    public static void run() throws InterruptedException {
        System.out.println("SessionListLeak: connect then disconnect WITHOUT remove");
        int i = 0;
        while (true) {
            ClientSession s = new ClientSession("c-" + (i++), new byte[512 * 1024]); // 0.5 MB
            onConnect(s);
            onDisconnectBroken(s); // should remove — does not
            if (i % 20 == 0) {
                HeapStats.print("connects=" + i + " sessionsStillHeld=" + SESSIONS.size());
                System.gc();
            }
            Thread.sleep(30);
        }
    }

    static void onConnect(ClientSession s) {
        SESSIONS.add(s);
    }

    /** Bug: forgot remove */
    static void onDisconnectBroken(ClientSession s) {
        // SESSIONS.remove(s); // FIX
    }

    public static final class ClientSession {
        final String id;
        final byte[] inboxBuffer;

        ClientSession(String id, byte[] inboxBuffer) {
            this.id = id;
            this.inboxBuffer = inboxBuffer;
        }
    }
}
