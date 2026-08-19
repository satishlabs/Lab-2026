package com.memoryleak;

/** Shared heap printer for every demo. */
public final class HeapStats {
    private HeapStats() {}

    public static void print(String label) {
        Runtime rt = Runtime.getRuntime();
        long used = (rt.totalMemory() - rt.freeMemory()) / (1024 * 1024);
        long total = rt.totalMemory() / (1024 * 1024);
        long max = rt.maxMemory() / (1024 * 1024);
        System.out.printf("used=%4d MB  total=%4d MB  max=%4d MB  | %s%n", used, total, max, label);
    }
}
