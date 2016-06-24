package com.epam.training.java.fundamentals.threads;

public class UncaughtException {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            throw new RuntimeException("It is a greate exception.");
        });

        t.setUncaughtExceptionHandler(
                (t1, e) -> System.out.println(t + " throws exception: " + e)
        );

        t.start();
    }
}