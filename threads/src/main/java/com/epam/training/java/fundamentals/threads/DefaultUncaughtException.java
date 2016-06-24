package com.epam.training.java.fundamentals.threads;

public class DefaultUncaughtException {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(
                (t, e) -> System.out.println(t + " (default handler)throws exception: " + e));

        Runnable myRunnable = () -> { throw new RuntimeException(); };
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t2.setUncaughtExceptionHandler(
                (t, e) -> System.out.println(t + " throws exception: " + e));

        t1.start();
        t2.start();
    }
}