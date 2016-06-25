package com.epam.training.java.fundamentals.threads.synchronization;

@SuppressWarnings("WeakerAccess")
@FunctionalInterface
public interface Operator extends Runnable {
    @Override
    default void run() {
        for(int i=0; i<5; i++)
            operation();
    }

    void operation();
}