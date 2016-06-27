package com.epam.training.java.fundamentals.threads.synchronization;

@SuppressWarnings("WeakerAccess")
@FunctionalInterface
public interface Operator extends Runnable {

    int STEPS = 5;

    @Override
    default void run() {
        for(int i = 0; i < STEPS; i++)
            operation();
    }

    void operation();
}