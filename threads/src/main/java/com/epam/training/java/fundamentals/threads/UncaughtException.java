package com.epam.training.java.fundamentals.threads;

public class UncaughtException {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            throw new RuntimeException("It is a great exception.");
        });

        t.setUncaughtExceptionHandler(
                (t1, e) -> System.out.println(t1 + " throws exception: " + e)
        );

        t.start();
    }
}