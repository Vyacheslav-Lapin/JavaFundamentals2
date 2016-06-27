package com.epam.training.java.fundamentals.threads.synchronization;

public class StaticSynch {

    @SuppressWarnings("WeakerAccess")
    public static synchronized void a() {
        System.out.println("Line #1 in the method a");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Line #2 in the method a");
    }

    @SuppressWarnings("WeakerAccess")
    public static synchronized void b() {
        System.out.println("Line #1 in the method b");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Line #2 in the method b");
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> { a(); b(); };
        Thread[] threads = { new Thread(r), new Thread(r), new Thread(r), new Thread(r) };

        for (Thread thread: threads)
            thread.start();
    }

}
